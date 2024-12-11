package com.example.springproject.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class ReleaseGroupResponse {

    @JsonProperty("release-groups")
    private List<MusicBrainzAlbum> releaseGroups;

}
