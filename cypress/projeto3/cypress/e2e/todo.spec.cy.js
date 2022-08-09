

context('Todo', () => {
  it('Inserir uma nova tarefa na lista', () => {
    
    // acessar a url do site
    cy.visit('https://todomvc.com/examples/react/#/');

    //escrever no campo
    cy.get('body > section > div > header > input')
        .type('vem ser qa {enter}')

    //click forçado
    cy.get('body > section > div > header > input')
        .click();

    //validação
    cy.get('ul.todo-list li').should('have.length', 1)

    //clicar no primeiro da lista
    cy.get('input.toggle').click();

    //filtrar
    cy.get('body > section > div > footer > ul > li:nth-child(3) > a')

    //validação
    cy.get('body > section > div > section > ul > li').should('have.length', 1)
  })
})