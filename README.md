# Проект автоматизации UI и API на Java

## Особенности:

- Автоматизация UI на [Selenide](https://selenide.org/documentation.html)
- Автоматизация API на [REST Assured](https://rest-assured.io/)
- Примеры UI тестов для [parabank](https://parabank.parasoft.com/)
- Примеры API тестов для [crudcrud](https://crudcrud.com/)

## Начало работы

Для работы с проектом необходимо иметь:

- Java (версия 8 или выше)
- Gradle (для управления зависимостями и сборки проекта)
- [JUnit 5](https://junit.org/junit5/)
- [Lombok](https://projectlombok.org/)


## Струтура проекта

- Все тесты по пути /main/src/test/java/org/example

API: 
- Метод для создания API сущности /main/src/test/java/org/example/api/UnicornRequests.java
- Класс для описания JSON /main/src/test/java/org/example/api/models/Unicorn.java

UI:
- Поиск web элементов и методы для UI тестов /main/src/test/java/org/example/ui/pages/RegisterAccountPage.java
- Данные для UI тестов /main/src/test/java/org/example/ui/datas
- Метод для рандомизации данных /main/src/test/java/org/example/utils/RandomData.java
