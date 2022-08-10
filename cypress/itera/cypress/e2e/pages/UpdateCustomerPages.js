import Utils from "../utils/utils";
const utils = new Utils

import UpdateCustomerElements from "../elements/UpdateCustomerElements";
const updateCustomerElements = new UpdateCustomerElements

const Chance = require('chance')
const chance = new Chance

let name = chance.name()
let company = chance.company()
let address = chance.address()
let city = chance.city()
let phone = chance.phone()
let email = chance.email()

export default class UpdateCustomerPages {
    clicarBtnEdit(){
        utils.click(updateCustomerElements.btnEdit())
    }

    preencherNome(){
        utils.preencherInputClear(updateCustomerElements.campoName(), name)
    }

    preencherCompany(){
        utils.preencherInputClear(updateCustomerElements.campoCompany(), company)
    }

    preencherAddress(){
        utils.preencherInputClear(updateCustomerElements.campoAddress(), address)
    }

    preencherCity(){
        utils.preencherInputClear(updateCustomerElements.campoCity(), city)
    }

    preencherPhone(){
        utils.preencherInputClear(updateCustomerElements.campoPhone(), phone)
    }

    preencherEmail(){
        utils.preencherInputClear(updateCustomerElements.campoEmail(), email)
    }

    clicarBtnSave(){
        utils.click(updateCustomerElements.btnSave())
    }

    validarMensagemSucesso(){
        utils.validarText(updateCustomerElements.msgSucesso(), 'Dashboard')
    }

    clicarBtnBackToList(){
        utils.click(updateCustomerElements.btnBackToList())
    }

    validarMensagemNaoClicou(){
        utils.validarText(updateCustomerElements.msgNaoClicou(), 'Edit')
    }

    validarMensagemMisclick(){
        utils.validarText(updateCustomerElements.msgMisclick(), 'Customer Details')
    }
}