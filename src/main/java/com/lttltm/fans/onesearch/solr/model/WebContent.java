package com.lttltm.fans.onesearch.solr.model;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(solrCoreName="webcontent")
public class WebContent {
	@Field
	public String id;
	
	@Indexed
	@Field
	public String keyword;
	
	@Indexed
	@Field
	public String content;
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "WebContent [id=" + id + ", keyword=" + keyword + ", content="
				+ content + "]";
	}

}
