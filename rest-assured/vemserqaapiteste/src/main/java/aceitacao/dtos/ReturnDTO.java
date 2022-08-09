package aceitacao.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class ReturnDTO {
    private String code;
    private String type;
    private String message;
}
