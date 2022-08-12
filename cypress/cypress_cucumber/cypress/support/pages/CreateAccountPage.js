/// <reference types="cypress" />

import Utils from '../utils/utils'
const utils = new Utils

import CreateAccountElements from '../elements/CreateAccountElements'
const createAccountElements = new CreateAccountElements

const Chance = require('chance')
const chance = new Chance()

let email = chance.email()

export default class CreateAccountPage {
    navegar(site) {
        utils.navegar(site);
    }

    preencherEmailExample(email){
        utils.preencherInput(createAccountElements.campoEmail, email);
    }

    preencherEmail() {
        utils.preencherInput(createAccountElements.campoEmail, email);
    }

    clicarNoBtnCreate() {
        utils.click(createAccountElements.btnCreate);
        utils.tempo(16000)
    }
    
    clicarNoBtnGender() {
        utils.click(createAccountElements.btnGender);
    }
    
    preencherFirstName(firstname){   
        utils.preencherInput(createAccountElements.campoFirstName, firstname);
    }

    preencherLastName(lastname){
        utils.preencherInput(createAccountElements.campoLastName, lastname);
    
    }
    preencherCompany(company){
        utils.preencherInput(createAccountElements.campoCompany, company);
    }

    preencherPassword(password){
        utils.preencherInput(createAccountElements.campoPassword, password);
    }

    preencherAddress(address){
        utils.preencherInput(createAccountElements.campoAddress, address);
    }

    preencherCity(city){
        utils.preencherInput(createAccountElements.campoCity, city);
    }

    selecionarState(){
        utils.select(createAccountElements.btnState, 'Oregon');
    }

    preencherPostalcode(postalcode){
        utils.preencherInput(createAccountElements.campoPostalCode, postalcode);
    }

    preencherPhone(phone){
        utils.preencherInput(createAccountElements.campoPhone, phone);
    }

    clicarNoBtnRegister(){
        utils.click(createAccountElements.btnRegister);
        utils.tempo(9000)
    }

    validarMsgError(mensagem){
        utils.validarText(createAccountElements.msgError, mensagem);
    }

    validarBtnRegister(){
        utils.validarText(createAccountElements.btnRegister, 'Register');
    }

    validarBtnCreate(){
        utils.validarText(createAccountElements.btnCreate, 'Create an account');
    }
}