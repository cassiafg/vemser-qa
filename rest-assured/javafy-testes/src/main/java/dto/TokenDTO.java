package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.restassured.http.Header;
import lombok.Data;


@Data
@JsonIgnoreProperties
public class TokenDTO {
    private Header token;
}
