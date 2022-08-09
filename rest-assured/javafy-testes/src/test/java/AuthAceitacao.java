import dto.UserDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.AuthService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AuthAceitacao {
    AuthService authService = new AuthService();


    //Massa de dados para body
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test  //POST - criar um usuário
    public void createUser() throws IOException {
        String role = "ROLE_ADMIN";
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/user.json");

        //POST - Chamada para o serviço
        UserDTO resulService = authService.criarUser(jsonBody, role);

        //Validacao
        Assert.assertEquals(resulService.getNome(), "teste5");
        Assert.assertEquals(resulService.getDataNascimento(), "2000-10-10");
        Assert.assertEquals(resulService.getGenero(), "F");
        Assert.assertEquals(resulService.getLogin(), "teste5");
        Assert.assertEquals(resulService.getEmail(), "faker@faker.com");
    }

    @Test  //GET - listar usuário logado
    public void getLogged() throws IOException{
        //GET - Chamada para o serviço
        UserDTO resulService = authService.listarLogged();

        //Validacao
        Assert.assertEquals(resulService.getLogin(), "teste5");
        Assert.assertEquals(resulService.getEmail(), "faker@faker.com");
    }

//    @Test  //POST - gerar token
//    public void gerarToken() throws IOException {
//        //Caminho da massa
//        String jsonBody = lerJson("src/test/resources/data/login.json");
//
//        //POST - Chamada para o serviço
//        TokenDTO resulService = userService.tokenUser(jsonBody);
//    }

    @Test  //PUT - editar um usuário
    public void editarUser() throws IOException{
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/login-update.json");

        //PUT - Chamada para o serviço
        UserDTO resultService = authService.editarUser(jsonBody);

        //Validações
        Assert.assertEquals(resultService.getLogin(), "teste5");
    }

    @Test  //DELETE - deletar um usuário
    public void deletarUser() throws IOException{

        Integer idUsuario = 10;

        //DELETE - Chamada para o serviço
        Response resulService = authService.deletarUser(idUsuario);

        //Validações
        Assert.assertEquals(resulService.getStatusCode(), 200);
    }
}
