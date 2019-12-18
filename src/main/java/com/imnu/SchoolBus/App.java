package com.imnu.SchoolBus;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


/**
 * Hello world!
 *
 */
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
public class App 
{
	 public static void main( String[] args ) {
	    	SpringApplication.run(App.class, args);
	    	//print();
	    }
}
