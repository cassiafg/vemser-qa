package aceitacao.service;

import aceitacao.dtos.ReturnDTO;
import aceitacao.dtos.UserPayloadDTO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class UserService {
    //definir interface
    String baseuri = "https://petstore.swagger.io/v2/user";

    public ReturnDTO adicionarUser(String jsonBody) {
        // REST-ASSURED
        ReturnDTO resul = given() //dado
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(ReturnDTO.class);
        return resul;
    }

    public ReturnDTO editarUser(String jsonBody, String userName) {
        // REST-ASSURED
        ReturnDTO resul = given() //dado
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .put(baseuri + "/" + userName)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(ReturnDTO.class);
        return resul;
    }
    public ReturnDTO deletarUser(String userName) {
        String deleteuri = baseuri +"/"+ userName;
        // REST-ASSURED
        ReturnDTO resul = given() //dado
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .delete(deleteuri)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(ReturnDTO.class);
        return resul;
    }

    public UserPayloadDTO listarUser(String userName) {
        String geturi = baseuri +"/"+ userName;
        // REST-ASSURED
        UserPayloadDTO resul = given() //dado
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(geturi)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(UserPayloadDTO.class);
        return resul;
    }

    public ReturnDTO listarLoggedUser(String userName, String password) {
        String geturi = baseuri +"/login?username="+ userName+"&password="+password;
        // REST-ASSURED
        ReturnDTO resul = given() //dado
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(geturi)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(ReturnDTO.class);
        return resul;
    }

    public ReturnDTO logoutUser() {
        String geturi = baseuri +"/logout";
        // REST-ASSURED
        ReturnDTO resul = given() //dado
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(geturi)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(ReturnDTO.class);
        return resul;
    }

    public ReturnDTO adicionarArray(String jsonBody) {
        // REST-ASSURED
        ReturnDTO resul = given() //dado
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri + "/createWithArray")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(ReturnDTO.class);
        return resul;
    }

    public ReturnDTO adicionarList(String jsonBody) {
        // REST-ASSURED
        ReturnDTO resul = given() //dado
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri + "/createWithList")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(ReturnDTO.class);
        return resul;
    }
}
