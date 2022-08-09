import dto.UserDTO;
import dto.UserPaginadoDTO;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.UsuarioService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class UsuarioAceitacao {
    UsuarioService usuarioService = new UsuarioService();

    //Massa de dados para body
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test  //PUT - editar um usuário
    public void updateUser() throws IOException{
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/usuario-update.json");

        //PUT - Chamada para o serviço
        UserDTO resultService = usuarioService.editarUser(jsonBody);

        //Validações
        Assert.assertEquals(resultService.getNome(), "Juliana");
        Assert.assertEquals(resultService.getEmail(), "faker@faker.com");
        Assert.assertEquals(resultService.getDataNascimento(), "2000-10-10");
        Assert.assertEquals(resultService.getGenero(), "F");
    }

    @Test  //GET - listar usuários paginado
    public void getUsersPaginado() throws IOException {
        Integer pagina = 0;
        Integer registro = 10;
        //GET - Chamada para o serviço
        UserPaginadoDTO resultService = usuarioService.listarUsuariosPaginado(pagina, registro);
        //Validações
        Assert.assertEquals(resultService.getPage(), pagina.toString());
        Assert.assertEquals(resultService.getSize(), registro.toString());
    }

    @Test  //GET - listar usuários
    public void getUsers() throws IOException {
        //GET - Chamada para o serviço
        UserDTO[] resultService = usuarioService.listarUsuarios();

        //Validações
        Assert.assertEquals(resultService[0].getNome(), "Rodrigo");
        Assert.assertEquals(resultService[0].getLogin(), "Gui");
        Assert.assertEquals(resultService[1].getNome(), "teste1");
        Assert.assertEquals(resultService[1].getLogin(), "teste1");
    }

    @Test  //GET - listar usuário logado
    public void getLogged() throws IOException {
        //GET - Chamada para o serviço
        UserDTO resultService = usuarioService.listarUsuarioById();

        //Validações
        Assert.assertEquals(resultService.getNome(), "Juliana");
        Assert.assertEquals(resultService.getEmail(), "faker@faker.com");
        Assert.assertEquals(resultService.getDataNascimento(), "2000-10-10");
        Assert.assertEquals(resultService.getGenero(), "F");
    }
}
