package com.lttltm.fans.onesearch.log4j;


import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.lttltm.fans.onesearch.Application;


public class Log4jFlumeTest {

	private static Logger logger = LoggerFactory.getLogger(Log4jFlumeTest.class);
	
	public static void main(String[] args)  {
		System.out.println("Log4jFlumeTest.main()................");
		logger.info("Hello, this is a test for log4j-flume writing." + String.valueOf(new Date()));
	}
}
