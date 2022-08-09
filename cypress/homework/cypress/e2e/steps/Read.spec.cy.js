import ReadPage from "../pages/ReadPages";
const readPage = new ReadPage

context('Read', () => {
    it('visualisar um usuário', () => {
        readPage.abrirNavagador()
        readPage.clicarListaUsuarios()
        readPage.clicarVisualizarUsuario()
        readPage.validarMsgNome()
    })
})