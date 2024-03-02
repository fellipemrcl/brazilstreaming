package com.fellipemarcel.brazilstreaming;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * The type Brazilstreaming application.
 */
@SpringBootApplication
@EntityScan("com.fellipemarcel.brazilstreaming.models.entities")
@EnableJpaRepositories("com.fellipemarcel.brazilstreaming.models.repositories")
public class BrazilstreamingApplication {
	/**
	 * The entry point of application.
	 *
	 * @param args the input arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(BrazilstreamingApplication.class, args);
	}

}
