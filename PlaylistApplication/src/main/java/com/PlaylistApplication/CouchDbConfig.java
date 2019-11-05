package com.PlaylistApplication;

import org.ektorp.CouchDbConnector;

import org.ektorp.support.DesignDocument;  

import org.ektorp.CouchDbInstance;
import org.ektorp.http.HttpClient;
import org.ektorp.http.StdHttpClient;
import org.ektorp.impl.StdCouchDbInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.net.MalformedURLException;

@Configuration
@ConfigurationProperties(prefix = "couch")
@EnableConfigurationProperties
public class CouchDbConfig {

    @Value("${couch.host}")
    private String host;
    @Value("${couch.port}")
    private String port;
    @Value("${couch.protocol}")
    private String protocol;
    @Value("${couch.database.name}")
    private String dbName;

    @Bean
    public CouchDbConnector couchDbConnector() {
        HttpClient authenticatedHttpClient = null;
        try {
            authenticatedHttpClient = new StdHttpClient.Builder()
                    .url(protocol + "://" + host + ":" + port)
                    .caching(false)
                    .build();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        CouchDbInstance dbInstance = new StdCouchDbInstance(authenticatedHttpClient);

        CouchDbConnector db = dbInstance.createConnector(dbName, false);        
        
        db.createDatabaseIfNotExists();
        
        
        return db;
    }

}