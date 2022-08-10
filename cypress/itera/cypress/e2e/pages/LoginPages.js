import Utils from "../utils/utils";
const utils = new Utils

import LoginElements from "../elements/LoginElements";
const loginElements = new LoginElements

export default class LoginPages {
    abrirNavegador(){
        utils.navegar(loginElements.url())
    }

    clicarBtnLogin(){
        utils.click(loginElements.btnLogin())
    }

    preencherCampoUsername(){
        utils.preencherInput(loginElements.campoUsername(), 'fernandaa')
    }

    preencherCampoUsernameInvalido(){
        utils.preencherInput(loginElements.campoUsername(), '.')
    }


    preencherCampoPassword(){
        utils.preencherInput(loginElements.campoPassword(), '123456')
    }

    preencherCampoPasswordInvalido(){
        utils.preencherInput(loginElements.campoPassword(), 'abcde')
    }

    clicarBtnConfirmarLogin(){
        utils.click(loginElements.btnConfirmarLogin())
    }

    validarMensagemSucesso(){
        utils.validarText(loginElements.msgSucesso(), 'Dashboard')
    }
    
    validarMensagemError(){
        utils.validarText(loginElements.msgError(), 'Wrong username or password')
    }

    clicarBtnLogout(){
        utils.click(loginElements.btnLogout())
    }
}