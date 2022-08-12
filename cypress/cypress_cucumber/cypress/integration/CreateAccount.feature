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
        | http://automationpractice.com/index.php?controller=authentication&back=my-account  |   Anna       | Smith     | 14352     | amazon  | av 4, 205  | Portland |  98547       | 985541230 |
        | http://automationpractice.com/index.php?controller=authentication&back=my-account  |   Rachel     | Geller    | 54321     | google  | av 2, 306  | Portland |  98547       | 966632541 |


    Scenario Outline: Criar uma conta com email ja cadastrado
    Given que acesso o sistema <sistema>
    And preencho com email <email>
    When clico no botao create
    Then devo visualizar botao create

    Examples:
        | sistema                                                                            |   email                    | 
        | http://automationpractice.com/index.php?controller=authentication&back=my-account  |   fake@fake.com            |  
        | http://automationpractice.com/index.php?controller=authentication&back=my-account  |   emailfake@mail.com       |  
        | http://automationpractice.com/index.php?controller=authentication&back=my-account  |   emailemail@email.com     |  

    
Scenario Outline: Criar uma conta sem preencher alguns campos
    Given que acesso o sistema <sistema>
    And preencho com email 
    And clico no botao create
    And clico no botao gender
    And preencho com firstname <firstname>
    And preencho com lastname <lastname>
    And preencho com password <password>
    And preencho com phone <phone>
    When clico no botao register
    Then devo visualizar botao register

    Examples:
        | sistema                                                                            |   firstname  | lastname  |senha      | phone     |
        | http://automationpractice.com/index.php?controller=authentication&back=my-account  |   Maria      | Jones     | 12345     | 999114758 |
        | http://automationpractice.com/index.php?controller=authentication&back=my-account  |   Fernanda   | Smith     | 32541     | 985421102 |
        | http://automationpractice.com/index.php?controller=authentication&back=my-account  |   Amanda     | Martins   | 53241     | 975665201 |