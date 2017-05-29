package com.yukproduktif;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BotApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(BotApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder app)
    {
        return app.sources(BotApplication.class);
    }
	
	@RequestMapping("/hello")
	public String hello(){
		return "Hello Java!";
	}
	
}
