import BookService from '../requests/BookService.request'
const bookService = new BookService;

const payloadAddBook = require('../payload/Add-book-1.json')
const payloadAddBook2 = require('../payload/Add-book-2.json')

context('Books', () => {

      it('GET - Consultar Livros', () => {

        // Chamada service
        bookService.getAllBook().as('response')

        // Validações
        cy.get('@response').should((response) => {
           expect(response.status).to.eq(200);
           expect(response.body).to.be.not.null;
         })
                                   
      });

      it('POST - Adicionar um novo livro', () => {

                  // Chamada service
                  bookService.postBook(payloadAddBook).as('response')
          
                  // Validações
                  cy.get('@response').should((response) => {
                     expect(response.status).to.eq(200);
                     expect(response.body.id).to.eq(230);
                     expect(response.body.title).to.eq('Testes automatizados');
                   })
                                             
         });

       it('DELETE - Deletar  livro', () => {

                  const idBook = 230;

                  // Adiciona um livre 
                  bookService.postBook(payloadAddBook).as('response')

                  // Exclui o livro
                  bookService.deleteBook(idBook).as('response') 
          
                  // Validações
                  cy.get('@response').should((response) => {
                     expect(response.status).to.eq(200);
                   })                                    
       });

       it('PUT - Alterar livro', () => {

                  const idBook = 230;

                  // Exclui o livro
                  bookService.putBook(payloadAddBook2,idBook).as('response') 
          
                  // Validações
                  cy.get('@response').should((response) => {
                     expect(response.status).to.eq(200);
                   })

                                             
       });
                  
});

            
        