package service;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class SeguidoresService {
    String baseuri = "https://javafy-api.herokuapp.com/seguidores";

    public Response seguirUsuario(Integer idUsuario) {
        // REST-ASSURED
        Response result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok") //dado
                .when()
                .post(baseuri+"/seguir-usuario/"+idUsuario)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        return result;
    }

    public Response listarSeguidores(){
        Response result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok")
                .when()
                .get(baseuri + "/to-user")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        return result;
    }

    public Response listarSeguindo(){
        Response result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok")
                .when()
                .get(baseuri + "/from-user")
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        return result;
    }

    public Response deixarDeSeguir(Integer idUsuario){
        Response result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok")
                .when()
                .delete(baseuri + "/deixarDeSeguir-usuario/"+idUsuario)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        return result;
    }
}
