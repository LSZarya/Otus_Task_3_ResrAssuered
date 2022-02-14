##Запуск тестов Otus дз. №3
***
###Запуск происходит из файла testng.xml

Команда для запуска из командной строки: mvn test -DdefaultSuiteFiles="testng.xml"
***
Описание тестов внутри тестов
***
1. CreateUserArrayTest - Отправляет массив POST (работа с массивами)
2. CreateUserTest - Отправляет POST (работа с post запросом)
3. UserLoginTest - Отправляет GET (работа с get запросом, DataProvide)
4. UserLogoutTest - Отправляет GET (работа с get запросом, DataProvide)

Во всех тестах применялись разные варианты работы RestAssuredSpecification
