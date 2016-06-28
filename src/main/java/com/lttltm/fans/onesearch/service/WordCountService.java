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
	
	public List<WordCount> findWordCountList(String word){
		List<WordCount> wordInfoList = wordCountRepository.getWordInfoList();
		List<WordCount> resultList = new ArrayList<WordCount>();
		for(WordCount wordCount: wordInfoList) {
			if(wordCount.getWord().contains(word)) {
				resultList.add(wordCount);
			}
		}
		return resultList;
	}
}
