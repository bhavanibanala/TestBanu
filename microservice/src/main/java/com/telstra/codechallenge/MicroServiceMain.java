package com.telstra.codechallenge;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

import com.telstra.codechallenge.quotes.Quote;

@SpringBootApplication
@ComponentScan({"com.telstra.codechallenge.quote"})
public class MicroServiceMain {

  public static void main(String[] args) {
    SpringApplication.run(MicroServiceMain.class, args);
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
  
  
  @Value("${quotes.base.url}")
  private String quotesBaseUrl;
  
  @Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					quotesBaseUrl+"/api/random", Quote.class);
			System.out.println("MicroServiceMain.run():::>>>"+quote.toString());
		};
	}

}
