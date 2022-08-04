package service;

import dto.UserDTO;
import dto.UserPaginadoDTO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UsuarioService {
    String baseuri = "https://javafy-api.herokuapp.com/usuario";

    public UserDTO editarUser(String jsonBody) {
        // REST-ASSURED
        UserDTO result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok") //dado
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .put(baseuri + "/update-user")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(UserDTO.class);
        return result;
    }

    public UserDTO[] listarUsuarios(){
        UserDTO[] result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok")
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(baseuri + "/list-usuario")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(UserDTO[].class);
        return result;
    }

    public UserDTO listarUsuarioById(){
        UserDTO result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok")
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(baseuri + "/find-by-id")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(UserDTO.class);
        return result;
    }

    public UserPaginadoDTO listarUsuariosPaginado(Integer pagina, Integer registro){
        UserPaginadoDTO result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok")
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(baseuri + "/usuario-paginado?pagina="+pagina+"&registro="+registro)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(UserPaginadoDTO.class);
        return result;
    }
}
