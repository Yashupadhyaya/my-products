Feature: אפליקציית מובייל בנק ירושלים

Background:
  Given האפליקציה מותקנת ומשתמש רשום
  And URL הבסיס הוא '${BASE_URL}'
  And כותרת האימות היא '${AUTH_HEADER}'
  And סוג התוכן הוא 'application/json'

Scenario: כניסה לאפליקציה באמצעות מספר זהות וקוד סודי
  When שליחת בקשת POST ל '${BASE_URL}/login'
  And הגוף של הבקשה הוא:
    """
    {
      "id": "123456789",
      "password": "1234"
    }
    """
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'access_token'

Scenario: כניסה לאפליקציה באמצעות זיהוי ביומטרי
  When שליחת בקשת POST ל '${BASE_URL}/biometric-login'
  And הגוף של הבקשה הוא:
    """
    {
      "biometricData": "biometricData"
    }
    """
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'access_token'

Scenario: נעילה אוטומטית לאחר 3 ניסיונות כושלים
  When שליחת בקשת POST ל '${BASE_URL}/login' 3 פעמים עם פרטים שגויים
  Then קוד התגובה צריך להיות 401
  And הגוף של התגובה צריך להכיל 'Account locked'

Scenario: הצגת יתרה כללית לכל חשבון
  When שליחת בקשת GET ל '${BASE_URL}/accounts/balance'
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'total_balance'

Scenario: הצגת פירוט עסקאות 90 יום אחורה
  When שליחת בקשת GET ל '${BASE_URL}/transactions?days=90'
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'transaction_details'

Scenario: הצגת יתרה לניצול
  When שליחת בקשת GET ל '${BASE_URL}/credit-cards/balance'
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'available_balance'

Scenario: חסימת כרטיס זמנית או קבועה
  When שליחת בקשת POST ל '${BASE_URL}/credit-cards/block'
  And הגוף של הבקשה הוא:
    """
    {
      "cardId": "123456789",
      "blockType": "temporary"
    }
    """
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'Card blocked'

Scenario: בקשה להנפקת כרטיס חדש
  When שליחת בקשת POST ל '${BASE_URL}/credit-cards/request-new'
  And הגוף של הבקשה הוא:
    """
    {
      "cardType": "credit"
    }
    """
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'New card request submitted'

Scenario: סימולציה להחזר חודשי לפי סכום ופריסה
  When שליחת בקשת POST ל '${BASE_URL}/loans/simulation'
  And הגוף של הבקשה הוא:
    """
    {
      "amount": 10000,
      "installments": 12
    }
    """
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'monthly_payment'

Scenario: בקשה דיגיטלית לבדיקה ואישור
  When שליחת בקשת POST ל '${BASE_URL}/loans/request'
  And הגוף של הבקשה הוא:
    """
    {
      "amount": 10000,
      "installments": 12
    }
    """
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'Loan request submitted'

Scenario: צפייה בסטטוס של הלוואות פעילות ובקשות
  When שליחת בקשת GET ל '${BASE_URL}/loans/status'
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'loan_status'

Scenario: פתיחת פנייה לנציג
  When שליחת בקשת POST ל '${BASE_URL}/support/new-ticket'
  And הגוף של הבקשה הוא:
    """
    {
      "subject": "Support request",
      "details": "Need assistance with my account"
    }
    """
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'Ticket created'

Scenario: קבלת תשובות והיסטוריית פניות
  When שליחת בקשת GET ל '${BASE_URL}/support/tickets'
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'ticket_history'

Scenario: זמינות מערכת
  When שליחת בקשת GET ל '${BASE_URL}/health'
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'System is available'

Scenario: ביצועים
  When שליחת בקשת GET ל '${BASE_URL}/performance'
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'Response time within 2 seconds'

Scenario: תמיכה בשפות
  When שליחת בקשת GET ל '${BASE_URL}/languages'
  Then קוד התגובה צריך להיות 200
  And הגוף של התגובה צריך להכיל 'Supported languages: Hebrew, English'
