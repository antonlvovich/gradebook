package com.example.gradebook.datasource;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:application.yaml")
public class PSQLDataSource {
}
