package com.PlaylistApplication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

@JsonIgnoreProperties(ignoreUnknown = true)
@Component
public class PlayList {
	    
	    @JsonProperty("_id")	
	    private String id;
	    @JsonProperty("_rev")
	    private String revision;
	    private String name;
	    private String description;
	    private List<SongEntity> songList = new ArrayList<SongEntity>();
	    
	    public String getId() {
	        return id;
	    }
	    
	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getRevision() {
	        return revision;
	    }

	    public void setRevision(String revision) {
	        this.revision = revision;
	    }
	        
	    public String getName() {
	        return name;
	    }
	    
	    public void setName(String name) {
	        this.name = name;
	    }

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public List<SongEntity> getSongList() {
			return songList;
		}

		public void setSongList(List<SongEntity> songList) {
			this.songList = songList;
		}

}