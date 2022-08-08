package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.MenuPage;
import util.Browser;

public class MenuSteps extends Browser {
    LoginSteps loginSteps = new LoginSteps();
    MenuPage menuPage = new MenuPage();
    @Test
    public void logoutComSucesso(){
        //Login
        loginSteps.loginComSucesso();
        //Acessar menu
        menuPage.clicarBtnMenu();
        //Clicar logout
        menuPage.clicarBtnLogout();
        //Validaçõa
        Assert.assertEquals(menuPage.validarMsgLogout(), "Password for all users:");
    }
    @Test
    public void logoutSemSucessoClicarBtnAbout(){
        //Login
        loginSteps.loginComSucesso();
        //Acessar menu
        menuPage.clicarBtnMenu();
        //Clicar about
        menuPage.clicarBtnAbout();
        //Validaçõa
        Assert.assertEquals(menuPage.validarMsgAbout(), "DEVELOP WITH CONFIDENCE");
    }
    @Test
    public void logoutSemSucessoClicarBtnAllItens(){
        //Login
        loginSteps.loginComSucesso();
        //Acessar menu
        menuPage.clicarBtnMenu();
        //Clicar all itens
        menuPage.clicarBtnAllItens();
        //Validaçõa
        Assert.assertEquals(menuPage.validarMsgAllItens(), "© 2022 Sauce Labs. All Rights Reserved. Terms of Service | Privacy Policy");
    }
}
