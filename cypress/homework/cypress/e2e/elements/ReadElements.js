export default class ReadElements{

    url                    ()  { return 'https://automacaocombatista.herokuapp.com/users/11537'                                }
    btnListarUsuarios      ()  { return 'body > div.row > div.col.s3 > ul > li.bold.active > div > ul > li:nth-child(2) > a'   }
    btnVisualizarUsuario   ()  { return 'body > div.row > div > table > tbody > tr:nth-child(10) > td:nth-child(9) > a'        }
    msgNome                ()  { return 'body > div.row > div.col.s9 > div:nth-child(3) > div > p:nth-child(1) > strong'       }

}