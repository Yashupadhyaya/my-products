Feature: אפליקציית מובייל בנק ירושלים

Background:
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  And הכותרת של האימות היא '${AUTH_HEADER}'
  And סוג התוכן הוא 'application/json'

Scenario: כניסה לאפליקציה באמצעות מספר זהות וקוד סודי
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת POST ל '/login' עם גוף הבקשה:
  """
  {
    "id": "123456789",
    "secretCode": "123456"
  }
  """
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'כניסה מוצלחת'

Scenario: כניסה לאפליקציה באמצעות זיהוי ביומטרי
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת POST ל '/biometric-login' עם גוף הבקשה:
  """
  {
    "biometricData": "biometricData"
  }
  """
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'כניסה מוצלחת'

Scenario: נעילה אוטומטית לאחר 3 ניסיונות כושלים
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת POST ל '/login' עם גוף הבקשה:
  """
  {
    "id": "123456789",
    "secretCode": "wrongCode"
  }
  """
  And שליחת בקשת POST ל '/login' עם גוף הבקשה:
  """
  {
    "id": "123456789",
    "secretCode": "wrongCode"
  }
  """
  And שליחת בקשת POST ל '/login' עם גוף הבקשה:
  """
  {
    "id": "123456789",
    "secretCode": "wrongCode"
  }
  """
  Then הקוד של התגובה צריך להיות 401
  And הגוף של התגובה צריך להכיל 'ניסיונות כושלים'

Scenario: צפייה בפרטי חשבון
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת GET ל '/account-details'
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'יתרה כללית', 'פירוט עסקאות', 'מספר חשבון', 'מזהה סניף'

Scenario: העברות כספים לחשבון פנימי
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת POST ל '/transfer' עם גוף הבקשה:
  """
  {
    "toAccount": "987654321",
    "amount": 100
  }
  """
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'העברה מוצלחת'

Scenario: העברות כספים לחשבון חיצוני
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת POST ל '/external-transfer' עם גוף הבקשה:
  """
  {
    "toAccount": "123456789",
    "amount": 100
  }
  """
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'העברה מוצלחת'

Scenario: הוספת מוטב חדש
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת POST ל '/add-beneficiary' עם גוף הבקשה:
  """
  {
    "beneficiaryDetails": "details",
    "smsCode": "123456"
  }
  """
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'הוספת מוטב מוצלחת'

Scenario: שמירת מוטב
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת POST ל '/save-beneficiary' עם גוף הבקשה:
  """
  {
    "beneficiaryDetails": "details"
  }
  """
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'שמירת מוטב מוצלחת'

Scenario: תזמון העברה לתאריך עתידי
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת POST ל '/schedule-transfer' עם גוף הבקשה:
  """
  {
    "toAccount": "987654321",
    "amount": 100,
    "futureDate": "2025-12-31"
  }
  """
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'תזמון העברה מוצלח'

Scenario: חסימת כרטיס זמנית
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת POST ל '/block-card' עם גוף הבקשה:
  """
  {
    "cardNumber": "123456789"
  }
  """
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'חסימת כרטיס זמנית מוצלחת'

Scenario: בקשה להנפקת כרטיס חדש
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת POST ל '/request-new-card' עם גוף הבקשה:
  """
  {
    "requestDetails": "details"
  }
  """
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'בקשה להנפקת כרטיס חדש מוצלחת'

Scenario: סימולציה להחזר חודשי
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת POST ל '/loan-simulation' עם גוף הבקשה:
  """
  {
    "loanAmount": 10000,
    "installments": 12
  }
  """
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'סימולציה מוצלחת'

Scenario: בקשה דיגיטלית לבדיקה ואישור
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת POST ל '/digital-loan-request' עם גוף הבקשה:
  """
  {
    "requestDetails": "details"
  }
  """
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'בקשה דיגיטלית מוצלחת'

Scenario: פתיחת פנייה לנציג
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת POST ל '/open-ticket' עם גוף הבקשה:
  """
  {
    "ticketDetails": "details"
  }
  """
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'פתיחת פנייה מוצלחת'

Scenario: קבלת תשובות והיסטוריית פניות
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת GET ל '/ticket-history'
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'תשובות והיסטוריית פניות'

Scenario: אבטחת מידע
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת GET ל '/security-info'
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'אבטחת מידע מובטחת'

Scenario: זמינות מערכת
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת GET ל '/system-availability'
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'זמינות מערכת לפחות 99.5%'

Scenario: ביצועים
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת GET ל '/performance-metrics'
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'תגובה לכל פעולה עד 2 שניות'

Scenario: תמיכה בשפות
  Given האדרס הבסיסי של ה-API הוא '${BASE_URL}'
  When שליחת בקשת GET ל '/language-support'
  Then הקוד של התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'תמיכה בשפות עברית ואנגלית'
