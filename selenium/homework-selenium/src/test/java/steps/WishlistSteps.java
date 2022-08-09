package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.DressPage;
import pages.TshirtPage;
import util.Browser;

public class WishlistSteps extends Browser {
    LoginSteps loginSteps = new LoginSteps();
    TshirtPage tshirtPage = new TshirtPage();
    DressPage dressPage = new DressPage();

    @Test
    public void addDressToWishlist(){
        //Login com sucesso
        loginSteps.loginComSucesso();
        //Buscar vestido
        dressPage.searchDress();
        dressPage.btnSubmitSearch();
        //Selecionar vestido
        dressPage.btnPrintedChifonDress();
        //Adicionar à wishlist
        dressPage.clicarBtnAddToWishlist();
        //Validação
        Assert.assertEquals(dressPage.validarMsgAddedToWishlist(), "Added to your wishlist.");
    }

    @Test
    public void addTshirtToWishlist(){
        //Login com sucesso
        loginSteps.loginComSucesso();
        //Adicionar T-shirt à wishlist
        tshirtPage.clicarTshirt();
        tshirtPage.clicarBtnSelecionarTshirt();
        tshirtPage.clicarAddToWishlist();
        //Validação
        Assert.assertEquals(tshirtPage.validarMsgWishlist(), "Added to your wishlist.");
    }
}
