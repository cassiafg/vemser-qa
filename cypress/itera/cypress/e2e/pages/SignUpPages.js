import Utils from '../utils/utils'
const utils = new Utils

import SignUpElements from '../elements/SignUpElements';
const signUpElements = new SignUpElements

const Chance = require('chance')
const chance = new Chance

let firstname = chance.first()
let lastname = chance.last()
let email = chance.email()
let mobile = chance.phone()
let username = chance.name()
let password = '123456'


export default class SignUpPages {
    abrirNavegador(){
        utils.navegar(signUpElements.url());
    }

    clicarBtnSignUp(){
        utils.click(signUpElements.btnSignUp())
    }

    preencherFirstName(){
        utils.preencherInput(signUpElements.campoFirstName(), firstname)
    }

    preencherSurname(){
        utils.preencherInput(signUpElements.campoSurname(), lastname)
    }

    preencherEpost(){
        utils.preencherInput(signUpElements.campoEpost(), email)
    }

    preencherMobile(){
        utils.preencherInput(signUpElements.campoMobile(), mobile)
    }

    preencherUsername(){
        utils.preencherInput(signUpElements.campoUsername(), username)
    }

    preencherPassword(){
        utils.preencherInput(signUpElements.campoPassword(), password)
    }

    preencherConfirmPassword(){
        utils.preencherInput(signUpElements.campoConfirmPassword(), password)
    }

    preencherConfirmPasswordDiferente(){
        utils.preencherInput(signUpElements.campoConfirmPassword(), 'aaa')
    }

    clicarBtnSubmit(){
        utils.click(signUpElements.btnSubmit())
    }

    validarMsgSucesso(){
        utils.validarText(signUpElements.msgSucesso(), 'Registration Successful')
    }

    validarMsgSurnameError(){
        utils.validarText(signUpElements.msgSurnameError(), 'Please enter surname')
    }

    validarMsgPasswordError(){
        utils.validarText(signUpElements.msgPasswordError(), "'Confirm password' and 'Password' do not match.")
    }
}