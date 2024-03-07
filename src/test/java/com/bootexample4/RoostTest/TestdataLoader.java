
package com.bootexample4.RoostTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Arrays;

// Test Loader loads the data from ENV, Properties File and CSV file in given order.
public class TestdataLoader {

    Properties properties = new Properties();

    private String fromENV(String name) {
      return System.getenv(name);
    }

    private void loadFromPropertiesFile() {
      String propertiesFileNameFromEnv = this.fromENV("PROPERTIES_FILE");
      String propertiesFileName = "";
      if (propertiesFileNameFromEnv == null || propertiesFileNameFromEnv.equals("")) {
        propertiesFileName = "application.properties";
      } else {
        propertiesFileName = propertiesFileNameFromEnv;
      }

      try {
        InputStream content;
        if (propertiesFileName.contains(File.separator)) {
          content = new FileInputStream(propertiesFileName);
        } else {
          content = getClass().getClassLoader().getResourceAsStream(propertiesFileName);
        }

        if (content != null) {
          properties.load(content);
        }
      } catch (IOException e) {
          String errorMessage = e.getMessage();
          System.out.printf("Skip loading from properties file as encountered error : %s" + errorMessage);
      }
    }

    private String fromPropertiesFile(String name) {
      return properties.getProperty(name);
    }

    private List<Map<String, String>> fromCSVFile(String filePath) {
      List<Map<String, String>> data = new ArrayList<>();

      try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        String line;
        boolean headerSkipped = false;
        List<String> headers = new ArrayList<>();

        while ((line = br.readLine()) != null) {
          if (!headerSkipped) {
            headers.addAll(List.of(line.split(",")));
            headerSkipped = true;
            continue;
          }

          String[] values = line.split(",");
          if (values.length > 0) {
            Map<String, String> row = new HashMap<>();
            for (int i = 0; i < Math.min(headers.size(), values.length); i++) {
              row.put(headers.get(i), values[i].trim());
            }
            data.add(row);
          }
        }
      } catch (IOException e) {
          String errorMessage = e.getMessage();
          System.out.printf("Skip loading from csv file : %s" + errorMessage);
      }

      return data;
    }

    public List<Map<String, String>> loadData(String csvFileName) {
      Map<String, String> envMap = new HashMap<>();
      List<Map<String, String>> csvData = this.fromCSVFile(csvFileName);
      List<Map<String, String>> envVars = new ArrayList<>();
      String[] envVarsList = this.getEnvVariableList(csvFileName);
      this.loadFromPropertiesFile();

      for (String key : envVarsList) {
        envMap.put(key, "");
        String value = this.fromENV(key);
        if (value != null) {
          envMap.put(key, value);
        }
        value = this.fromPropertiesFile(key);
        if (value != null) {
          envMap.put(key, value);
        }
      }
      for (Map<String, String> row : csvData) {
        Map<String, String> envMapwithCSV = new HashMap<>(envMap);
        for (Map.Entry<String, String> entry : row.entrySet()) {
          String key = entry.getKey();
          String value = entry.getValue();
          if (!value.equals("")) {
            envMapwithCSV.put(key, value);
          }
        }
        envVars.add(envMapwithCSV);
      }
      return envVars;
    }

    private String[] getEnvVariableList(String csvFileName) {
      String[] envVars = { "BASE_URL", "API_KEY" };
      try (BufferedReader reader = new BufferedReader(new FileReader(csvFileName))) {
        String headerLine = reader.readLine();
        String[] csvHeaders = headerLine.split(",");
        String[] finalEnvArray = Arrays.copyOfRange(envVars, 0, envVars.length + csvHeaders.length);
        System.arraycopy(csvHeaders, 0, finalEnvArray, envVars.length, csvHeaders.length);
        return finalEnvArray;
      } catch (IOException e) {
        e.printStackTrace();
      }
      return envVars;
    }
  }
