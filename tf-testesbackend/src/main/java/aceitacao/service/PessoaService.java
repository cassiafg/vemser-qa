package aceitacao.service;

import aceitacao.dto.PessoaDTO;
import aceitacao.dto.PessoaPagedDTO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PessoaService {
    String baseuri = "https://dbc-pessoa-api.herokuapp.com/pessoa";
    String token = "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoiMiIsImNhcmdvcyI6WyJST0xFX1VTVUFSSU8iLCJST0xFX0FETUlOIiwiUk9MRV9NQVJLRVRJTkciXSwiaWF0IjoxNjU5OTcwMTk2LCJleHAiOjE2NjAwNTY1OTZ9.Ld9-m-3y0VZ_H4602FFhCfNSeUT5eK1GfIiVW1hWuFQ";

    public PessoaDTO editarPessoaComSucesso(String jsonBody, Integer idPessoa){
        PessoaDTO result = given().header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .put(baseuri + "/"+idPessoa)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PessoaDTO.class);
        return result;
    }

    public Response editarPessoaComEmailInvalido(String jsonBody, Integer idPessoa){
        Response result = given().header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .put(baseuri + "/"+idPessoa)
                .then()
                .log().all()
                .statusCode(400)
                .extract().response();
        return result;
    }

    public Response editarPessoaSemAutorizacao(String jsonBody, Integer idPessoa){
        Response result = given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .put(baseuri + "/"+idPessoa)
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
        return result;
    }

    public Response deletarPessoaComSucesso(Integer idPessoa){
        Response result = given().header("Authorization", token)
                .log().all()
                .when()
                .delete(baseuri + "/"+idPessoa)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        return result;
    }

    public Response deletarPessoaComIdInexistente(Integer idPessoa){
        Response result = given().header("Authorization", token)
                .log().all()
                .when()
                .delete(baseuri + "/"+idPessoa)
                .then()
                .log().all()
                .statusCode(404)
                .extract().response();
        return result;
    }

    public Response deletarPessoaSemAutorizacao(Integer idPessoa){
        Response result = given()
                .log().all()
                .when()
                .delete(baseuri + "/"+idPessoa)
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
        return result;
    }

    public PessoaPagedDTO listarPessoasPageSizeComSucesso(Integer pagina, Integer tamanho){
        PessoaPagedDTO result = given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "?pagina="+pagina+"&tamanhoDasPaginas="+tamanho)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PessoaPagedDTO.class);
        return result;
    }

    public Response listarPessoasPageSizeComTamanhoInvalido(Integer pagina, Integer tamanho){
        Response result = given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "?pagina="+pagina+"&tamanhoDasPaginas="+tamanho)
                .then()
                .log().all()
                .statusCode(500)
                .extract().response();
        return result;
    }

    public Response listarPessoasPageSizeSemAutorizacao(Integer pagina, Integer tamanho){
        Response result = given()
                .log().all()
                .when()
                .get(baseuri + "?pagina="+pagina+"&tamanhoDasPaginas="+tamanho)
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
        return result;
    }

    public PessoaDTO criarPessoaComSucesso(String jsonBody){
        PessoaDTO result = given().header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PessoaDTO.class);
        return result;
    }

    public Response criarPessoaSemCpf(String jsonBody){
        Response result = given().header("Authorization", token)
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri)
                .then()
                .log().all()
                .statusCode(400)
                .extract().response();
        return result;
    }

    public Response criarPessoaSemAutorizacao(String jsonBody){
        Response result = given()
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri)
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
        return result;
    }
    public PessoaDTO listarPessoaPorCpfComSucesso(String cpf){
        PessoaDTO result = given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/"+cpf+"/cpf")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PessoaDTO.class);
        return result;
    }
    public Response listarPessoaPorCpfSemSucesso(String cpf){
        Response result = given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/"+cpf+"/cpf")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        return result;
    }
    public Response listarPessoaPorCpfSemAutorizacao(String cpf){
        Response result = given()
                .log().all()
                .when()
                .get(baseuri + "/"+cpf+"/cpf")
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
        return result;
    }

    public Response listarRelatorioPessoas(){
        Response result = given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/relatorio")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        return result;
    }
    public PessoaDTO[] listarRelatorioPessoasComId(Integer idPessoa){
        PessoaDTO[] result = given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/relatorio?idPessoa="+idPessoa)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PessoaDTO[].class);
        return result;
    }

    public Response listarRelatorioPessoasSemAutorizacao(){
        Response result = given()
                .log().all()
                .when()
                .get(baseuri + "/relatorio")
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
        return result;
    }

    public Response listarPessoaCompletaComSucesso(){
        Response result = given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/lista-completa")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        return result;
    }

    public PessoaDTO[] listarPessoaCompletaComIdComSucesso(Integer idPessoa){
        PessoaDTO[] result = given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/lista-completa?idPessoa="+idPessoa)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PessoaDTO[].class);
        return result;
    }

    public Response listarPessoaCompletaSemAutorizacao(){
        Response result = given()
                .log().all()
                .when()
                .get(baseuri + "/lista-completa")
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
        return result;
    }

    public Response listarPessoasComEnderecoComSucesso(){
        Response result = given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/lista-com-enderecos")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        return result;
    }

    public PessoaDTO[] listarPessoaComEnderecosComIdComSucesso(Integer idPessoa){
        PessoaDTO[] result = given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/lista-com-enderecos?idPessoa="+idPessoa)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PessoaDTO[].class);
        return result;
    }

    public Response listarPessoaComEnderecosSemAutorizacao(){
        Response result = given()
                .log().all()
                .when()
                .get(baseuri + "/lista-com-enderecos")
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
        return result;
    }

    public Response listarPessoasComContatosComSucesso(){
        Response result = given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/lista-com-contatos")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        return result;
    }

    public PessoaDTO[] listarPessoaComContatosComIdComSucesso(Integer idPessoa){
        PessoaDTO[] result = given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/lista-com-contatos?idPessoa="+idPessoa)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PessoaDTO[].class);
        return result;
    }

    public Response listarPessoaComContatosSemAutorizacao(){
        Response result = given()
                .log().all()
                .when()
                .get(baseuri + "/lista-com-contatos")
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
        return result;
    }

    public Response listarPessoasEntreDatasDeNascimento(String data, String dtFinal){
        Response result = given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/data-nascimento?data="+data+"&dtFinal="+dtFinal)
                .then()
                .log().all()
                .statusCode(400)
                .extract().response();
        return result;
    }

    public Response listarPessoaEntreDatasDeNascimentoSemAutorizacao(String data, String dtFinal){
        Response result = given()
                .log().all()
                .when()
                .get(baseuri + "/data-nascimento?data="+data+"&dtFinal="+dtFinal)
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
        return result;
    }

    public PessoaDTO[] listarPessoaPeloNomeComSucesso(String nome){
        PessoaDTO[] result = given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/byname?nome="+nome)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PessoaDTO[].class);
        return result;
    }

    public Response listarPessoaPorNomeNaoEncontrado(String nome){
        Response result = given().header("Authorization", token)
                .log().all()
                .when()
                .get(baseuri + "/byname?nome="+nome)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        return result;
    }
    public Response listarPessoaPeloNomeSemAutorizacao(String nome){
        Response result = given()
                .log().all()
                .when()
                .get(baseuri + "/byname?nome="+nome)
                .then()
                .log().all()
                .statusCode(403)
                .extract().response();
        return result;
    }
}
