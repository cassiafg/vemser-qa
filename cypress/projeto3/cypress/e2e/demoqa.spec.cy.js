context('Todo', () => {
    it('Registrar um usuário no site', () => {
      
        // acessar a url do site
        cy.visit('https://demoqa.com/register');

        //escrever no campo first name
        cy.get('#firstname')
            .type('Maria')

        //escrever no campo last name
        cy.get('#lastname')
            .type('Silva')

        //escrever no campo username
        cy.get('#userName')
            .type('marias')

        //digitar password
        cy.get('#password')
            .type('12345')
        
        //clicar verificacao
        //cy.get('#recaptcha-anchor > div.recaptcha-checkbox-spinner')
        //    .click()
        Cypress.Commands.add('confirmCaptcha', function () {
            cy.get('iframe')
              .first()
              .then((recaptchaIframe) => {
                const body = recaptchaIframe.contents()
                cy.wrap(body).find('#recaptcha-anchor > div.recaptcha-checkbox-spinner').should('be.visible').click()
              })
          })
        
        //clicar register
        cy.get('#register')
            .click()
    })
})