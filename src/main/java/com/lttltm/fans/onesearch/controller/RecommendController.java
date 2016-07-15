package com.lttltm.fans.onesearch.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lttltm.fans.onesearch.service.RecommendService;

@Controller
@RequestMapping("/api/*")
public class RecommendController {
	
	@Autowired
	private RecommendService recommendService;

	@RequestMapping(value = "/recommend")
	@ResponseBody
	public Set<String> recommendQuery(@RequestParam String query){
		
		return recommendService.getRecommendList(query);
	}
}
