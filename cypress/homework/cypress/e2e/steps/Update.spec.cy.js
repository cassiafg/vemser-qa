import UpdatePage from "../pages/UpdatePages";
const updatePage = new UpdatePage

context('Update', () => {
    it('Editar um usuário', () => {
        updatePage.abrirNavegador()
        updatePage.clicarBtnEditar()
        updatePage.editarName()
        updatePage.editarLastName()
        updatePage.editarEmail()
        updatePage.clicarBtnCriar()
        updatePage.validarMsgSucesso()
    })
})