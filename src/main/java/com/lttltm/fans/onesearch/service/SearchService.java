package com.lttltm.fans.onesearch.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lttltm.fans.onesearch.solr.model.WebContent;
import com.lttltm.fans.onesearch.solr.repository.WebRepository;


@Service
public class SearchService {

	@Autowired
	private WebRepository webRepository;
	
	
	public List<WebContent> findWebByKeyWord(String keyword) {
		return webRepository.findByKeyword(keyword);
	}
	
	public List<WebContent> findWebByContent(String content) {
		return webRepository.findByContent(content);
	}
}
