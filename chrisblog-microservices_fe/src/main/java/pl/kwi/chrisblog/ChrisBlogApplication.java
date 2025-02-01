package pl.kwi.chrisblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ChrisBlogApplication {

    public static void main(String[] args) {
		SpringApplication.run(ChrisBlogApplication.class, args);
	}
    
}
