import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class JacocoXmlToJsonConverter {
    public static void main(String[] args) {
        // Assuming jacoco.xml is in the same directory as the Java class file
        String xmlFilePath = "coverageReport/jacoco.xml";
        String jsonFilePath = "coverageReport/jacoco.json";

        try {
            // Create an XmlMapper object
            XmlMapper xmlMapper = new XmlMapper();
            
            // Read the XML file and convert it to a JsonNode
            JsonNode jsonNode = xmlMapper.readTree(new File(xmlFilePath));
            
            // Create an ObjectMapper object
            ObjectMapper jsonMapper = new ObjectMapper();
            
            // Write the JsonNode to a JSON file
            jsonMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFilePath), jsonNode);
            
            System.out.println("Conversion completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
