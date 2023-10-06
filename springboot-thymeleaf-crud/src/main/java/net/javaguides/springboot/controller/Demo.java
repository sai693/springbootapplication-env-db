package net.javaguides.springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class Demo {
	@Value("${spring.datasource.url}")
	private String db_url = System.getenv("db_url");

	@Value("${spring.datasource.username}")
    private String db_username = System.getenv("db_username");

	 
    @Value("${spring.datasource.password}")
    private String db_pasword = System.getenv("db_password");
    
    //@GetMapping("/demo")
    //public Databaseinfo demo() {
       // return new Databaseinfo(db_url, db_username, db_password);
    //}
    
      
}
