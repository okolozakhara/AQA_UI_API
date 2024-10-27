package org.example;

import com.codeborne.selenide.*;
import org.example.ui.datas.BankAccount;
import org.example.ui.pages.RegisterAccountPage;
import org.example.utils.RandomData;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUITest {

    @BeforeAll
    public static void setUpUiTests() {
        Configuration.baseUrl = "https://parabank.parasoft.com";
        Configuration.timeout = 10;
    }

    @Test
    public void userCanCreateAccount() {
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // Генерация пароля, что бы повторить его потом
        String password = RandomData.generatePassword();

        // Подготовка данных

        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .address(RandomData.randomString())
                .city(RandomData.randomString())
                .state(RandomData.randomString())
                .zipCode(RandomData.randomInt())
                .phone(RandomData.randomInt())
                .ssn(RandomData.randomString())
                .userName(RandomData.randomString())
                .password(password)
                .repeatedPassword(password)
                .build();

        // Шаги теста
        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата

        registerAccountPage.getWelcome().shouldHave(Condition.text("Welcome "));

    }

    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly() {

        // Подготовка страницы
        RegisterAccountPage registerAccountPage = new RegisterAccountPage();
        registerAccountPage.open();

        // Подготовка данных

        BankAccount bankAccount = BankAccount.builder()
                .firstName(RandomData.randomString())
                .lastName(RandomData.randomString())
                .build();

        // Шаги теста
        registerAccountPage.register(bankAccount);

        // Проверка ожидаемого результата

        registerAccountPage.getAddressError().shouldHave(Condition.exactText("Address is required."));
        registerAccountPage.getCityError().shouldHave(Condition.exactText("City is required."));
        registerAccountPage.getStateError().shouldHave(Condition.exactText("State is required."));
        registerAccountPage.getZipCodeError().shouldHave(Condition.exactText("Zip Code is required."));
        registerAccountPage.getSsnError().shouldHave(Condition.exactText("Social Security Number is required."));
        registerAccountPage.getUsernameError().shouldHave(Condition.exactText("Username is required."));
        registerAccountPage.getPasswordError().shouldHave(Condition.exactText("Password is required."));
        registerAccountPage.getRepeatedPasswordError().shouldHave(Condition.exactText("Password confirmation is required."));

    }

}
