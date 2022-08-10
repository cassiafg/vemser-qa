import ReadCustomerPages from "../pages/ReadCustomerPages";
const readCustomerPages = new ReadCustomerPages

import LoginPages from "../pages/LoginPages";
const loginPages = new LoginPages


context('Read Customer', () => {
    it('consultar customer com sucesso', () => {
        loginPages.abrirNavegador()
        loginPages.clicarBtnLogin()
        loginPages.preencherCampoUsername()
        loginPages.preencherCampoPassword()
        loginPages.clicarBtnConfirmarLogin()
        loginPages.validarMensagemSucesso()
        readCustomerPages.preencherCampoSearch()
        readCustomerPages.clicarBtnSearch()
        readCustomerPages.clicarBtnDetails()
        readCustomerPages.validarMsgSucesso()
    })
    it('consultar customer sem sucesso (usuário buscado não existe)', () => {
        loginPages.abrirNavegador()
        loginPages.clicarBtnLogin()
        loginPages.preencherCampoUsername()
        loginPages.preencherCampoPassword()
        loginPages.clicarBtnConfirmarLogin()
        loginPages.validarMensagemSucesso()
        readCustomerPages.preencherCampoSearchInvalido()
        readCustomerPages.clicarBtnSearch()
        readCustomerPages.validarMsgNoMatch()
    })
    it('consultar customer sem sucesso (não clicar no botão details)', () => {
        loginPages.abrirNavegador()
        loginPages.clicarBtnLogin()
        loginPages.preencherCampoUsername()
        loginPages.preencherCampoPassword()
        loginPages.clicarBtnConfirmarLogin()
        loginPages.validarMensagemSucesso()
        readCustomerPages.preencherCampoSearch()
        readCustomerPages.clicarBtnSearch()
        readCustomerPages.validarMsgNaoClicou()
    })
})