package com.lttltm.fans.onesearch;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.core.env.Environment;


/**
 * Hello world!
 *
 */

@SpringBootApplication
public class Application extends SpringBootServletInitializer {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(Application.class);		
	} 
	
    public static void main( String[] args ) throws UnknownHostException
    {
    	  Environment env = SpringApplication.run(Application.class,args).getEnvironment();
          log.info("Access URLs:\n----------------------------------------------------------\n\t" +
                  "Local: \t\thttp://127.0.0.1:{}\n\t" +
                  "External: \thttp://{}:{}\n----------------------------------------------------------",
              env.getProperty("server.port"),
              InetAddress.getLocalHost().getHostAddress(),
              env.getProperty("server.port"));
    }
}
