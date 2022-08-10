import Utils from "../utils/utils";
const utils = new Utils

import ReadCustomerElements from "../elements/ReadCustomerElements";
const readCustomerElements = new ReadCustomerElements

export default class ReadCustomerPages {
    preencherCampoSearch(){
        utils.preencherInput(readCustomerElements.campoSearch(), 'teste')
    }
    preencherCampoSearchInvalido(){
        utils.preencherInput(readCustomerElements.campoSearch(), 'x')
    }
    clicarBtnSearch(){
        utils.click(readCustomerElements.btnSearch())
    }
    clicarBtnDetails(){
        utils.click(readCustomerElements.btnDetails())
    }
    validarMsgSucesso(){
        utils.validarText(readCustomerElements.msgSucesso(), 'Details')
    }
    validarMsgNoMatch(){
        utils.validarText(readCustomerElements.msgNoMatch(), 'No Match')
    }
    validarMsgNaoClicou(){
        utils.validarText(readCustomerElements.msgNaoClicou(), 'Dashboard')
    }
}