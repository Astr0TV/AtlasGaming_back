package fr.projet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class AtlasGamingApplication implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(AtlasGamingApplication.class, args);
		System.out.println("************************                               ************************\n************************  ---___AtlasGaming EST LANCÉ___--- ************************\n************************                               ************************".toUpperCase());
		
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("************************                               ************************\n************************ ---___Debut Instruction Perso___--- ******************\n************************                               ************************".toUpperCase());	
		
	}
	
	   @Bean
	    public RestTemplate restTemplate() {
	        return new RestTemplate();
	    }

}
