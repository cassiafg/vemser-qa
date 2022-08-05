package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class LoginPage {
    public static final By emailAddress = By.cssSelector("#email");
    public static final By password = By.cssSelector("#passwd");
    public static final By btnSignIn = By.cssSelector("#SubmitLogin");
    public static final By msgMyAccount = By.cssSelector("#columns > div.breadcrumb.clearfix > span.navigation_page");

    public void preencherEmail() {
        BaseTest.sendKeys(emailAddress, "emailfake@mail.com");
    }
    public void preencherEmailInvalido() {
        BaseTest.sendKeys(emailAddress, "email-invalido");
    }
    public void preencherPassword() {
        BaseTest.sendKeys(password, "12345");
    }
    public void preencherPasswordInvalido() {
        BaseTest.sendKeys(password, "36597");
    }
    public void clicarSignIn() {
        BaseTest.click(btnSignIn);
    }
    public String validarMsg() {
        return BaseTest.getText(msgMyAccount);
    }
}
