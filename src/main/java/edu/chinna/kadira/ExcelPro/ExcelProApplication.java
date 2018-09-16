package edu.chinna.kadira.ExcelPro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
/**
 * 
 * @author rakondapalli
 *
 */
public class ExcelProApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcelProApplication.class, args);
	}

}
