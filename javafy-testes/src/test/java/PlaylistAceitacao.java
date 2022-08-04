import dto.PlaylistDTO;
import dto.PlaylistPaginadaDTO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import service.PlaylistService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PlaylistAceitacao {
    PlaylistService playlistService = new PlaylistService();

    //Massa de dados para body
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    @Test  //PUT - atualiza uma playlist
    public void editarPlaylist() throws IOException{
        Integer idPlaylist = 15;
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/playlist-update.json");

        //PUT - Chamada para o serviço
        PlaylistDTO resultService = playlistService.editarPlaylist(jsonBody, idPlaylist);

        //Validações
        Assert.assertEquals(resultService.getIdPlaylist(), idPlaylist.toString());
        Assert.assertEquals(resultService.getName(), "Musicas para relaxar");
    }

    @Test  //POST - cria uma playlist
    public void createPlaylist() throws IOException {
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/playlist.json");

        //POST - Chamada para o serviço
        PlaylistDTO resultService = playlistService.criarPlaylist(jsonBody);

        //Validacao
        Assert.assertEquals(resultService.getName(), "Músicas para academia");
        Assert.assertEquals(resultService.getMusicas(), null);
    }

    @Test  //GET - listar playlists paginado
    public void getPlaylistsPaginado() throws IOException {
        Integer pagina = 0;
        Integer registro = 10;
        //GET - Chamada para o serviço
        PlaylistPaginadaDTO resultService = playlistService.listarPlaylistsPaginado(pagina, registro);
        //Validações
        Assert.assertEquals(resultService.getPage(), pagina.toString());
        Assert.assertEquals(resultService.getSize(), registro.toString());
    }

    @Test //GET - listar playlist pelo id
    public void listarPlaylistByIdSemMusicas() throws IOException{
        Integer idPlaylist = 15;

        //GET - Chamada para o serviço
        PlaylistDTO resultService = playlistService.listarPlaylistById(idPlaylist);

        //Validações
        Assert.assertEquals(resultService.getIdPlaylist(), idPlaylist.toString());
        Assert.assertEquals(resultService.getName(), "Musicas para relaxar");
        Assert.assertEquals(resultService.getMusicas(), null);
    }

    @Test //GET - listar playlist pelo id
    public void listarPlaylistByIdComMusicas() throws IOException{
        Integer idPlaylist = 15;

        //GET - Chamada para o serviço
        PlaylistDTO resultService = playlistService.listarPlaylistById(idPlaylist);

        //Validações
        Assert.assertEquals(resultService.getIdPlaylist(), idPlaylist.toString());
        Assert.assertEquals(resultService.getName(), "Musicas para relaxar");
    }

    @Test //DELETE - deletar uma música da playlist
    public void deletarMusicaDaPlaylist() throws IOException{
        Integer idPlaylist = 15;
        String idMusica = "1oZX407PWkU5ETtmRy3zL8";

        //DELETE - Chamada para o serviço
        Response resultService = playlistService.deletarMusicaDaPlaylist(idPlaylist, idMusica);

        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    @Test //DELETE - deletar uma playlist
    public void deletarPlaylist() throws IOException{
        Integer idPlaylist = 17;

        //DELETE - Chamada para o serviço
        Response resultService = playlistService.deletarPlaylist(idPlaylist);

        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }
}
