export default class AutElements {

    url             ()  { return 'https://automacaocombatista.herokuapp.com/users/new'          }
    campoNome       ()  { return '#user_name'                                                   }
    campoLastName   ()  { return '#user_lastname'                                               }
    campoEmail      ()  { return '#user_email'                                                  }
    btnCriar        ()  { return '#new_user > div:nth-child(7) > div > div > input[type=submit]'}
    msgSucesso      ()  { return '#notice'                                                      }
}