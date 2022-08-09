package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class LoginPage {

    public static final By btnLogin = By.cssSelector("#navbarColor01 > form > ul > li:nth-child(2) > a");
    public static final By username = By.cssSelector("#Username");
    public static final By password = By.cssSelector("#Password");
    public static final By btnConfirmarLogin = By.cssSelector("body > div > div:nth-child(4) > form > table > tbody > tr:nth-child(7) > td:nth-child(2) > input.btn.btn-primary");


    public void clicarBtnLogin() {
        BaseTest.click(btnLogin);
    }

    public void preencherUsername() {
        BaseTest.sendKeys(username, "teste");
    }

    public void preencherPassword() {
        BaseTest.sendKeys(password, "teste");
    }

    public void clicarBtnConfirmarLogin() {
        BaseTest.click(btnConfirmarLogin);
    }

}
