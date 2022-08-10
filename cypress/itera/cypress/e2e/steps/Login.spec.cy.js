import LoginPages from "../pages/LoginPages";
const loginPages = new LoginPages

context('Login', () => {
    it('login com sucesso', () => {
        loginPages.abrirNavegador()
        loginPages.clicarBtnLogin()
        loginPages.preencherCampoUsername()
        loginPages.preencherCampoPassword()
        loginPages.clicarBtnConfirmarLogin()
        loginPages.validarMensagemSucesso()
        loginPages.clicarBtnLogout()
    })
    it('login sem sucesso (senha inválida)', () => {
        loginPages.abrirNavegador()
        loginPages.clicarBtnLogin()
        loginPages.preencherCampoUsername()
        loginPages.preencherCampoPasswordInvalido()
        loginPages.clicarBtnConfirmarLogin()
        loginPages.validarMensagemError()
    })
    it('login sem sucesso (username inválido)', () => {
        loginPages.abrirNavegador()
        loginPages.clicarBtnLogin()
        loginPages.preencherCampoUsernameInvalido()
        loginPages.preencherCampoPasswordInvalido()
        loginPages.clicarBtnConfirmarLogin()
        loginPages.validarMensagemError()
    })
})

