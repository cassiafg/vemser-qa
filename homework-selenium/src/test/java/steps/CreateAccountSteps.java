package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.CreateAccountPage;
import pages.HomePage;
import util.Browser;

public class CreateAccountSteps extends Browser {

    HomePage homepage = new HomePage();
    CreateAccountPage createAccountPage = new CreateAccountPage();

    @Test
    public void cadastrarUsuarioComSucesso(){

        //Acessar o SignIn
        homepage.clicarBtnSignIn();
        createAccountPage.preencherEmail();
        createAccountPage.clicarBtnCreate();

        //Preencher o formulário
        createAccountPage.clicarGenderTitle();
        createAccountPage.preencherFirstName();
        createAccountPage.preencherLastName();
        createAccountPage.preencherPassword();
        createAccountPage.clicarSelectDays();
        createAccountPage.clicarSelectMonth();
        createAccountPage.clicarSelectYear();
        createAccountPage.preencherCompany();
        createAccountPage.preencherAddress();
        createAccountPage.preencherCity();
        createAccountPage.clicarSelectState();
        createAccountPage.preencherPostalCode();
        createAccountPage.preencherMobile();
        createAccountPage.clicarRegister();

        //Validação
        Assert.assertEquals(createAccountPage.validarMsg(), "My account");
    }

    @Test
    public void cadastrarUsuarioSemPreencherCamposObrigatorios(){
        //Acessar o SignIn
        homepage.clicarBtnSignIn();
        createAccountPage.preencherEmail();
        createAccountPage.clicarBtnCreate();

        //Clicar Register
        createAccountPage.clicarRegister();

        //Validação
        Assert.assertEquals(createAccountPage.validarMsgErrors(), "There are 8 errors");
    }

    @Test
    public void cadastrarUsuarioComEmailJaCadastrado(){
        //Acessar o SignIn
        homepage.clicarBtnSignIn();
        createAccountPage.preencherEmailJaCadastrado();
        createAccountPage.clicarBtnCreate();

        //Validação
        Assert.assertEquals(createAccountPage.validarMsgErrorEmail(), "An account using this email address has already been registered. Please enter a valid password or request a new one.");
    }

    @Test
    public void cadastrarUsuarioComEmailInvalido(){
        //Acessar o SignIn
        homepage.clicarBtnSignIn();
        createAccountPage.preencherEmailInvalido();
        createAccountPage.clicarBtnCreate();

        //Validação
        Assert.assertEquals(createAccountPage.validarMsgErrorEmail(), "Invalid email address.");
    }
}
