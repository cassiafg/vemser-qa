import DeleteCustomerPages from "../pages/DeleteCustomerPages";
const deleteCustomerPages = new DeleteCustomerPages

import LoginPages from "../pages/LoginPages";
const loginPages = new LoginPages

context('Delete customer', () => {
    it('deletar customer com sucesso', () => {
        loginPages.abrirNavegador()
        loginPages.clicarBtnLogin()
        loginPages.preencherCampoUsername()
        loginPages.preencherCampoPassword()
        loginPages.clicarBtnConfirmarLogin()
        loginPages.validarMensagemSucesso()
        deleteCustomerPages.clicarBtnDelete()
        deleteCustomerPages.clicarBtnDelete2()
        deleteCustomerPages.validarMsgSucesso()
    })
    it('deletar customer sem sucesso (não clicar no segundo delete)', () => {
        loginPages.abrirNavegador()
        loginPages.clicarBtnLogin()
        loginPages.preencherCampoUsername()
        loginPages.preencherCampoPassword()
        loginPages.clicarBtnConfirmarLogin()
        loginPages.validarMensagemSucesso()
        deleteCustomerPages.clicarBtnDelete()
        deleteCustomerPages.validarMsgNaoClicou()
    })
    it('deletar customer com sucesso (clicar no botão back to list)', () => {
        loginPages.abrirNavegador()
        loginPages.clicarBtnLogin()
        loginPages.preencherCampoUsername()
        loginPages.preencherCampoPassword()
        loginPages.clicarBtnConfirmarLogin()
        loginPages.validarMensagemSucesso()
        deleteCustomerPages.clicarBtnDelete()
        deleteCustomerPages.clicarBtnBackToList()
        deleteCustomerPages.validarMsgBackToList()
    })
})