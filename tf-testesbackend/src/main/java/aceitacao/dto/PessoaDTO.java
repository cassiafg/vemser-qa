package aceitacao.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class PessoaDTO {
    private String nome;
    private String dataNascimento;
    private String cpf;
    private String email;
    private String idPessoa;
    private String nomePessoa;
    private String nomePet;
    private String numeroContato;
    private String cep;
    private String cidade;
    private String estado;
    private String pais;
    private List<String> contatos;
    private List<String> enderecos;
}
