package dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties
public class PlaylistDTO {
    private String idPlaylist;
    private String name;
    private List<MusicaDTO> musicas;
}
