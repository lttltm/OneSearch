package com.lttltm.fans.onesearch.solr.client;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.solr.server.support.MulticoreSolrServerFactory;
import org.springframework.stereotype.Component;
@Component
public class IndexDocuments {
	
	private SolrServer solrServer;
	
	@Autowired
	private MulticoreSolrServerFactory multicoreSolrServerFactory;
	
	public void pushDocuments() throws SolrServerException, IOException{
		solrServer = multicoreSolrServerFactory.getSolrServer("webcontent");
		SolrInputDocument inputDocument = new SolrInputDocument();
		inputDocument.addField("id", "3");
		inputDocument.addField("keyword", "测试3");
		inputDocument.addField("content", "正在测试solr上传3！");
		UpdateResponse response = solrServer.add(inputDocument);
		System.out.println("response:" + response.getStatus());
		solrServer.commit();
	}

}
