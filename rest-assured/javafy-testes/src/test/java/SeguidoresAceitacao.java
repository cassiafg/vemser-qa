import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.SeguidoresService;

import java.io.IOException;

public class SeguidoresAceitacao {
    SeguidoresService seguidoresService = new SeguidoresService();

    @Test // POST - seguir um usuário
    public void seguirUsuario() throws IOException{
        Integer idUsuario = 11;

        //POST - Chamada para o serviço
        Response resultService = seguidoresService.seguirUsuario(idUsuario);
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    @Test  //GET - listar seguidores
    public void getSeguidores() throws IOException{
        //GET - Chamada para o serviço
        Response resultService = seguidoresService.listarSeguidores();

        //Validacao
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    @Test  //GET - listar seguindo
    public void getSeguindo() throws IOException{
        //GET - Chamada para o serviço
        Response resultService = seguidoresService.listarSeguindo();

        //Validacao
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    @Test // DELETE - deixar de seguir
    public void deixarDeSeguirUsuario() throws IOException{
        Integer idUsuario = 11;

        //POST - Chamada para o serviço
        Response resultService = seguidoresService.deixarDeSeguir(idUsuario);
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }
}
