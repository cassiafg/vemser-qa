package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.testng.annotations.Ignore;

@Data
@JsonIgnoreProperties
public class UserDTO {
    private String nome;
    private String dataNascimento;
    private String genero;
    private String login;
    private String email;
    private String idUsuario;
    private String senha;
}
