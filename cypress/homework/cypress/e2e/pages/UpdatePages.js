import Utils from "../utils/Utils";
const utils = new Utils

import UpdateElements from "../elements/UpdateElements";
const updateElements = new UpdateElements

export default class UpdatePage{
    abrirNavegador(){
        utils.navegar(updateElements.url())
    }

    clicarBtnEditar(){
        utils.click(updateElements.btnEditar())
    }

    editarName(){
        utils.preencherInputClear(updateElements.campoNome(), 'Fernanda')
    }

    editarLastName(){
        utils.preencherInputClear(updateElements.campoLastName(), 'Martins')
    }

    editarEmail(){
        utils.preencherInputClear(updateElements.campoEmail(), 'fernanda@fakemail.com')
    }

    clicarBtnCriar(){
        utils.click(updateElements.btnCriar())
    }

    validarMsgSucesso(){
        utils.validarText(updateElements.msgSucesso())
    }

}