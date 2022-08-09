

context('Todo', () => {
    it('Registrar um usuário no site', () => {
      
        // acessar a url do site
        cy.visit('https://demo.automationtesting.in/Register.html');

        //escrever no campo first name
        cy.get('#basicBootstrapForm > div:nth-child(1) > div:nth-child(2) > input')
            .type('Maria')

        //escrever no campo last name
        cy.get('#basicBootstrapForm > div:nth-child(1) > div:nth-child(3) > input')
            .type('Silva')

        //escrever no campo e-mail address
        cy.get('#eid > input')
            .type('fake@fake.com')

        //escrever no campo phone 
        cy.get('#basicBootstrapForm > div:nth-child(4) > div > input')
            .type('4083334152')

        //marcar campo gender
        cy.get('#basicBootstrapForm > div:nth-child(5) > div > label:nth-child(2) > input')
            .click()

        //selecionar country
        cy.get('#select2-country-container')
            .click({force: true})
            .type('un')
            .type('{enter}')
        cy.get('#countries')
            .type('Brazil',{force:true})

        //digitar password
        cy.get('#firstpassword')
            .type('12345')
        
        //confirmar password
        cy.get('#secondpassword')
            .type('12345')
    })
})