export default class Utils{

    //navegar na url
    navegar(url){
        cy.visit(url)
    }

    //funções de clicks
    click(element){
        cy.get(element).click()
    }

    //funções preencher campos
    preencherInput(element, text){
        cy.get(element).type(text)
    }

    preencherInputClear(element, text){
        cy.get(element).clear()
        cy.get(element).type(text)
    }

    preencherInputComTeclaNoFinal(element, text, tecla){
        cy.get(element).type(text).type(tecla)
    }

    preencherInputForce(element, text){
        cy.get(element).type(text, {force: true})
    }

    //função de tempo
    tempo(tempo){
        cy.wait(tempo)
    }

    //funções de select
    select(element, value){
        cy.get(element).select(value)
    }

    //funções de validação de texto
    validarText(element, text){
        cy.get(element).should('contain', text)
    }

    validarQuantItemNaLista(element, quant){
        cy.get(element).should('have.length', quant)
    }
}