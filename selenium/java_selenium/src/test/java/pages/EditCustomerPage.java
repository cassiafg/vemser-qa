package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class EditCustomerPage {
    public static final By name = By.cssSelector("#Name");
    public static final By company = By.cssSelector("#Company");
    public static final By address = By.cssSelector("#Address");
    public static final By city = By.cssSelector("#City");
    public static final By phone = By.cssSelector("#Phone");
    public static final By email = By.cssSelector("#Email");
    public static final By btnSave = By.cssSelector("body > div > form > div > div:nth-child(10) > div > input");

    public void preencherName() {
        BaseTest.clear(name);
        BaseTest.sendKeys(name, "teste-edit");
    }

    public void preencherCompany() {
        BaseTest.clear(company);
        BaseTest.sendKeys(company, "xyz");
    }

    public void preencherAddress() {
        BaseTest.clear(address);
        BaseTest.sendKeys(address, "Rua x");
    }

    public void preencherCity() {
        BaseTest.clear(city);
        BaseTest.sendKeys(city, "São Paulo");
    }

    public void preencherPhone() {
        BaseTest.clear(phone);
        BaseTest.sendKeys(phone, "51-999999000");
    }

    public void preencherEmail() {
        BaseTest.clear(email);
        BaseTest.sendKeys(email, "teste@teste.com");
    }

    public void clicarNoBtnSave() {
        BaseTest.click(btnSave);
    }
}
