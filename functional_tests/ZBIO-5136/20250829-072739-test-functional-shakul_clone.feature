Feature: אימות פונקציונליות ואמינות של אפליקציית מובייל בנק ירושלים

Background:
  Given המיישם היסודי של ה-API הוא '${API_BASE_URL}'
  And כותרת האימות היא '${AUTH_HEADER}'
  And סוג התוכן הוא 'application/json'

Scenario: אימות יתרה לא שולמה
  When שליחת בקשה GET ל '/credit-cards/{cardId}/balance'
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'balance' עם ערך הנכון

Scenario: אימות תאריך התשלום
  When שליחת בקשה GET ל '/credit-cards/{cardId}/payment-date'
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'paymentDate' עם ערך הנכון

Scenario: אימות קריאת תשלום לאחר תאריך התשלום
  When שליחת בקשה GET ל '/credit-cards/{cardId}/payment-reminder'
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'reminder' עם ערך הנכון

Scenario: אימות תהליך איסוף תשלום בכרטיס
  When שליחת בקשה POST ל '/credit-cards/{cardId}/collect-payment' עם גוף הבקשה:
  """
  {
    "amount": 100,
    "currency": "ILS"
  }
  """
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'transactionId' עם ערך הנכון

Scenario: אימות עדכון יתרה לאחר תשלום בכרטיס
  When שליחת בקשה POST ל '/credit-cards/{cardId}/collect-payment' עם גוף הבקשה:
  """
  {
    "amount": 100,
    "currency": "ILS"
  }
  """
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'newBalance' עם ערך הנכון

Scenario: אימות זמן תגובה של המערכת
  When שליחת בקשה GET ל '/credit-cards/{cardId}/balance'
  Then זמן התגובה צריך להיות פחות מ-2 שניות

Scenario: אימות יכולת המערכת להתמודד עם עומס גבוה
  When שליחת בקשה GET ל '/credit-cards/{cardId}/balance' עם עומס גבוה של בקשות
  Then המערכת צריכה להתמודד עם העומס הגבוה ללא דעיכה בביצועים

Scenario: אימות אמינות מערכת הקריאות האוטומטיות
  When שליחת בקשה GET ל '/credit-cards/{cardId}/payment-reminder'
  Then המערכת האוטומטית צריכה לפעול ללא תקלות

Scenario: אימות אבטחת תהליך איסוף התשלום
  When שליחת בקשה POST ל '/credit-cards/{cardId}/collect-payment' עם גוף הבקשה:
  """
  {
    "amount": 100,
    "currency": "ILS"
  }
  """
  Then כל העסקאות והפרטים של הכרטיס צריכים להיות מוצפנים

Scenario: אימות זמן השיקום של המערכת
  When שליחת בקשה GET ל '/credit-cards/{cardId}/balance' לאחר התרסה
  Then המערכת צריכה לשקום מהתרסה בזמן מוגדר
