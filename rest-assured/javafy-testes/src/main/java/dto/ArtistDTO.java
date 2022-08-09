package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class ArtistDTO {
    private String id;
    private String name;
    private String popularity;
    private String genres;
}