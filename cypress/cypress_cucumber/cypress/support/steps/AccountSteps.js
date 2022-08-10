/// <reference types="cypress" />

import AccountPage from "../pages/AccountPage";
const accountPage = new AccountPage

Then("devo visualizar botao home", () => {
   accountPage.validarBtnHome()
})