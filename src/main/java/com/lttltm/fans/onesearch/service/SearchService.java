package com.lttltm.fans.onesearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;
import com.lttltm.fans.onesearch.solr.model.Nutch;
import com.lttltm.fans.onesearch.solr.model.WebContent;
import com.lttltm.fans.onesearch.solr.repository.NutchRepository;
import com.lttltm.fans.onesearch.solr.repository.WebRepository;


@Service
public class SearchService {

	@Autowired
	private WebRepository webRepository;
	
	@Autowired
	private NutchRepository nutchRepository;
	
	
	public List<WebContent> findWebByKeyWord(String keyword) {
		return webRepository.findByKeyword(keyword);
	}
	
	public List<WebContent> findWebByContent(String content) {
		return webRepository.findByContent(content);
	}
	
	public Page<Nutch> findByTitleOrUrlOrContent(String query, Pageable pageable) {
		Page<Nutch> page = nutchRepository.findByTitleOrUrlOrSummary(query, pageable);
		page.forEach(nutch ->{
			String summary = nutch.getSummary().substring(0, 200);
			nutch.setSummary(summary);
		});
		return page;
	}
	
	public Page<Nutch> findByContent(String query, Pageable pageable) {
		Page<Nutch> page = nutchRepository.findBySummary(query, pageable);
		page.forEach(nutch ->{
			String summary = nutch.getSummary().substring(0, 200);
			nutch.setSummary(summary);
		});
		return page;
	}
	
	public Page<Nutch> findByTitle(String query, Pageable pageable) {
		Page<Nutch> page = nutchRepository.findByTitle(query, pageable);
		page.forEach(nutch ->{
			String summary = nutch.getSummary().substring(0, 200);
			nutch.setSummary(summary);
		});
		return page;
	}
	
	public Page<Nutch> findByUrl(String query, Pageable pageable) {
		Page<Nutch> page = nutchRepository.findByUrl(query, pageable);
		page.forEach(nutch ->{
			String summary = nutch.getSummary().substring(0, 200);
			nutch.setSummary(summary);
		});
		return page;
	}
}
