export default class ReadCustomerElements {

    campoSearch     ()  { return '#searching'                                                                                       }
    btnSearch       ()  { return 'body > div > div > form > input.btn.btn-secondary.my-2.my-sm-0'                                   }
    btnDetails      ()  { return 'body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-info'    }
    msgSucesso      ()  { return 'body > div > h2'                                                                                  }
    msgNoMatch      ()  { return 'body > div > div > table > tbody > tr:nth-child(2) > td'                                          }
    msgNaoClicou    ()  { return 'body > div > div > h1'                                                                            } 
    
}