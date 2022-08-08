package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.InventoryPage;
import util.Browser;

public class InventorySteps extends Browser {
    LoginSteps loginSteps = new LoginSteps();
    InventoryPage inventoryPage = new InventoryPage();
    @Test
    public void adicionarBackpackAoCarrinhoComSucesso(){
        //Login com sucesso
        loginSteps.loginComSucesso();
        //Adicionar backpack ao carrinho
        inventoryPage.clicarBtnAddBackpackToCart();
        inventoryPage.clicarGoToCart();
        //Validação
        Assert.assertEquals(inventoryPage.validarMsgCartBackpack(), "Sauce Labs Backpack");
    }
    @Test
    public void adicionarBackpackAoCarrinhoComSucessoProblemUser(){
        //Login com sucesso
        loginSteps.loginProblemUser();
        //Adicionar backpack ao carrinho
        inventoryPage.clicarBtnAddBackpackToCart();
        inventoryPage.clicarGoToCart();
        //Validação
        Assert.assertEquals(inventoryPage.validarMsgCartBackpack(), "Sauce Labs Backpack");
    }

    @Test
    public void adicionarERemoverBackpackAoCarrinhoComSucesso(){
        //Login com sucesso
        loginSteps.loginComSucesso();
        //Adicionar backpack ao carrinho
        inventoryPage.clicarBtnAddBackpackToCart();
        inventoryPage.clicarBtnRemoveBackpackFromCart();
        inventoryPage.clicarGoToCart();
        //Validação
        Assert.assertEquals(inventoryPage.validarMsgContinueShopping(), "CONTINUE SHOPPING");
    }

    @Test
    public void adicionarERemoverBackpackAoCarrinhoSemSucesso(){
        //Login com sucesso
        loginSteps.loginProblemUser();
        //Adicionar backpack ao carrinho
        inventoryPage.clicarBtnAddBackpackToCart();
        inventoryPage.clicarBtnRemoveBackpackFromCart();
        inventoryPage.clicarGoToCart();
        //Validação
        Assert.assertEquals(inventoryPage.validarMsgCartBackpack(), "Sauce Labs Backpack");
    }

    @Test
    public void ordenarProdutosPorMenorPrecoComSucesso(){
        //Login com sucesso
        loginSteps.loginComSucesso();
        //Ordenar produtos
        inventoryPage.filtrarPorMenorPreco();
        //Validação
        Assert.assertEquals(inventoryPage.validarMsgPriceLowToHigh(), "PRICE (LOW TO HIGH)");
    }
    @Test
    public void ordenarProdutosPorMenorPrecoSemSucesso(){
        //Login com sucesso
        loginSteps.loginProblemUser();
        //Ordenar produtos
        inventoryPage.filtrarPorMenorPreco();
        //Validação
        Assert.assertEquals(inventoryPage.validarMsgPriceLowToHigh(), "NAME (A TO Z)");
    }

    @Test
    public void adicionarBikeLightAoCarrinho(){
        //Login com sucesso
        loginSteps.loginComSucesso();
        //Adicionar bike ligh
        inventoryPage.clicarBtnAddBikeLightToCart();
        inventoryPage.clicarGoToCart();
        //Validação
        Assert.assertEquals(inventoryPage.validarMsgCartBikeLight(),"Sauce Labs Bike Light" );
    }
}
