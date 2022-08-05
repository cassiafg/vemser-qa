package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class CreateCustomerPage {
    public static final By name = By.cssSelector("#Name");
    public static final By company = By.cssSelector("#Company");
    public static final By address = By.cssSelector("#Address");
    public static final By city = By.cssSelector("#City");
    public static final By phone = By.cssSelector("#Phone");
    public static final By email = By.cssSelector("#Email");
    public static final By createBtn = By.cssSelector("body > div > form > div > div:nth-child(9) > div > input");

    public void preencherName() {
        BaseTest.sendKeys(name, "teste");
    }

    public void preencherCompany() {
        BaseTest.sendKeys(company, "xyz");
    }

    public void preencherAddress() {
        BaseTest.sendKeys(address, "Rua x");
    }

    public void preencherCity() {
        BaseTest.sendKeys(city, "São Paulo");
    }

    public void preencherPhone() {
        BaseTest.sendKeys(phone, "51-999999000");
    }

    public void preencherEmail() {
        BaseTest.sendKeys(email, "teste@teste.com");
    }

    public void clicarNoCreateBtn() {
        BaseTest.click(createBtn);
    }

}
