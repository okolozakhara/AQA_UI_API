package org.example.ui.pages;

import com.codeborne.selenide.*;
import lombok.Getter;
import org.example.ui.datas.BankAccount;

import static com.codeborne.selenide.Selenide.element;

@Getter
public class RegisterAccountPage {

    // Поиск элементов
    private SelenideElement firstNameInput = element(Selectors.byId("customer.firstName"));

    private SelenideElement lastNameInput = element(Selectors.byId("customer.lastName"));

    private SelenideElement addressInput = element(Selectors.byId("customer.address.street"));

    private SelenideElement cityInput = element(Selectors.byId("customer.address.city"));

    private SelenideElement stateInput = element(Selectors.byId("customer.address.state"));

    private SelenideElement zipCodeInput = element(Selectors.byId("customer.address.zipCode"));

    private SelenideElement phoneInput = element(Selectors.byId("customer.phoneNumber"));

    private SelenideElement ssnInput = element(Selectors.byId("customer.ssn"));

    private SelenideElement userNameInput = element(Selectors.byId("customer.username"));

    private SelenideElement passwordInput = element(Selectors.byId("customer.password"));

    private SelenideElement repeatedPasswordInput = element(Selectors.byId("repeated.password"));

    private SelenideElement registerButton = element(Selectors.byValue("Register"));

    // Поля ошибок

    private SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));

    private SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));

    private SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));

    private SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));

    private SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));

    private SelenideElement usernameError = element(Selectors.byId("customer.username.errors"));

    private SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));

    private SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));

    // Методы

    public void open() {
        Selenide.open("/parabank/register.htm");
    }

    public void register(BankAccount bankAccount) {
        if (bankAccount.getFirstName() != null) {
            firstNameInput.sendKeys(bankAccount.getFirstName());
        }
        if (bankAccount.getLastName() != null) {
            lastNameInput.sendKeys(bankAccount.getLastName());
        }
        if (bankAccount.getCity() != null) {
            cityInput.sendKeys(bankAccount.getCity());
        }
        if (bankAccount.getState() != null) {
            stateInput.sendKeys(bankAccount.getState());
        }
        if (bankAccount.getZipCode() != null) {
            zipCodeInput.sendKeys(bankAccount.getZipCode());
        }
        if (bankAccount.getSsn() != null) {
            ssnInput.sendKeys(bankAccount.getSsn());
        }
        if (bankAccount.getUserName() != null) {
            userNameInput.sendKeys(bankAccount.getUserName());
        }
        if (bankAccount.getPassword() != null) {
            passwordInput.sendKeys(bankAccount.getPassword());
        }
        if (bankAccount.getRepeatPassword() != null) {
            repeatedPasswordInput.sendKeys(bankAccount.getRepeatPassword());
        }
        if (bankAccount.getAddress() != null) {
            addressInput.sendKeys(bankAccount.getAddress());
        }
        registerButton.click();

    }
}
