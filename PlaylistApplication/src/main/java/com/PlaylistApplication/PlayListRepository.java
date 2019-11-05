package com.PlaylistApplication;

import org.ektorp.support.CouchDbRepositorySupport;
import org.ektorp.support.GenerateView;
import org.ektorp.support.View;
import org.ektorp.CouchDbConnector;
import org.ektorp.ViewQuery;
import org.ektorp.ViewResult;
import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlayListRepository extends CouchDbRepositorySupport<PlayList> {
	
	@Autowired
	public PlayListRepository(CouchDbConnector  db) {
		super(PlayList.class,db);
		initStandardDesignDocument();
	}
	
public int getNoSongs(String playListName) {
	    	ViewQuery query = createQuery("noSongs")
	                //.group(true)
	                .dbPath(db.path())
	                //.designDocId(stdDesignDocumentId)
	                .key(playListName);
	    	ViewResult noSongs = db.queryView(query);
	    	return noSongs.getRows().get(0).getValueAsInt();
	    }

}
