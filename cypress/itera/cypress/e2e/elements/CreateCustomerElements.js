export default class CreateCustomerElements {

    btnCreateNew            ()      { return 'body > div > div > p:nth-child(4) > a'                        } 
    campoName               ()      { return '#Name'                                                        }  
    campoCompany            ()      { return '#Company'                                                     }    
    campoAddress            ()      { return '#Address'                                                     }    
    campoCity               ()      { return '#City'                                                        }
    campoPhone              ()      { return '#Phone'                                                       }   
    campoEmail              ()      { return '#Email'                                                       }   
    btnCreate               ()      { return 'body > div > form > div > div:nth-child(9) > div > input'     }
    btnBackToList           ()      { return 'body > div > div > a'                                         }    
    msgSucesso              ()      { return 'body > div > div > h1'                                        }
    msgNaoClicou            ()      { return 'body > div > h2'                                              }
    msgMisclick             ()      { return 'body > div > div > h2'                                        }                                                                        
}  