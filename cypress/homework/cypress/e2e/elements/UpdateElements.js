export default class UpdateElements {

    url             ()      { return 'https://automacaocombatista.herokuapp.com/users'                                  }
    btnEditar       ()      { return 'body > div.row > div > table > tbody > tr:nth-child(10) > td:nth-child(10) > a'   }
    campoNome       ()      { return '#user_name'                                                                       }
    campoLastName   ()      { return '#user_name'                                                                       }
    campoEmail      ()      { return '#user_email'                                                                      }
    btnCriar        ()      { return '#edit_user_3571 > div:nth-child(10) > div > div > input[type=submit]'              }
    msgSucesso      ()      { return '#notice'                                                                          }

}