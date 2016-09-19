package fr.sport.muscu.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.SimpleCommandLinePropertySource;

import fr.df.config.Constants;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(Main.class);
        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(
                args);
        addDefaultProfile(app, source);
        app.run(args);
    }

    /**
     * 
     * Set a default profile if it has not been set
     */
    private static void addDefaultProfile(SpringApplication app,
            SimpleCommandLinePropertySource source) {
        if (!source.containsProperty("spring.profiles.active")) {
            System.out.println("profile not defined");
            app.setAdditionalProfiles(Constants.SPRING_PROFILE_TEST);
        }
    }
}
