import AutenticacaoPage from "../pages/AutPages";
const autPages = new AutenticacaoPage;

context('Aut', () => {
    it('registrar um novo usuário', () => {
        autPages.abrirNavegador();
    })
})