/// <reference types="cypress" />

import Utils from '../utils/Utils'
const utils = new Utils

import AccountElement from '../elements/AccountElement'
const accountElement = new AccountElement

export default class AccountPage {
    validarBtnHome(){
        utils.validarText(accountElement.btnHome, 'Home')
    }
}