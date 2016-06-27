package com.lttltm.fans.onesearch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lttltm.fans.onesearch.api.model.WordCount;
import com.lttltm.fans.onesearch.service.WordCountService;

@Controller
public class SearchController {
	private Logger logger = LoggerFactory.getLogger(SearchController.class);
	
	@Autowired
	private WordCountService wordCountService;
	
	@RequestMapping(value = "/query", method = RequestMethod.GET)
	@ResponseBody
	public WordCount queryString(@RequestParam String query){
		
		return wordCountService.findWordCount(query);
		
	}

}