package fr.sport.muscu.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import fr.df.config.Constants;

@SpringBootApplication
//@Configuration
@EnableJpaRepositories({ "fr.df.muscu.api.repositories" })
@EntityScan({ "fr.df.muscu.api.model" })
@ComponentScan(basePackages = { "fr.df.muscu.api.service", "fr.df.muscu.api.service.impl", "fr.df.muscu.api.web.v1" })

public class Main {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Main.class);
		SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);
		addDefaultProfile(app, source);
		app.run(args);
	}

	/**
	 * 
	 * Set a default profile if it has not been set
	 */
	private static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
		if (!source.containsProperty("spring.profiles.active")) {
			System.out.println("profile not defined");
			app.setAdditionalProfiles(Constants.SPRING_PROFILE_TEST);
		}
	}
}
