import Utils from "../utils/Utils";
const utils = new Utils

import ReadElements from "../elements/ReadElements";
const readElements = new ReadElements


export default class ReadPage{
    abrirNavagador(){
        utils.navegar(readElements.url())
    }
    
    clicarListaUsuarios(){
        utils.click(readElements.btnListarUsuarios())
    }

    clicarVisualizarUsuario(){
        utils.click(readElements.btnVisualizarUsuario())
    }

    validarMsgNome(){
        utils.validarText(readElements.msgNome(), 'Nome')
    }
}