export default class UpdateCustomerElements {

    btnEdit                 ()      { return 'body > div > div > table > tbody > tr:nth-child(2) > td:nth-child(7) > a.btn.btn-outline-primary'     } 
    campoName               ()      { return '#Name'                                                                                                }  
    campoCompany            ()      { return '#Company'                                                                                             }    
    campoAddress            ()      { return '#Address'                                                                                             }    
    campoCity               ()      { return '#City'                                                                                                }
    campoPhone              ()      { return '#Phone'                                                                                               }   
    campoEmail              ()      { return '#Email'                                                                                               }   
    btnSave                 ()      { return 'body > div > form > div > div:nth-child(10) > div > input'                                            }    
    msgSucesso              ()      { return 'body > div > div > h1'                                                                                }  
    btnBackToList           ()      { return 'body > div > div > a'                                                                                 }
    msgNaoClicou            ()      { return 'body > div > h2'                                                                                      }
    msgMisclick             ()      { return 'body > div > div > h2'                                                                                }
                                                                          
}  