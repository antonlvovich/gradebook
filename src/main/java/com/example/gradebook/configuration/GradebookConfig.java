package com.example.gradebook.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.example.gradebook.entity")
@EnableJpaRepositories("com.example.gradebook.access")
public class GradebookConfig {
}
