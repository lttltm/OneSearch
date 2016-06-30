package com.lttltm.fans.onesearch.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lttltm.fans.onesearch.api.model.WordCount;
import com.lttltm.fans.onesearch.repository.WordCountRepository;
import com.lttltm.fans.onesearch.solr.model.WebContent;
import com.lttltm.fans.onesearch.solr.repository.WebRepository;


@Service
public class SearchService {
	
	@Autowired
	private WordCountRepository wordCountRepository;
	@Autowired
	private WebRepository webRepository;
	
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
	
	public List<WebContent> findWebByKeyWord(String keyword) {
		return webRepository.findByKeyword(keyword);
	}
	
	public List<WebContent> findWebByContent(String content) {
		return webRepository.findByContent(content);
	}
}
