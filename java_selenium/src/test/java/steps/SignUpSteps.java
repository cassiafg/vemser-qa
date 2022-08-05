package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.SignUpPage;
import util.Browser;

public class SignUpSteps extends Browser {

    SignUpPage signUpPage = new SignUpPage();

    @Test
    public void cadastrarUsuarioComSucesso(){

        //Acessamos a SignUp
        signUpPage.clicarBtnSignUp();

        //Preencher o formulário
        signUpPage.preencherFirstName();
        signUpPage.preencherSurname();
        signUpPage.preencherEpost();
        signUpPage.preencherMobile();
        signUpPage.preencherUserName();
        signUpPage.preencherPassword();
        signUpPage.preencherConfirmPassword();

        //CLicar no submit
        signUpPage.clicarNoSubmitBtn();

        //Validação
        Assert.assertEquals(signUpPage.validarMsg(), "Add new user");
    }
}
