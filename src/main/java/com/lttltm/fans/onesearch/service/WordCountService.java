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
	
	public WordCount findWordCount(String word) {
		
		List<WordCount> wordInfoList = wordCountRepository.getWordInfoList();
		
		for(WordCount wordCount: wordInfoList){
			if(wordCount.getWord().contains(word)){
				return wordCount;
			}
		}
		return null;
	}
}
