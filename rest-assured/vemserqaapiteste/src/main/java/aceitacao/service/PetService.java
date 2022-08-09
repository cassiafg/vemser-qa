package aceitacao.service;

import aceitacao.dtos.ReturnDTO;
import aceitacao.dtos.PetPayloadDTO;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class PetService {

    //definir interface
    String baseuri = "https://petstore.swagger.io/v2/pet";

    public PetPayloadDTO adicionarPet(String jsonBody) {
        // REST-ASSURED
        PetPayloadDTO resul = given() //dado
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PetPayloadDTO.class);
        return resul;
    }

    public PetPayloadDTO editarPet(String jsonBody) {
        // REST-ASSURED
        PetPayloadDTO resul = given() //dado
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .put(baseuri)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PetPayloadDTO.class);
        return resul;
    }

    public PetPayloadDTO listarPet(Integer petId) {
        String geturi = baseuri +"/"+ petId;
        // REST-ASSURED
        PetPayloadDTO resul = given() //dado
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(geturi)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PetPayloadDTO.class);
        return resul;
    }

    public ReturnDTO deletarPet(Integer petId) {
        String deleteuri = baseuri +"/"+ petId;
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
}
