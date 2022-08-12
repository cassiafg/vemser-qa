import UserService from '../requests/UserService.request';
const userService = new UserService()

const payloadAddUser = require('../payload/Add-user-1.json')
const payloadAddUser2 = require('../payload/Add-user-2.json')

context('Users', () => {
  
    it('GET - Consultar users', () => {

        // Chamada service
        userService.getAllUsers().as('response')

        // Validações
        cy.get('@response').should((response) => {
           expect(response.status).to.eq(200);
           expect(response.body).to.be.not.null;
         })
                                   
      });
    
    it('POST - Adicionar um novo user', () => {

        // Chamada service
        userService.postUser(payloadAddUser).as('response')

        // Validações
        cy.get('@response').should((response) => {
           expect(response.status).to.eq(200);
           expect(response.body.id).to.eq(6);
           expect(response.body.userName).to.eq('Teste');
         })                                   
    });

    
    it('GET - Consultar um usuário pelo seu id', () => {

        const idUser = 6;

        // Adiciona um usuário para o teste 
        userService.postUser(payloadAddUser).as('response')

        // Consulta um usuário pelo seu id
        userService.getUserById(idUser).as('response') 

        // Validações
        cy.get('@response').should((response) => {
           expect(response.status).to.eq(200);
         })                                    
});

    
    it('PUT - Alterar user', () => {

        const idUser = 15;

        // Exclui o livro
        userService.putUser(payloadAddUser2,idUser).as('response') 

        // Validações
        cy.get('@response').should((response) => {
            expect(response.status).to.eq(200);
        })                               
});

it('DELETE - Deletar  user', () => {

    const idUser = 15;

    // Adiciona um livre 
    userService.postUser(payloadAddUser2).as('response')

    // Exclui o livro
    userService.deleteUser(idUser).as('response') 

    // Validações
    cy.get('@response').should((response) => {
       expect(response.status).to.eq(200);
     })                                    
});


})