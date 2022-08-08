package pages;

import org.openqa.selenium.By;
import util.BaseTest;

public class MenuPage {
    public static final By btnMenu = By.cssSelector("#react-burger-menu-btn");
    public static final By btnLogout = By.cssSelector("#logout_sidebar_link");
    public static final By btnAllItens = By.cssSelector("#inventory_sidebar_link");
    public static final By btnAbout = By.cssSelector("#about_sidebar_link");
    public static final By msgAllItens = By.cssSelector("#page_wrapper > footer > div");
    public static final By msgAbout = By.cssSelector("#entry-3qDFahnypj1KkiORyU1Zyh > div > div > div > div.column.is-full-mobile.is-5-desktop.is.reference-container > div > h1");
    public static final By msgLogout = By.cssSelector("#root > div > div.login_wrapper > div.login_credentials_wrap > div > div.login_password > h4");

    public void clicarBtnMenu(){
        BaseTest.click(btnMenu);
    }
    public void clicarBtnLogout(){
        BaseTest.click(btnLogout);
    }
    public void clicarBtnAllItens(){
        BaseTest.click(btnAllItens);
    }
    public void clicarBtnAbout(){
        BaseTest.click(btnAbout);
    }
    public String validarMsgAllItens(){
        return BaseTest.getText(msgAllItens);
    }
    public String validarMsgAbout(){
        return BaseTest.getText(msgAbout);
    }
    public String validarMsgLogout(){
        return BaseTest.getText(msgLogout);
    }
}
