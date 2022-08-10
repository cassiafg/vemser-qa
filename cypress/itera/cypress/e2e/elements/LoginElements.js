export default class LoginElements {

    url                     ()  { return 'https://itera-qa.azurewebsites.net/'                                                                               }
    btnLogin                ()  { return '#navbarColor01 > form > ul > li:nth-child(2) > a'                                                                  }
    campoUsername           ()  { return '#Username'                                                                                                         }
    campoPassword           ()  { return '#Password'                                                                                                         }
    btnConfirmarLogin       ()  { return 'body > div > div:nth-child(4) > form > table > tbody > tr:nth-child(7) > td:nth-child(2) > input.btn.btn-primary'  }
    msgSucesso              ()  { return 'body > div > div > h1'                                                                                             }
    msgError                ()  { return 'body > div > div:nth-child(4) > form > table > tbody > tr:nth-child(5) > td > label'                               }
    btnLogout               ()  { return '#navbarColor01 > form > ul > li:nth-child(2) > a'                                                                  }
    
}  