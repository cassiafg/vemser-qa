Feature: Login

Scenario Outline: Validar login de usuario com sucesso
    Given que acesso o sistema <sistema>
    And preencho com username <username> 
    And preencho com senha <senha>
    When clico botao login
    Then devo verificar uma mensagem na tela <msgm> 

    Examples:
        | sistema                                  | username   | senha     | msgm      |
        | https://itera-qa.azurewebsites.net/Login | teste123   | 12345     | Dashboard |
