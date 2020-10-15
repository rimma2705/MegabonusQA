### Megabonus QA tests - version - 1.0.0

**Инструкция по установке проекта:**
Скачать и установить jdk текущая версия jdk-8u261-windows-x64 <https://www.java.com/ru/download/>

Прописать jdk в system PATH <https://java-course.ru/begin/install-jdk/>

Скачать и установить maven текущая версия maven 3.5.0

Прописать maven в system PATH <https://www.apache-maven.ru/install.html>

Скачать и установить allure-report  2.7.0 <https://bintray.com/qameta/generic/allure2/2.7.0#files/io%2Fqameta%2Fallure%2Fallure%2F2.7.0>

Прописать allure-report в system PATH боее подробная информация по установке <https://www.swtestacademy.com/allure-testng/>


**Команды для запуска тестов:**
mvn clean test -Dtest=Class - запуск тестов в отдельно взятом классе

mvn clean test -Dtest=Class,Class - запустить тесты из разных классов (сортировка testng отрабатывает только в первом классе - разобраться и исправить)

mvn clean test - запускает тесты по указанному в testng.xml include с разных классов

mvn clean test -Dtest=Class#nameTest - запуск отдельно взятого теста

mvn clean test -Dtest=Class#nameTest+nameTest - запуск нескольких тестов с отдельно взятого класса

mvn clean test -Dtest=Class#nameTest,Class#nameTest+nameTest - запуск отдельно выбранных тестов с разных классов

**Команда для формирования отчета после прохождения тестовых сценариев:**

allure serve target/allure-results формирует отчет

mvn clean чистим отчеты с target/allure-results
