import Utils from '../utils/utils'
const utils = new Utils

import AutElements from '../elements/AutElements'
const autElements = new AutElements

export default class AutenticacaoPage {
    abrirNavegador(){
        utils.navegar(autElements.url());
    }
}