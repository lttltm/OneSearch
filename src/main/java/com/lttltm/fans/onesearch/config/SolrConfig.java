package com.lttltm.fans.onesearch.config;

import javax.annotation.Resource;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.solr.core.SolrOperations;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.repository.config.EnableSolrRepositories;
import org.springframework.data.solr.server.support.MulticoreSolrServerFactory;


@Configuration
@EnableSolrRepositories(basePackages={"com.lttltm.fans.onesearch.solr.repository"},multicoreSupport=true)
public class SolrConfig {
	
	private static final String PROPERTY_NAME_SOLR_SERVER_URL = "solr.host";
	
	private static final String PROPERTY_NAME_SOLR_CORE = "solr.core";

	@Resource
	private Environment environment;
	
	@Bean
	public SolrServer solrServer() {
		
		return new HttpSolrServer(environment.getRequiredProperty(PROPERTY_NAME_SOLR_SERVER_URL));
	}
	
	@Bean
	public MulticoreSolrServerFactory multicoreSolrServerFactory() {
		
		String [] core = environment.getRequiredProperty(PROPERTY_NAME_SOLR_CORE).split(",");
		
		return new MulticoreSolrServerFactory(solrServer(), core);
	}

}
