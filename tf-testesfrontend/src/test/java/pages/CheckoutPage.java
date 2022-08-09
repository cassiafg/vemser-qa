package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class CheckoutPage {
    public static final By btnCheckout = By.cssSelector("#checkout");
    public static final By firstName = By.cssSelector("#first-name");
    public static final By lastName = By.cssSelector("#last-name");
    public static final By zipCode = By.cssSelector("#postal-code");
    public static final By btnContinue = By.cssSelector("#continue");
    public static final By btnFinish = By.cssSelector("#finish");
    public static final By msgThankYou = By.cssSelector("#checkout_complete_container > h2");
    public static final By msgError = By.cssSelector("#checkout_info_container > div > form > div.checkout_info > div.error-message-container.error > h3");

    public void clicarBtnCheckout(){
        BaseTest.click(btnCheckout);
    }
    public void preencherFirstName(){
        BaseTest.sendKeys(firstName, "Maria");
    }
    public void firstNameEmBranco(){
        BaseTest.sendKeys(firstName, "");
    }
    public void preencherLastName(){
        BaseTest.sendKeys(lastName, "Silva");
    }
    public void lastnameEmBranco(){
        BaseTest.sendKeys(lastName, "");
    }
    public void preencherZipCode(){
        BaseTest.sendKeys(zipCode, "12345");
    }
    public void zipCodeEmBranco(){
        BaseTest.sendKeys(zipCode, "");
    }
    public void clicarBtnContinue(){
        BaseTest.click(btnContinue);
    }
    public void clicarBtnFinish(){
        BaseTest.click(btnFinish);
    }
    public String validarMsgThankYou(){
        return BaseTest.getText(msgThankYou);
    }
    public String validarMsgError(){
        return BaseTest.getText(msgError);
    }
}
