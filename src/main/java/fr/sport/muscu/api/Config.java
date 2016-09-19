package fr.sport.muscu.api;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories({ "fr.df.muscu.api.repositories" })
@EntityScan({ "fr.df.muscu.api.model" })
@ComponentScan({ "fr.df.muscu.api.services",  "fr.df.muscu.api.services.impl" })
public interface Config {

}
