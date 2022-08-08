package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class LoginPage {

    public static final By username = By.cssSelector("#user-name");
    public static final By password = By.cssSelector("#password");
    public static final By btnLogin = By.cssSelector("#login-button");
    public static final By msgProducts = By.cssSelector("#header_container > div.header_secondary_container > span");
    public static final By msgUserInv = By.cssSelector("#login_button_container > div > form > div.error-message-container.error > h3");

    public void preencherUsernameValido() {
        BaseTest.sendKeys(username, "standard_user");
    }
    public void preencherUsernameInvalido() {
        BaseTest.sendKeys(username, "fake_user");
    }
    public void preencherPasswordValido() {
        BaseTest.sendKeys(password, "secret_sauce");
    }
    public void preencherPasswordInvalido() {
        BaseTest.sendKeys(password, "36597");
    }
    public void naoPreencherUsername(){BaseTest.sendKeys(username, "");}
    public void naoPreencherPassword(){BaseTest.sendKeys(password, "");}
    public void clicarLogin() {
        BaseTest.click(btnLogin);
    }
    public String validarMsgProducts(){ return BaseTest.getText(msgProducts);}
    public String validarMsgUserInv(){ return BaseTest.getText(msgUserInv);}
}
