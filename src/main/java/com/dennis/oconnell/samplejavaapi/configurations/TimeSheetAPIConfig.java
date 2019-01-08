package com.dennis.oconnell.samplejavaapi.configurations;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.dennis.oconnell.samplejavaapi")
@PropertySource(value = {"classpath:application.properties"})
public class TimeSheetAPIConfig {



}
