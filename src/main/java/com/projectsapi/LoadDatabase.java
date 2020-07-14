package com.projectsapi;

import java.util.ArrayList;
import java.util.List;

import com.projectsapi.model.Project;
import com.projectsapi.repository.ProjectRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	CommandLineRunner initDatabase(ProjectRepository repository) {
		List<String> tech = new ArrayList();

		tech.add("Java");
		tech.add("Spring Boot");
		return args -> {
            log.info("Preloading " + repository.save(new Project("Projects API", "Intro", tech, "This is a project", "link")));
		};
	}
}