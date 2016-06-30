package com.lttltm.fans.onesearch.solr.repository;

import java.util.List;

import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import com.lttltm.fans.onesearch.solr.model.WebContent;

@Repository
public interface WebRepository extends SolrCrudRepository<WebContent, String>{
	
	public List<WebContent> findByKeyword(String keyWord);

	public List<WebContent> findByContent(String content);
}
