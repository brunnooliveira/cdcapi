package br.com.bgdo.cdcapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(enableDefaultTransactions = false)
public class CdcapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdcapiApplication.class, args);
	}

}
