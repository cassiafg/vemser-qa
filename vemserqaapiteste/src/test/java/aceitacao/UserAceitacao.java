package aceitacao;

import aceitacao.dtos.ReturnDTO;
import aceitacao.dtos.UserPayloadDTO;
import aceitacao.service.UserService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UserAceitacao {
    UserService userService = new UserService();

    //Massa de dados para body
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    //Método de teste

    @Test  //POST - criar um array de usuários
    public void createWithArray() throws IOException{
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/listofuser.json");

        //POST - Chamada para o serviço
        ReturnDTO resulService = userService.adicionarArray(jsonBody);

        //Validações
        Assert.assertEquals(resulService.getCode(), "200");
        Assert.assertEquals(resulService.getType(), "unknown");
        Assert.assertEquals(resulService.getMessage(), "ok");
    }

    @Test  //POST - criar uma lista de usuários
    public void createWithList() throws IOException{
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/listofuser.json");

        //POST - Chamada para o serviço
        ReturnDTO resulService = userService.adicionarList(jsonBody);

        //Validações
        Assert.assertEquals(resulService.getCode(), "200");
        Assert.assertEquals(resulService.getType(), "unknown");
        Assert.assertEquals(resulService.getMessage(), "ok");
    }

    @Test  //GET - listar um usuário pelo username
    public void listarUser() throws IOException{
        adicionarUser();
        String userName = "fake";

        //GET - Chamada para o serviço
        UserPayloadDTO resulService = userService.listarUser(userName);

        //Validações
        Assert.assertEquals(resulService.getId(), "3");
        Assert.assertEquals(resulService.getUsername(), "fake");
        Assert.assertEquals(resulService.getFirstName(), "Fake");
        Assert.assertEquals(resulService.getLastName(), "Fake");
        Assert.assertEquals(resulService.getEmail(), "fake@fake.com");
        Assert.assertEquals(resulService.getPassword(), "string");
        Assert.assertEquals(resulService.getPhone(), "string");
        Assert.assertEquals(resulService.getUserStatus(), "0");
    }

    @Test  //PUT - alterar um usuário
    public void editarUser() throws IOException{
        adicionarUser();
        String userName = "fake";

        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/user-edit.json");

        //PUT - Chamada para o serviço
        ReturnDTO resulService = userService.editarUser(jsonBody, userName);

        //Validações
        Assert.assertEquals(resulService.getCode(), "200");
        Assert.assertEquals(resulService.getType(), "unknown");
    }

    @Test  //DELETE - deletar um usuário
    public void deletarUser() throws IOException{
        adicionarUser();
        String userName = "fake";

        //DELETE - Chamada para o serviço
        ReturnDTO resulService = userService.deletarUser(userName);

        //Validações
        Assert.assertEquals(resulService.getCode(), "200");
        Assert.assertEquals(resulService.getType(), "unknown");
        Assert.assertEquals(resulService.getMessage(), userName);
    }

    @Test  //GET - login
    public void loginUser() throws IOException{
        adicionarUser();
        String userName = "fake";
        String password = "string";

        //GET - Chamada para o serviço
        ReturnDTO resulService = userService.listarLoggedUser(userName, password);

        //Validações
        Assert.assertEquals(resulService.getCode(), "200");
        Assert.assertEquals(resulService.getType(), "unknown");
    }

    @Test  //GET - logout
    public void logoutUser() throws IOException{
        adicionarUser();

        //GET - Chamada para o serviço
        ReturnDTO resulService = userService.logoutUser();

        //Validações
        Assert.assertEquals(resulService.getCode(), "200");
        Assert.assertEquals(resulService.getType(), "unknown");
        Assert.assertEquals(resulService.getMessage(), "ok");
    }

    @Test  //POST - criar um usuário
    public void createUser() throws IOException{
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/user.json");

        //POST - Chamada para o serviço
        ReturnDTO resulService = userService.adicionarUser(jsonBody);

        //Validacao
        Assert.assertEquals(resulService.getCode(), "200");
        Assert.assertEquals(resulService.getType(), "unknown");
    }

    private ReturnDTO adicionarUser() throws IOException{
        String jsonBody = lerJson("src/test/resources/data/user.json");
        return userService.adicionarUser(jsonBody);
    }
}
