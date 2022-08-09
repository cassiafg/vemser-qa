package aceitacao;

import aceitacao.dtos.ReturnDTO;
import aceitacao.dtos.PetPayloadDTO;
import aceitacao.service.PetService;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PetAceitacao {
    PetService petService = new PetService();

    //Massa de dados para body
    public String lerJson(String caminhoJson) throws IOException{
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    //Método de teste
    @Test  //POST - incluir um pet
    public void incluirPet() throws IOException{
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/pet.json");

        //POST - Chamada para o serviço
        PetPayloadDTO resulService = petService.adicionarPet(jsonBody);

        //Validacao
        Assert.assertEquals(resulService.getId(), "2022000005");
        Assert.assertEquals(resulService.getName(), "doggie");
        Assert.assertEquals(resulService.getStatus(), "available");
    }

    @Test  //PUT - alterar um pet
    public void editarPet() throws IOException{
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/pet-edit.json");

        //PUT - Chamada para o serviço
        PetPayloadDTO resulService = petService.editarPet(jsonBody);

        //Validacao
        Assert.assertEquals(resulService.getId(), "2022000005");
        Assert.assertEquals(resulService.getName(), "teste");
        Assert.assertEquals(resulService.getStatus(), "available");
    }

    @Test  //GET - listar um pet
    public void listarPet() throws IOException{
        Integer idPet = 2022000005;

        //GET - Chamada para o serviço
        PetPayloadDTO resulService = petService.listarPet(idPet);

        //Validacao
        Assert.assertEquals(resulService.getId(), "2022000005");
        Assert.assertEquals(resulService.getStatus(), "available");

    }

    @Test  //DELETE - deletar um pet
    public void deletarPet() throws IOException{
        Integer idPet = 2022000005;

        //DELETE - Chamada para o serviço
        ReturnDTO resulService = petService.deletarPet(idPet);

        //Validacao
        Assert.assertEquals(resulService.getCode(), "200");
        Assert.assertEquals(resulService.getType(), "unknown");
        Assert.assertEquals(resulService.getMessage(), idPet.toString());
    }
}
