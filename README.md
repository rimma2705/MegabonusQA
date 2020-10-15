Version - 1.0.0
allure serve target/allure-results сформировать отчет после прогона тестовых сценариев
mvn clean test -Dtest=Class   запуск тестов в отдельно взятом классе
mvn clean test -Dtest=Class,Class  запустить тесты из разных классов (сортировка testng отрабатываеи только в первом классе - разобраться и исправить)
mvn clean test - запускает тесты по указанному в testng.xml include с разных классов 
mvn clean test -Dtest=Class#nameTest запуск отдельно взятого теста
mvn clean test -Dtest=Class#nameTest+nameTest запуск нескольких тестов с отдельно взятого класса
mvn clean test -Dtest=Class,Class#nameTest+nameTest  работает только для первого класса (разобраться и исправить)
