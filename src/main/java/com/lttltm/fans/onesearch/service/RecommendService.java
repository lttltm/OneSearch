package com.lttltm.fans.onesearch.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lttltm.fans.onesearch.repository.RecommendRepository;

@Service
public class RecommendService {
	
	@Autowired
	private RecommendRepository recommendRepository;
	
	
	public Set<String> getRecommendList(String word) {
		return recommendRepository.getRecommendList(word);
		
	}

}
