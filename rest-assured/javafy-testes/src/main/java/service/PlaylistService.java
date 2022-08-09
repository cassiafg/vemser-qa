package service;

import dto.PlaylistDTO;
import dto.PlaylistPaginadaDTO;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class PlaylistService {
    String baseuri = "https://javafy-api.herokuapp.com/playlist";

    public PlaylistDTO criarPlaylist(String jsonBody) {
        // REST-ASSURED
        PlaylistDTO result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok") //dado
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .post(baseuri+"/criar-playlist")
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PlaylistDTO.class);
        return result;
    }

    public PlaylistDTO editarPlaylist(String jsonBody, Integer idPlaylist) {
        // REST-ASSURED
        PlaylistDTO result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok") //dado
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .when()
                .put(baseuri + "/atualizar-playlist/"+idPlaylist)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PlaylistDTO.class);
        return result;
    }

    public PlaylistDTO listarPlaylistById(Integer idPlaylist){
        PlaylistDTO result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok")
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(baseuri + "/filtrada-por-id-sem-musicas/"+idPlaylist)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PlaylistDTO.class);
        return result;
    }

    public PlaylistDTO listarPlaylistByIdComMusicas(Integer idPlaylist){
        PlaylistDTO result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok")
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(baseuri + "/filtrada-por-id-com-musicas/"+idPlaylist)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PlaylistDTO.class);
        return result;
    }

    public PlaylistPaginadaDTO listarPlaylistsPaginado(Integer pagina, Integer registro){
        PlaylistPaginadaDTO result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok")
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get(baseuri + "/paginacao-playlist?pagina="+pagina+"&qtRegistro="+registro)
                .then()
                .log().all()
                .statusCode(200)
                .extract().as(PlaylistPaginadaDTO.class);
        return result;
    }

    public Response deletarMusicaDaPlaylist(Integer idplaylist, String idMusica){
        Response result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok")
                .log().all()
                .when()
                .delete(baseuri + "/remover-playlist/"+idplaylist+"/musica/"+idMusica)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        return result;
    }

    public Response deletarPlaylist(Integer idplaylist){
        Response result = given().header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ2ZW1zZXItYXBpIiwianRpIjoyOCwiY2FyZ29zIjpbIlJPTEVfQURNSU4iXSwiaWF0IjoxNjU5NTQ3NzQ5LCJleHAiOjE2NTk2MzQxNDl9.6_mmX7wX5OOciFJdFRSm8-G-Ys8XInL9hGhno9Kj4Ok")
                .log().all()
                .when()
                .delete(baseuri + "/deletar-playlist/"+idplaylist)
                .then()
                .log().all()
                .statusCode(200)
                .extract().response();
        return result;
    }
}
