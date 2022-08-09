package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class SignUpPage {
    public static final By btnSignUp = By.cssSelector("#navbarColor01 > form > ul > li:nth-child(1) > a");
    public static final By firstName = By.cssSelector("#FirstName");
    public static final By surname = By.cssSelector("#Surname");
    public static final By epost = By.cssSelector("#E_post");
    public static final By mobile = By.cssSelector("#Mobile");
    public static final By userName = By.cssSelector("#Username");
    public static final By password = By.cssSelector("#Password");
    public static final By confirmPassword = By.cssSelector("#ConfirmPassword");
    public static final By submitBtn = By.cssSelector("#submit");
    public static final By msgSuccess = By.cssSelector("body > div > form > div > div:nth-child(11) > div > label");
    public static final By msgAddNew = By.cssSelector("body > div > h2");

    public void clicarBtnSignUp() {
        BaseTest.click(btnSignUp);
    }

    public void preencherFirstName() {
        BaseTest.sendKeys(firstName, "teste");
    }

    public void preencherSurname() {
        BaseTest.sendKeys(surname, "teste");
    }

    public void preencherEpost() {
        BaseTest.sendKeys(epost, "900040-020");
    }

    public void preencherMobile() {
        BaseTest.sendKeys(mobile, "51-999944572");
    }

    public void preencherUserName() {
        BaseTest.sendKeys(userName, "teste");
    }

    public void preencherPassword() {
        BaseTest.sendKeys(password, "teste");
    }

    public void preencherConfirmPassword() {
        BaseTest.sendKeys(confirmPassword, "teste");
    }

    public void clicarNoSubmitBtn() {
        BaseTest.click(submitBtn);
    }

    public String validarMsg() {
        return BaseTest.getText(msgAddNew);
    }
}

