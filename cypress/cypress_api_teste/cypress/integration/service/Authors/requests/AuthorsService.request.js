const API_URL = Cypress.env('API_BASE_URL')

// end point
const authors = '/Authors'
const authorsBooks = '/Authors/authors/books/'

export default class AuthorsService{
    getAllAuthors(){
        return cy.request({
               method: 'GET',
               url: `${API_URL}${authors}`,
               failOnStatusCode: false,
        })
      }
    
      postAuthor(payload){
        return cy.request({
               method: 'POST',
               url: `${API_URL}${authors}`,
               failOnStatusCode: false,
               body: payload
        })
      }

      getAuthorsByIdBook(idBook){
        return cy.request({
               method: 'GET',
               url: `${API_URL}${authorsBooks}${idBook}`,
               failOnStatusCode: false,
        })
      }

      getAuthorsById(id){
        return cy.request({
               method: 'GET',
               url: `${API_URL}${authors}/${id}`,
               failOnStatusCode: false,
        })
      }

      putAuthor(payload,id){
        return cy.request({
               method: 'PUT',
               url: `${API_URL}${authors}/${id}`,
               failOnStatusCode: false,
               body: payload
            })
        }

        deleteAuthor(id){
            return cy.request({
                   method: 'DELETE',
                   url: `${API_URL}${authors}/${id}`,
                   failOnStatusCode: false,
               })
           }
}