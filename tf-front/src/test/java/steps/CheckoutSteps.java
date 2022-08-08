package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.CheckoutPage;
import util.Browser;

public class CheckoutSteps extends Browser {
    InventorySteps inventorySteps = new InventorySteps();
    CheckoutPage checkoutPage = new CheckoutPage();

    @Test
    public void finalizarCompraBackpackComSucesso(){
        //Adicionar backpack ao carrinho
        inventorySteps.adicionarBackpackAoCarrinhoComSucesso();
        //Finalizar compra
        checkoutPage.clicarBtnCheckout();
        checkoutPage.preencherFirstName();
        checkoutPage.preencherLastName();
        checkoutPage.preencherZipCode();
        checkoutPage.clicarBtnContinue();
        checkoutPage.clicarBtnFinish();
        //Validação
        Assert.assertEquals(checkoutPage.validarMsgThankYou(), "THANK YOU FOR YOUR ORDER");
    }
    @Test
    public void finalizarCompraBackpackSemSucessoLastnameEmBranco(){
        //Adicionar backpack ao carrinho
        inventorySteps.adicionarBackpackAoCarrinhoComSucesso();
        //Finalizar compra
        checkoutPage.clicarBtnCheckout();
        checkoutPage.preencherFirstName();
        checkoutPage.lastnameEmBranco();
        checkoutPage.preencherZipCode();
        checkoutPage.clicarBtnContinue();
        //Validação
        Assert.assertEquals(checkoutPage.validarMsgError(), "Error: Last Name is required");
    }
    @Test
    public void finalizarCompraBackpackSemSucessoFirstNameEmBranco(){
        //Adicionar backpack ao carrinho
        inventorySteps.adicionarBackpackAoCarrinhoComSucesso();
        //Finalizar compra
        checkoutPage.clicarBtnCheckout();
        checkoutPage.firstNameEmBranco();
        checkoutPage.preencherLastName();
        checkoutPage.preencherZipCode();
        checkoutPage.clicarBtnContinue();
        //Validação
        Assert.assertEquals(checkoutPage.validarMsgError(), "Error: First Name is required");
    }
    @Test
    public void finalizarCompraBackpackSemSucessoZipcodeEmBranco(){
        //Adicionar backpack ao carrinho
        inventorySteps.adicionarBackpackAoCarrinhoComSucesso();
        //Finalizar compra
        checkoutPage.clicarBtnCheckout();
        checkoutPage.preencherFirstName();
        checkoutPage.preencherLastName();
        checkoutPage.zipCodeEmBranco();
        checkoutPage.clicarBtnContinue();
        //Validação
        Assert.assertEquals(checkoutPage.validarMsgError(), "Error: Postal Code is required");
    }
}
