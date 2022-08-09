package service;

import dto.UserDTO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthService {

    String baseuri = "https://javafy-api.herokuapp.com/auth";

    public UserDTO criarUser(String jsonBody, String role) {
        // REST-ASSURED
        UserDTO result = given() //dado
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri+"/create-user?cargos="+role)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(UserDTO.class);
        return result;
    }

//    public TokenDTO gerarToken(String jsonBody) {
//        // REST-ASSURED
//        TokenDTO result = given() //dado
//                .contentType(ContentType.JSON)
//                .log().all()
//                .body(jsonBody)
//                .when()
//                .post(baseuri)
//                .then()
//                .log().all()
//                .statusCode(200)
//                .extract().as(TokenDTO.class);
//        return result;
//    }

    public UserDTO listarLogged(){
        UserDTO result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok")
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(baseuri + "/get-islogged")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(UserDTO.class);
        return result;
    }

    public UserDTO editarUser(String jsonBody) {
        // REST-ASSURED
        UserDTO result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok") //dado
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .put(baseuri + "/update-credenciais")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(UserDTO.class);
        return result;
    }

    public Response deletarUser(Integer idUsuario) {
        // REST-ASSURED
        Response result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok") //dado
                .when()
                .delete(baseuri+"/remover/"+idUsuario)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        return result;
    }
}
