import AuthorsService from "../requests/AuthorsService.request";
const authorsService = new AuthorsService()

const payloadAddAuthor = require("../payload/Add-author-1.json");
const payloadAddAuthor2 = require("../payload/Add-author-2.json");

context('Authors', () => {

    it('GET - Consultar authors', () => {

        // Chamada service
        authorsService.getAllAuthors().as('response')

        // Validações
        cy.get('@response').should((response) => {
           expect(response.status).to.eq(200);
           expect(response.body).to.be.not.null;
         })
                                   
      });

      it('POST - Adicionar um novo author', () => {

        // Chamada service
        authorsService.postAuthor(payloadAddAuthor).as('response')

        // Validações
        cy.get('@response').should((response) => {
           expect(response.status).to.eq(200);
           expect(response.body.id).to.eq(9);
           expect(response.body.firstName).to.eq('Virginia');
         })                                   
    });

    it('GET - Consultar um author pelo idBook', () => {

        const idBook = 20;

        // Consulta um author pelo idBook
        authorsService.getAuthorsByIdBook(idBook).as('response') 

        // Validações
        cy.get('@response').should((response) => {
           expect(response.status).to.eq(200);
         })                                    
    });

    it('GET - Consultar um author pelo seu id', () => {

        const id = 5;

        // Consulta um author pelo seu id
        authorsService.getAuthorsById(id).as('response') 

        // Validações
        cy.get('@response').should((response) => {
            expect(response.status).to.eq(200);
        })})
        
        
    it('PUT - Alterar author', () => {

        const id = 5;
    
        // Exclui o livro
        authorsService.putAuthor(payloadAddAuthor2,id).as('response') 
    
        // Validações
        cy.get('@response').should((response) => {
            expect(response.status).to.eq(200);
        })                               
    });
    
    it('DELETE - Deletar  author', () => {
    
        const id = 5;
    
        // Adiciona um author 
        authorsService.postAuthor(payloadAddAuthor2).as('response')
    
        // Exclui o livro
        authorsService.deleteAuthor(id).as('response') 
    
        // Validações
        cy.get('@response').should((response) => {
           expect(response.status).to.eq(200);
         })                                    
    });
});

