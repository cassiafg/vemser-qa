package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class MusicaDTO {
    private String id;
    private String name;
    private String disc_number;
    private String popularity;
    private String preview_url;
    private List<ArtistDTO> artists;
}
