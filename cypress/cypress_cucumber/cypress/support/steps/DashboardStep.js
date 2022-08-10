/// <reference types="cypress" />

import DashboardPage from "../pages/DashboardPage";
const dashboardPage = new DashboardPage;

Then("devo verificar uma mensagem na tela {}", (text) => {
   dashboardPage.validarTextoNaTela(text)

})