/// <reference types="cypress" />

import Utils from '../utils/utils'
const utils = new Utils

import LoginElement from '../elements/LoginElement'
const loginElement = new LoginElement;

export default class LoginPage {

    navegar(site) {
        utils.navegar(site);
    }

    preencherUsername(username){
        utils.preencherInput(loginElement.loginUsername, username);
    }

    preencherPassword(senha){
        utils.preencherInput(loginElement.loginPassword, senha);

    }

    clicarNoLoginBtn(){
        utils.click(loginElement.loginBtn);

    }
}