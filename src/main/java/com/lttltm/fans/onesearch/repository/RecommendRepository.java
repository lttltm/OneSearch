package com.lttltm.fans.onesearch.repository;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RecommendRepository{
	
	 @Autowired
	 private StringRedisTemplate template;
	 
	
	public Set<String> getRecommendList(String word) {
	
		return template.opsForZSet().reverseRange(word, 0, 5);
//		return null;
	}

}
