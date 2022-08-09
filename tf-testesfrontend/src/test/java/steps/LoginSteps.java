package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import util.Browser;

public class LoginSteps extends Browser {
    LoginPage loginPage = new LoginPage();
    @Test
    public void loginComSucesso(){
        //Preencher dados de login
        loginPage.preencherUsernameValido();
        loginPage.preencherPasswordValido();
        loginPage.clicarLogin();
        //Validações
        Assert.assertEquals(loginPage.validarMsgProducts(), "PRODUCTS");
    }
    @Test
    public void loginSemSucessoUsernameInvalido(){
        //Preencher dados de login
        loginPage.preencherUsernameInvalido();
        loginPage.preencherPasswordValido();
        loginPage.clicarLogin();
        //Validações
        Assert.assertEquals(loginPage.validarMsgUserInv(), "Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void loginSemSucessoPasswordInvalido(){
        //Preencher dados de login
        loginPage.preencherUsernameValido();
        loginPage.preencherPasswordInvalido();
        loginPage.clicarLogin();
        //Validações
        Assert.assertEquals(loginPage.validarMsgUserInv(), "Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public void loginSemSucessoUsernameEmBranco(){
        //Preencher dados de login
        loginPage.naoPreencherUsername();
        loginPage.preencherPasswordInvalido();
        loginPage.clicarLogin();
        //Validações
        Assert.assertEquals(loginPage.validarMsgUserInv(), "Epic sadface: Username is required");
    }
    @Test
    public void loginSemSucessoPasswordEmBranco(){
        //Preencher dados de login
        loginPage.preencherUsernameValido();
        loginPage.naoPreencherPassword();
        loginPage.clicarLogin();
        //Validações
        Assert.assertEquals(loginPage.validarMsgUserInv(), "Epic sadface: Password is required");
    }
    @Test
    public void loginLockedOutUser(){
        //Preencher dados de login
        loginPage.preencherUsernameBlockedUser();
        loginPage.preencherPasswordValido();
        loginPage.clicarLogin();
        //Validações
        Assert.assertEquals(loginPage.validarMsgUserInv(), "Epic sadface: Sorry, this user has been locked out.");
    }
    @Test
    public void loginProblemUser(){
        //Preencher dados de login
        loginPage.preencherUsernameProblemUser();
        loginPage.preencherPasswordValido();
        loginPage.clicarLogin();
        //Validações
        Assert.assertEquals(loginPage.validarMsgProducts(), "PRODUCTS");
    }
    @Test
    public void loginPerformanceGlitchUser(){
        //Preencher dados de login
        loginPage.preencherUsernamePerformanceGlitchUser();
        loginPage.preencherPasswordValido();
        loginPage.clicarLogin();
        //Validações
        Assert.assertEquals(loginPage.validarMsgProducts(), "PRODUCTS");
    }
}
