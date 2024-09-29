package org.example;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUITest {

    @Test
    public void userCanCreateAccount() {
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Ivan");
        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Kuzin");

        SelenideElement adress = element(Selectors.byId("customer.address.street"));
        adress.sendKeys("Gagarinsky proezd 3");

        SelenideElement city = element(Selectors.byId("customer.address.city"));
        city.sendKeys("Moskow");

        SelenideElement state = element(Selectors.byId("customer.address.state"));
        state.sendKeys("Moskow");

        SelenideElement zipCode = element(Selectors.byId("customer.address.zipCode"));
        zipCode.sendKeys("119324");

        SelenideElement phone = element(Selectors.byId("customer.phoneNumber"));
        phone.sendKeys("+79111279324");

        SelenideElement ssn = element(Selectors.byId("customer.ssn"));
        ssn.sendKeys("119324");

        SelenideElement userName = element(Selectors.byId("customer.username"));
        userName.sendKeys("OlegKuzin280924");

        SelenideElement password = element(Selectors.byId("customer.password"));
        password.sendKeys("OlegKuzin28092024Password");

        SelenideElement repeatedPassword = element(Selectors.byId("repeated.password"));
        repeatedPassword.sendKeys("OlegKuzin28092024Password");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

    }

    @Test
    public void userCanNotCreateAccountWithNameAndSurnameOnly() {
        Selenide.open("https://parabank.parasoft.com/parabank/register.htm");

        SelenideElement firstName = element(Selectors.byId("customer.firstName"));
        firstName.sendKeys("Ivan");

        SelenideElement lastName = element(Selectors.byId("customer.lastName"));
        lastName.sendKeys("Kuzin");

        SelenideElement registerButton = element(Selectors.byValue("Register"));
        registerButton.click();

        SelenideElement addressError = element(Selectors.byId("customer.address.street.errors"));
        addressError.shouldHave(Condition.exactText("Address is required."));

        SelenideElement cityError = element(Selectors.byId("customer.address.city.errors"));
        cityError.shouldHave(Condition.exactText("City is required."));

        SelenideElement stateError = element(Selectors.byId("customer.address.state.errors"));
        stateError.shouldHave(Condition.exactText("State is required."));

        SelenideElement zipCodeError = element(Selectors.byId("customer.address.zipCode.errors"));
        zipCodeError.shouldHave(Condition.exactText("Zip Code is required."));

        SelenideElement ssnError = element(Selectors.byId("customer.ssn.errors"));
        ssnError.shouldHave(Condition.exactText("Social Security Number is required."));

        SelenideElement usernameError = element(Selectors.byId("customer.username.errors"));
        usernameError.shouldHave(Condition.exactText("Username is required."));

        SelenideElement passwordError = element(Selectors.byId("customer.password.errors"));
        passwordError.shouldHave(Condition.exactText("Password is required."));

        SelenideElement repeatedPasswordError = element(Selectors.byId("repeatedPassword.errors"));
        repeatedPasswordError.shouldHave(Condition.exactText("Password confirmation is required."));
    }

}
