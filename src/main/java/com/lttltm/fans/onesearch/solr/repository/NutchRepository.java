package com.lttltm.fans.onesearch.solr.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.lttltm.fans.onesearch.solr.model.Nutch;


public interface NutchRepository extends SolrCrudRepository<Nutch, String> {
	
	Page<Nutch> findBySummary(String query, Pageable pageable);
	
	Page<Nutch> findByTitle(String query, Pageable pageable);
	
	Page<Nutch> findByUrl(String query, Pageable pageable);
	
	@Query("title:?0 OR url:?0 OR content:?0")
	Page<Nutch> findByTitleOrUrlOrSummary(String query, Pageable pageable);

}
