package com.imnu.SchoolBus;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;


/**
 * Hello world!
 *
 */
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
@ComponentScan(basePackages = {"com.imnu.SchoolBus"})
@MapperScan("com.imnu.SchoolBus.mapper")
public class App 
{
	 public static void main( String[] args ) {
	    	SpringApplication.run(App.class, args);
	    	//print();
	    }
}
