package com.lttltm.fans.onesearch.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lttltm.fans.onesearch.api.model.WordCount;

@Repository
public class WordCountRepository {
	
	@Autowired
	public List<WordCount> getWordInfoList() {
		List<WordCount> wordInfoList = new ArrayList<WordCount>();
		wordInfoList.add(new WordCount("中",1));
		wordInfoList.add(new WordCount("国",1));
		wordInfoList.add(new WordCount("人",1));
		wordInfoList.add(new WordCount("民",1));
		wordInfoList.add(new WordCount("中国",1));
		wordInfoList.add(new WordCount("国人",1));
		wordInfoList.add(new WordCount("人民",1));
		wordInfoList.add(new WordCount("中国人",1));
		wordInfoList.add(new WordCount("中国人民",1));
	
		return wordInfoList;
	} 

}
