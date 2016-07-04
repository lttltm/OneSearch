package com.lttltm.fans.onesearch.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lttltm.fans.onesearch.service.SearchService;
import com.lttltm.fans.onesearch.solr.model.Nutch;
import com.lttltm.fans.onesearch.solr.model.WebContent;

@Controller
@RequestMapping("/api/*")
public class SearchController {
	private Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	private SearchService searchService;
	
	@RequestMapping(value = "/test/query", method = RequestMethod.GET)
	@ResponseBody
	public List<WebContent> queryString(@RequestParam String query){
		
		return searchService.findWebByContent(query);
		
	}
	
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public Page<Nutch> query(@RequestParam String query, @PageableDefault(page = 0, size = 10)Pageable pageable) {
		
		return searchService.findByTitleOrUrlOrContent(query, pageable);
	}

}
