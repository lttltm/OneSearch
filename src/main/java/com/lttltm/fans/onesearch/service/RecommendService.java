package com.lttltm.fans.onesearch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lttltm.fans.onesearch.api.model.WordCount;
import com.lttltm.fans.onesearch.repository.WordCountRepository;

@Service
public class RecommendService {
	
	@Autowired
	private WordCountRepository wordCountRepository;
	
	public List<String> getRecommendList(String word) {
		List<WordCount> wordInfoList = wordCountRepository.getWordInfoList();
		List<String> list = new ArrayList<String>();
		for(WordCount wordCount: wordInfoList) {
			if(wordCount.getWord().contains(word)){
				list.add(wordCount.getWord());
			}
		}
		return list;
		
	}

}
