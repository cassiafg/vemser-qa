import AutenticacaoPage from "../pages/CreatePages";
const autPages = new AutenticacaoPage;


context('Create', () => {
    it('registrar um novo usuário', () => {
        autPages.abrirNavegador();
        autPages.preencherNome();
        autPages.preencherLastName();
        autPages.preencherEmail();
        autPages.clicarCriar();
        autPages.validarMensagem();
    })
})