package com.lttltm.fans.onesearch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lttltm.fans.onesearch.api.model.WordCount;
import com.lttltm.fans.onesearch.repository.WordCountRepository;


@Service
public class WordCountService {
	
	@Autowired
	private WordCountRepository wordCountRepository;
	
	public List<String> findWordCount(String word) {
		
		List<WordCount> wordInfoList = wordCountRepository.getWordInfoList();
		
		List<String> str = new ArrayList<String>();
		
		for(WordCount wordCount: wordInfoList){
			str.add(wordCount.getWord());
		}
		return str;
	}
}
