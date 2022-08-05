package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.DressPage;
import pages.TshirtPage;
import util.Browser;

public class AddToCartSteps extends Browser {
    LoginSteps loginSteps = new LoginSteps();
    TshirtPage tshirtPage = new TshirtPage();
    DressPage dressPage = new DressPage();

    @Test
    public void addDressToCartComSucesso(){
        //Login com sucesso
        loginSteps.loginComSucesso();
        //Buscar vestido
        dressPage.searchDress();
        dressPage.btnSubmitSearch();
        //Selecionar vestido
        dressPage.btnPrintedChifonDress();
        dressPage.clicarAddToCart();
        dressPage.clicarBtnProceedToCheckOut();
        //Validação
        Assert.assertEquals(dressPage.validarMsgShoppingCart(), "Your shopping cart");
    }

    @Test
    public void addTshirtToCartComSucesso(){
        //Login com sucesso
        loginSteps.loginComSucesso();
        //Adicionar T-shirt à wishlist
        tshirtPage.clicarTshirt();
        tshirtPage.clicarBtnSelecionarTshirt();
        tshirtPage.clicarAddToCart();
        tshirtPage.clicarProceedToCheckout();
        //Validação
        Assert.assertEquals(tshirtPage.validarMsgCart(), "Your shopping cart");
    }
}
