/// <reference types="cypress" />

import Utils from '../utils/Utils'
const utils = new Utils

import DashboardElement from '../elements/DashboardElement'
const dashboardElement = new DashboardElement;

export default class DashboardPage {

    validarTextoNaTela(text) {
        utils.validarText(dashboardElement.titleDashboard,text)
    }
}