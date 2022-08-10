import SignUpPages from "../pages/SignUpPages";
const signUpPages = new SignUpPages

context('SignUp', () => {
    it('cadastrar um novo usuário com sucesso', () => {
        signUpPages.abrirNavegador()
        signUpPages.clicarBtnSignUp()
        signUpPages.preencherFirstName()
        signUpPages.preencherSurname()
        signUpPages.preencherEpost()
        signUpPages.preencherMobile()
        signUpPages.preencherUsername()
        signUpPages.preencherPassword()
        signUpPages.preencherConfirmPassword()
        signUpPages.clicarBtnSubmit()
        signUpPages.validarMsgSucesso()
    })
    it('cadastrar um novo usuário sem sucesso (surname em branco)', () => {
        signUpPages.abrirNavegador()
        signUpPages.clicarBtnSignUp()
        signUpPages.preencherFirstName()
        signUpPages.preencherUsername()
        signUpPages.preencherPassword()
        signUpPages.preencherConfirmPassword()
        signUpPages.clicarBtnSubmit()
        signUpPages.validarMsgSurnameError()
    })
    it('cadastrar um novo usuário sem sucesso (password e confirmação diferentes)', () => {
        signUpPages.abrirNavegador()
        signUpPages.clicarBtnSignUp()
        signUpPages.preencherFirstName()
        signUpPages.preencherSurname()
        signUpPages.preencherUsername()
        signUpPages.preencherPassword()
        signUpPages.preencherConfirmPasswordDiferente()
        signUpPages.clicarBtnSubmit()
        signUpPages.validarMsgPasswordError()
    })
})