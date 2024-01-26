package com.hollannikas.water.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.hollannikas.water.gateway.persistence.repository")
public class PersistenceConfig {
}
