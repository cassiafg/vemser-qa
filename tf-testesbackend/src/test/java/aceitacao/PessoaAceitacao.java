package aceitacao;

import aceitacao.dto.PessoaDTO;
import aceitacao.dto.PessoaPagedDTO;
import aceitacao.service.PessoaService;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PessoaAceitacao {
    PessoaService pessoaService = new PessoaService();

    //Massa de dados para body
    public String lerJson(String caminhoJson) throws IOException{
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    //PUT - atualizar os dados de uma pessoa com sucesso
    @Test
    public void editarPessoaComSucesso() throws IOException{
        //Criar pessoa para o teste
        PessoaDTO pessoaCriada = pessoaService.criarPessoaComSucesso(lerJson("src/test/resources/data/pessoa.json"));
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/pessoa-edit.json");
        //PUT - chamada para o serviço
        PessoaDTO resultService = pessoaService.editarPessoaComSucesso(jsonBody, Integer.valueOf(pessoaCriada.getIdPessoa()));
        //Validações
        Assert.assertEquals(resultService.getCpf(),"56448825002");
        Assert.assertEquals(resultService.getNome(), "Rodrigo Martins Motta");
        Assert.assertEquals(resultService.getEmail(), "teste@teste.com");
        //Deletar pessoa criada
        pessoaService.deletarPessoaComSucesso(Integer.valueOf(pessoaCriada.getIdPessoa()));
    }

    //PUT - atualizar os dados de uma pessoa com email inválido
    @Test
    public void editarPessoaComEmailInvalido() throws IOException{
        //Criar pessoa para o teste
        PessoaDTO pessoaCriada = pessoaService.criarPessoaComSucesso(lerJson("src/test/resources/data/pessoa.json"));
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/pessoa-error400.json");
        //PUT - chamada para o serviço
        Response resultService = pessoaService.editarPessoaComEmailInvalido(jsonBody, Integer.valueOf(pessoaCriada.getIdPessoa()));
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 400);
        //Deletar pessoa criada
        pessoaService.deletarPessoaComSucesso(Integer.valueOf(pessoaCriada.getIdPessoa()));
    }

    //PUT - Atualizar os dados de uma pessoa sem autorização
    @Test
    public void editarPessoaSemAutorizacao() throws IOException{
        //Criar pessoa para o teste
        PessoaDTO pessoaCriada = pessoaService.criarPessoaComSucesso(lerJson("src/test/resources/data/pessoa.json"));
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/pessoa-edit.json");
        //PUT - chamada para o serviço
        Response resultService = pessoaService.editarPessoaSemAutorizacao(jsonBody, Integer.valueOf(pessoaCriada.getIdPessoa()));
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 403);
        //Deletar pessoa criada
        pessoaService.deletarPessoaComSucesso(Integer.valueOf(pessoaCriada.getIdPessoa()));
    }

    //DELETE - deletar uma pessoa com sucesso
    @Test
    public void deletarPessoaComSucesso() throws IOException{
        //Criar pessoa para o teste
        PessoaDTO pessoaCriada = pessoaService.criarPessoaComSucesso(lerJson("src/test/resources/data/pessoa.json"));
        //DELETE - chamada para o serviço
        Response resultService = pessoaService.deletarPessoaComSucesso(Integer.valueOf(pessoaCriada.getIdPessoa()));
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    //DELETE - deletar uma pessoa com idPessoa inválido
    @Test
    public void deletarPessoaComIdInexistente() {
        Integer idPessoa = 500000000;
        //DELETE - chamada para o serviço
        Response resultService = pessoaService.deletarPessoaComIdInexistente(idPessoa);
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 404);
    }

    //DELETE - deletar uma pessoa sem autorização
    @Test
    public void deletarPessoaSemAutorizacao() {
        Integer idPessoa = 900;
        //DELETE - chamada para o serviço
        Response resultService = pessoaService.deletarPessoaSemAutorizacao(idPessoa);
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    //GET - listar pessoas por página com sucesso
    @Test
    public void getPessoaPagedComSucesso() {
        Integer pagina = 0;
        Integer tamanho = 10;
        //GET - Chamada para o serviço
        PessoaPagedDTO resultService = pessoaService.listarPessoasPageSizeComSucesso(pagina, tamanho);
        //Validações
        Assert.assertEquals(resultService.getPage(), pagina.toString());
        Assert.assertEquals(resultService.getSize(), tamanho.toString());
    }

    //GET - listar pessoas por página com dados inválidos
    @Test
    public void getPessoaPagedComTamanhoInvalido() {
        Integer pagina = 0;
        Integer tamanho = 0;
        //GET - Chamada para o serviço
        Response resultService = pessoaService.listarPessoasPageSizeComTamanhoInvalido(pagina, tamanho);
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 500);
    }

    //GET - listar pessoas por página sem autorização
    @Test
    public void getPessoaPagedSemAutorizacao() {
        Integer pagina = 0;
        Integer tamanho = 10;
        //GET - Chamada para o serviço
        Response resultService = pessoaService.listarPessoasPageSizeSemAutorizacao(pagina, tamanho);
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    //POST - criar uma pessoa com sucesso
    @Test
    public void criarPessoaComSucesso() throws IOException{
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/pessoa.json");
        //POST - chamada para o serviço
        PessoaDTO resultService = pessoaService.criarPessoaComSucesso(jsonBody);
        //Validações
        Assert.assertEquals(resultService.getCpf(),"56448825002");
        Assert.assertEquals(resultService.getNome(), "Teste Teste");
        Assert.assertEquals(resultService.getEmail(), "testeteste@teste.com");
        //Deletar pessoa criada
        pessoaService.deletarPessoaComSucesso(Integer.valueOf(resultService.getIdPessoa()));
    }

    //POST - criar uma pessoa sem cpf
    @Test
    public void criarPessoaSemCpf() throws IOException{
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/pessoa-sem-cpf.json");
        //POST - chamada para o serviço
        Response resultService = pessoaService.criarPessoaSemCpf(jsonBody);
        //Validações
        Assert.assertEquals(resultService.getStatusCode(),400);
    }

    //POST - criar uma pessoa sem autorização
    @Test
    public void criarPessoaSemAutorizacao() throws IOException{
        //Caminho da massa
        String jsonBody = lerJson("src/test/resources/data/pessoa.json");
        //POST - chamada para o serviço
        Response resultService = pessoaService.criarPessoaSemAutorizacao(jsonBody);
        //Validações
        Assert.assertEquals(resultService.getStatusCode(),403);
    }

    //GET - listar pessoa por cpf com sucesso
    @Test
    public void getPessoaPorCpfComSucesso() throws IOException{
        //Criar pessoa para o teste
        PessoaDTO pessoaCriada = pessoaService.criarPessoaComSucesso(lerJson("src/test/resources/data/pessoa.json"));
        //GET - Chamada para o serviço
        PessoaDTO resultService = pessoaService.listarPessoaPorCpfComSucesso(pessoaCriada.getCpf());
        //Validações
        Assert.assertEquals(resultService.getCpf(), pessoaCriada.getCpf());
        Assert.assertEquals(resultService.getIdPessoa(), pessoaCriada.getIdPessoa());
        Assert.assertEquals(resultService.getEmail(), pessoaCriada.getEmail());
        //Deletar pessoa criada
        pessoaService.deletarPessoaComSucesso(Integer.valueOf(resultService.getIdPessoa()));
    }

    //GET - listar pessoa por cpf inexistente
    @Test
    public void getPessoaPorCpfSemSucesso() {
        //GET - Chamada para o serviço
        Response resultService = pessoaService.listarPessoaPorCpfSemSucesso("31222961016");
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    //GET - listar pessoa por cpf sem autorização
    @Test
    public void getPessoaPorCpfSemAutorizacao() {
        //GET - Chamada para o serviço
        Response resultService = pessoaService.listarPessoaPorCpfSemAutorizacao("81378546067");
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    //GET - listar relatório de pessoas com sucesso
    @Test
    public void getRelatorioPessoasSemIdComSucesso() {
        //GET - Chamada para o serviço
        Response resultService = pessoaService.listarRelatorioPessoas();
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    //GET - listar relatório de pessoas com idPessoa com sucesso
    @Test
    public void getRelatorioPessoasComIdComSucesso() throws IOException{
        //Criar pessoa para o teste
        PessoaDTO pessoaCriada = pessoaService.criarPessoaComSucesso(lerJson("src/test/resources/data/pessoa.json"));
        //GET - Chamada para o serviço
        PessoaDTO[] resultService = pessoaService.listarRelatorioPessoasComId(Integer.valueOf(pessoaCriada.getIdPessoa()));
        //Validações
        Assert.assertEquals(resultService[0].getIdPessoa(), pessoaCriada.getIdPessoa());
        Assert.assertEquals(resultService[0].getNomePessoa(), pessoaCriada.getNome());
        //Deletar pessoa criada
        pessoaService.deletarPessoaComSucesso(Integer.valueOf(resultService[0].getIdPessoa()));
    }

    //GET - listar relatório de pessoas sem autorização
    @Test
    public void getRelatorioPessoasSemAutorizacao() {
        //GET - Chamada para o serviço
        Response resultService = pessoaService.listarRelatorioPessoasSemAutorizacao();
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    //GET - listar pessoa completa com sucesso
    @Test
    public void getPessoasListaCompletaComSucesso() {
        //GET - Chamada para o serviço
        Response resultService = pessoaService.listarPessoaCompletaComSucesso();
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    //GET - listar pessoa completa por idPessoa com sucesso
    @Test
    public void getPessoasListaCompletaComIdComSucesso() throws IOException{
        //Criar pessoa para o teste
        PessoaDTO pessoaCriada = pessoaService.criarPessoaComSucesso(lerJson("src/test/resources/data/pessoa.json"));
        //GET - Chamada para o serviço
        PessoaDTO[] resultService = pessoaService.listarPessoaCompletaComIdComSucesso(Integer.valueOf(pessoaCriada.getIdPessoa()));
        //Validações
        Assert.assertEquals(resultService[0].getIdPessoa(), pessoaCriada.getIdPessoa());
        Assert.assertEquals(resultService[0].getEmail(), pessoaCriada.getEmail());
        //Deletar pessoa criada
        pessoaService.deletarPessoaComSucesso(Integer.valueOf(resultService[0].getIdPessoa()));
    }

    //GET - listar pessoa completa sem autorização
    @Test
    public void getPessoaCompletaSemAutorizacao() {
        //GET - Chamada para o serviço
        Response resultService = pessoaService.listarPessoaCompletaSemAutorizacao();
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    //GET - listar pessoa com endereço com sucesso
    @Test
    public void getPessoasListaComEnderecosComSucesso() {
        //GET - Chamada para o serviço
        Response resultService = pessoaService.listarPessoasComEnderecoComSucesso();
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    //GET - listar pessoa com endereços por idPessoa com sucesso
    @Test
    public void getPessoasListaComEndereçosComIdComSucesso() throws IOException{
        //Criar pessoa para o teste
        PessoaDTO pessoaCriada = pessoaService.criarPessoaComSucesso(lerJson("src/test/resources/data/pessoa.json"));
        //GET - Chamada para o serviço
        PessoaDTO[] resultService = pessoaService.listarPessoaComEnderecosComIdComSucesso(Integer.valueOf(pessoaCriada.getIdPessoa()));
        //Validações
        Assert.assertEquals(resultService[0].getIdPessoa(), pessoaCriada.getIdPessoa());
        Assert.assertEquals(resultService[0].getEmail(), pessoaCriada.getEmail());
        //Deletar pessoa criada
        pessoaService.deletarPessoaComSucesso(Integer.valueOf(resultService[0].getIdPessoa()));
    }

    //GET - listar pessoa com endereços sem autorização
    @Test
    public void getPessoaComEnderecosSemAutorizacao() {
        //GET - Chamada para o serviço
        Response resultService = pessoaService.listarPessoaComEnderecosSemAutorizacao();
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    //GET - listar pessoa com contatos com sucesso
    @Test
    public void getPessoasListaComContatosComSucesso() {
        //GET - Chamada para o serviço
        Response resultService = pessoaService.listarPessoasComContatosComSucesso();
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 200);
    }

    //GET - listar pessoa com contatos por idPessoa com sucesso
    @Test
    public void getPessoasListaComContatosComIdComSucesso() throws IOException{
        //Criar pessoa para o teste
        PessoaDTO pessoaCriada = pessoaService.criarPessoaComSucesso(lerJson("src/test/resources/data/pessoa.json"));
        //GET - Chamada para o serviço
        PessoaDTO[] resultService = pessoaService.listarPessoaComContatosComIdComSucesso(Integer.valueOf(pessoaCriada.getIdPessoa()));
        //Validações
        Assert.assertEquals(resultService[0].getIdPessoa(), pessoaCriada.getIdPessoa());
        Assert.assertEquals(resultService[0].getEmail(), pessoaCriada.getEmail());
        //Deletar pessoa criada
        pessoaService.deletarPessoaComSucesso(Integer.valueOf(resultService[0].getIdPessoa()));
    }

    //GET - listar pessoa com contatos sem autorização
    @Test
    public void getPessoaComContatosSemAutorizacao() {
        //GET - Chamada para o serviço
        Response resultService = pessoaService.listarPessoaComContatosSemAutorizacao();
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    //GET - listar pessoa com contatos sem autorização
    @Test
    public void getPessoaEntreDatasDeNascimentoSemAutorizacao() {
        String data = "1990-01-01";
        String dtFinal = "2020-01-01";
        //GET - Chamada para o serviço
        Response resultService = pessoaService.listarPessoaEntreDatasDeNascimentoSemAutorizacao(data, dtFinal);
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }

    //GET - listar pessoa pelo nome com sucesso
    @Test
    public void getPessoasPeloNomeComSucesso() throws IOException{
        //Criar pessoa para o teste
        PessoaDTO pessoaCriada = pessoaService.criarPessoaComSucesso(lerJson("src/test/resources/data/pessoa.json"));
        //GET - Chamada para o serviço
        PessoaDTO[] resultService = pessoaService.listarPessoaPeloNomeComSucesso(String.valueOf(pessoaCriada.getNome()));
        //Validações
        Assert.assertEquals(resultService[0].getNome(), pessoaCriada.getNome());
        Assert.assertEquals(resultService[0].getEmail(), pessoaCriada.getEmail());
        //Deletar pessoa criada
        pessoaService.deletarPessoaComSucesso(Integer.valueOf(resultService[0].getIdPessoa()));
    }

    //GET - listar pessoa pelo nome sem autorização
    @Test
    public void getPessoaPeloNomeSemAutorizacao() {
        String nome = "Teste";
        //GET - Chamada para o serviço
        Response resultService = pessoaService.listarPessoaPeloNomeSemAutorizacao(nome);
        //Validações
        Assert.assertEquals(resultService.getStatusCode(), 403);
    }
}
