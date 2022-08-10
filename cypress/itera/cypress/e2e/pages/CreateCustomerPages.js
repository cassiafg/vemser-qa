import Utils from "../utils/utils";
const utils = new Utils

import CreateCustomerElements from "../elements/CreateCustomerElements";
const createCustomerElements = new CreateCustomerElements

const Chance = require('chance')
const chance = new Chance

let name = chance.name()
let company = chance.company()
let address = chance.address()
let city = chance.city()
let phone = chance.phone()
let email = chance.email()

export default class CreateCustomerPages {
    clicarBtnCreateNew(){
        utils.click(createCustomerElements.btnCreateNew())
    }

    preencherNome(){
        utils.preencherInput(createCustomerElements.campoName(), name)
    }

    preencherCompany(){
        utils.preencherInput(createCustomerElements.campoCompany(), company)
    }

    preencherAddress(){
        utils.preencherInput(createCustomerElements.campoAddress(), address)
    }

    preencherCity(){
        utils.preencherInput(createCustomerElements.campoCity(), city)
    }

    preencherPhone(){
        utils.preencherInput(createCustomerElements.campoPhone(), phone)
    }

    preencherEmail(){
        utils.preencherInput(createCustomerElements.campoEmail(), email)
    }

    clicarBtnCreate(){
        utils.click(createCustomerElements.btnCreate())
    }

    validarMensagemSucesso(){
        utils.validarText(createCustomerElements.msgSucesso(), 'Dashboard')
    }

    validarMensagemNaoClicou(){
        utils.validarText(createCustomerElements.msgNaoClicou(), 'Create')
    }

    validarMensagemMisclick(){
        utils.validarText(createCustomerElements.msgMisclick(), 'Customer Details')
    }
    clicarBtnBackToList(){
        utils.click(createCustomerElements.btnBackToList())
    }
}