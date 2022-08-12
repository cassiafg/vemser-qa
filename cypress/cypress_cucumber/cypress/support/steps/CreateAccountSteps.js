/// <reference types="cypress" />

import CreateAccountPage from "../pages/CreateAccountPage";
const createAccountPage = new CreateAccountPage()

Given("que acesso o sistema {}", (site) =>{
    createAccountPage.navegar(site)
})

And("preencho com email", () => {
    createAccountPage.preencherEmail()
})

And("clico no botao create", () => {
    createAccountPage.clicarNoBtnCreate()
})

And("clico no botao gender", () => {
    createAccountPage.clicarNoBtnGender()
})

And("preencho com firstname {}", (firstname) => {
    createAccountPage.preencherFirstName(firstname)
})

And("preencho com lastname {}", (lastname) => {
    createAccountPage.preencherLastName(lastname)
})

And('preencho com password {}', (password) => {
    createAccountPage.preencherPassword(password)
})

And('preencho com company {}', (company) => {
    createAccountPage.preencherCompany(company)
})

And('preencho com address {}', (address) => {
    createAccountPage.preencherAddress(address)
})

And('preencho com city {}', (city) => {
    createAccountPage.preencherCity(city)
})

And('seleciono o state', () => {
    createAccountPage.selecionarState()
})

And('preencho com postalcode {}', (postalcode) => {
    createAccountPage.preencherPostalcode(postalcode)
})

And('preencho com phone {}', (phone) => {
    createAccountPage.preencherPhone(phone)
})

And('clico no botao register', () => {
    createAccountPage.clicarNoBtnRegister()
})

And('preencho com email {}', (email) => {
    createAccountPage.preencherEmailExample(email)
})

Then('devo visualizar mensagem de erro', (mensagem) => {
    createAccountPage.validarMsgError(mensagem)
})

Then('devo visualizar botao register', () => {
    createAccountPage.validarBtnRegister()
})

Then('devo visualizar botao create', () => {
    createAccountPage.validarBtnCreate()
})