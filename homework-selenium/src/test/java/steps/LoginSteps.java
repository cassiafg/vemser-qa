package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.HomePage;
import pages.LoginPage;
import util.Browser;

public class LoginSteps extends Browser {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();

    @Test
    public void loginComSucesso(){
        //Acessar o SignIn
        homePage.clicarBtnSignIn();
        //Preencher dados de login
        loginPage.preencherEmail();
        loginPage.preencherPassword();
        loginPage.clicarSignIn();
        //Validação
        Assert.assertEquals(loginPage.validarMsg(), "My account");
    }

    @Test
    public void loginSemSucessoSenhaInvalida(){
        //Acessar o SignIn
        homePage.clicarBtnSignIn();
        //Preencher dados de login
        loginPage.preencherEmail();
        loginPage.preencherPasswordInvalido();
        loginPage.clicarSignIn();
        //Validação
        Assert.assertEquals(loginPage.validarMsg(), "Authentication");
    }

    @Test
    public void loginSemSucessoEmailInvalido(){
        //Acessar o SignIn
        homePage.clicarBtnSignIn();
        //Preencher dados de login
        loginPage.preencherEmailInvalido();
        loginPage.preencherPassword();
        loginPage.clicarSignIn();
        //Validação
        Assert.assertEquals(loginPage.validarMsg(), "Authentication");
    }
}
