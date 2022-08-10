import Utils from "../utils/utils";
const utils = new Utils

import DeleteCustomerElements from "../elements/DeleteCustomerElements";
const deleteCustomerElements = new DeleteCustomerElements

export default class DeleteCustomerPages {
    clicarBtnDelete(){
        utils.click(deleteCustomerElements.btnDelete())
    }

    clicarBtnDelete2(){
        utils.click(deleteCustomerElements.btnDelete2())
    }

    clicarBtnBackToList(){
        utils.click(deleteCustomerElements.btnBackToList())
    }

    validarMsgSucesso(){
        utils.validarText(deleteCustomerElements.msgSucesso(), 'Dashboard')
    }

    validarMsgNaoClicou(){
        utils.validarText(deleteCustomerElements.msgNaoClicou(), 'Delete')
    }
    
    validarMsgBackToList(){
        utils.validarText(deleteCustomerElements.msgBackToList(), 'Customer Details')
    }
}