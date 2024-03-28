# unibel-test-task
Описание эндпоитнов:
1) Добавление нового клиента
   - URL: 'http://localhost:8080/client' 
   - Method: POST 
   - Request Body: 
     { 
      "name":"MyName" 
     } 
   - Response: 201 Created 
2) Добавление нового контакта клиента (телефон или email)
   - URL: 'http://localhost:8080/client/{clientId}/contact' 
   - Method: POST 
   - Parameters: 
     - 'clientId' (path) - Client Id 
   - Request Body: 
     { 
      "contactType":"EMAIL", 
      "contactValue":"email1@email.com" 
     } <br>
     (contactType can only be two types ('PHONE','EMAIL'))
   - Response: 201 Created 
3) Получение списка клиентов
   - URL: 'http://localhost:8080/clients'
   - Method: GET 
   - Response:
     [ 
    { 
        "clientId": 1, 
        "name": "Nikita", 
        "contacts": [ 
            { 
                "contactId": 1, 
                "contactType": "EMAIL", 
                "contactValue": "email1@email.com" 
            } 
        ] 
    }, 
    {
        "clientId": 2, 
        "name": "Ivan", 
        "contacts": [] 
    } 
] 
4) Получение информации по заданному клиенту (по id)
   - URL: 'http://localhost:8080/client/{clientId}' 
   - Method: GET 
   - Parameters: 
     - 'clientId' (path) - Client Id 
   - Response:
     {
    "clientId": 2,
    "name": "Ivan",
    "contacts": []
    }
5) Получение списка контактов заданного клиента
   - URL: 'http://localhost:8080/client/{clientId}/contacts' 
   - Method: GET 
   - Parameters: 
     - 'clientId' (path) - Client Id 
   - Response:
     [
      {
          "contactId": 1,
          "contactType": "EMAIL",
          "contactValue": "email1@email.com"
      }
     ]
  6) Получение списка контактов заданного типа заданного клиента
     - URL: 'http://localhost:8080/client/{clientId}/contacts/types?contactType={contactType}' 
   - Method: GET 
   - Parameters: 
     - 'clientId' (path) - Client Id
     - 'contactType' (request) - contact Type. there can only be two types ('PHONE','EMAIL') 
   - Response:
     [
    {
        "contactId": 1,
        "contactType": "EMAIL",
        "contactValue": "email1@email.com"
    },
    {
        "contactId": 3,
        "contactType": "EMAIL",
        "contactValue": "email2@email.com"
    }
]
