package steps;

import org.junit.Assert;
import org.junit.Test;
import pages.*;
import util.Browser;

public class DashboardSteps extends Browser {

    CreateCustomerPage createCustomerPage = new CreateCustomerPage();
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    EditCustomerPage editCustomerPage = new EditCustomerPage();
    DeletePage deletePage = new DeletePage();

    @Test
    public void createCustomer(){
        //fazer login
        loginPage.clicarBtnLogin();
        loginPage.preencherUsername();
        loginPage.preencherPassword();
        loginPage.clicarBtnConfirmarLogin();

        //criar novo customer
        dashboardPage.clicarBtnCreateNew();

        //preencher o formulario
        createCustomerPage.preencherName();
        createCustomerPage.preencherCompany();
        createCustomerPage.preencherAddress();
        createCustomerPage.preencherCity();
        createCustomerPage.preencherPhone();
        createCustomerPage.preencherEmail();

        //clicar no create
        createCustomerPage.clicarNoCreateBtn();

        //Validação
        Assert.assertEquals(dashboardPage.validarMsg(), "Customer Details");
    }

    @Test
    public void buscarCliente(){
        createCustomer();
        //buscar um cliente
        dashboardPage.preencherSearchName();
        dashboardPage.clicarBtnSearch();
    }

    @Test
    public void editarCliente(){
        buscarCliente();

        //clicar no botão editar
        dashboardPage.clicarBtnEdit();

        //preencher formulário
        editCustomerPage.preencherName();
        editCustomerPage.preencherCompany();
        editCustomerPage.preencherAddress();
        editCustomerPage.preencherCity();
        editCustomerPage.preencherPhone();
        editCustomerPage.preencherEmail();

        //clicar no botão save
        editCustomerPage.clicarNoBtnSave();
    }

    @Test
    public void deletarCliente(){
        buscarCliente();

        //clicar no botão delete
        dashboardPage.clicarBtnDelete();

        //confirmar delete
        deletePage.clicarDeleteBtn();
    }
}
