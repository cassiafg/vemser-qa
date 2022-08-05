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
}
