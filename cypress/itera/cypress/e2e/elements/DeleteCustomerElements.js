export default class DeleteCustomerElements {

    btnDelete       ()  { return 'body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-danger'  }
    btnDelete2      ()  { return 'body > div > div > form > div > input'                                                            }
    msgSucesso      ()  { return 'body > div > div > h1'                                                                            }
    msgNaoClicou    ()  { return 'body > div > h2'                                                                                  }
    btnBackToList   ()  { return 'body > div > div > form > div > a'                                                                }
    msgBackToList   ()  { return 'body > div > div > h2'                                                                            }
    
}