package com.lttltm.fans.onesearch.solr.client;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.lttltm.fans.onesearch.Application;
import com.lttltm.fans.onesearch.service.SearchService;
import com.lttltm.fans.onesearch.solr.model.WebContent;

//@SpringApplicationConfiguration(classes = Application.class)
//@WebAppConfiguration
//@RunWith(SpringJUnit4ClassRunner.class)
//public class IndexDocumentsTest {
//	@Autowired
//	private IndexDocuments index;
//	@Autowired
//	private SearchService searchService;
//	
////	@Test
//	public void testPushDocuments() {
//		
//		try {
//			index.pushDocuments();
//		} catch (SolrServerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//
////	@Test
//	public void testFindWebByKeyWord() {
//   		List<WebContent> list = searchService.findWebByKeyWord("测试");
//		System.out.println(list.size() + "-------1");
//		System.out.println(list.toString());
//		
//		list = searchService.findWebByContent("java");
//		System.out.println(list.size() + "-------2");
//		System.out.println(list.toString());
//	}
//}
