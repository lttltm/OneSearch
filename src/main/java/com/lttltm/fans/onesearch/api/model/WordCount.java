package com.lttltm.fans.onesearch.api.model;

public class WordCount {
	private String word;
	private long count;
	
	
	public WordCount() {
		super();
	}
	public WordCount(String word, long count) {
		super();
		this.word = word;
		this.count = count;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
	
}
