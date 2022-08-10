Feature: CreateAccount

Scenario Outline: Criar uma conta com sucesso
    Given que acesso o sistema <sistema>
    And preencho com email 
    And clico no botao create
    And clico no botao gender
    And preencho com firstname <firstname>
    And preencho com lastname <lastname>
    And preencho com password <password>
    And preencho com company <company>
    And preencho com address <address>
    And preencho com city <city>
    And seleciono o state
    And preencho com postalcode <postalcode>
    And preencho com phone <phone>
    When clico no botao register
    Then devo visualizar botao home

    Examples:
        | sistema                                                                            |   firstname  | lastname  |senha      | company | address    | city     |  postalcode  | phone     |
        | http://automationpractice.com/index.php?controller=authentication&back=my-account  |   Maria      | Jones     | 12345     | google  | av 5, 102  | Portland |  98547       | 999114758 |


