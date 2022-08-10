export default class SignUpElements {

    url                     ()  { return 'https://itera-qa.azurewebsites.net/'                          }
    btnSignUp               ()  { return '#navbarColor01 > form > ul > li:nth-child(1) > a'             }
    campoFirstName          ()  { return '#FirstName'                                                   }
    campoSurname            ()  { return '#Surname'                                                     }
    campoEpost              ()  { return '#E_post'                                                      }
    campoMobile             ()  { return '#Mobile'                                                      }
    campoUsername           ()  { return '#Username'                                                    }
    campoPassword           ()  { return '#Password'                                                    }
    campoConfirmPassword    ()  { return '#ConfirmPassword'                                             }
    btnSubmit               ()  { return '#submit'                                                      }
    msgSucesso              ()  { return 'body > div > form > div > div:nth-child(11) > div > label'    }
    msgSurnameError         ()  { return '#Surname-error'                                               }
    msgPasswordError        ()  { return '#ConfirmPassword-error'}
    
}