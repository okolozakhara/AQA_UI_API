package org.example;

import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.element;

public class SimpleUITest {

    @Test
    public void userTest() {
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

}
