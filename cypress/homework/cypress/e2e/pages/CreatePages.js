import Utils from '../utils/utils'
const utils = new Utils

import AutElements from '../elements/CreateElements'
const autElements = new AutElements


export default class CreatePage {
    abrirNavegador(){
        utils.navegar(autElements.url());
    }

    preencherNome(){
        utils.preencherInput(autElements.campoNome(), 'Marina')
    }

    preencherLastName(){
        utils.preencherInput(autElements.campoLastName(), 'Silva')
    }

    preencherEmail(){
        utils.preencherInput(autElements.campoEmail(), 'email@fake.com')
    }

    clicarCriar(){
        utils.click(autElements.btnCriar())
    }

    validarMensagem(){
        utils.validarText(autElements.msgSucesso(), 'Usuário Criado com sucesso')
    }
}