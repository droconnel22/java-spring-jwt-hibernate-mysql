package com.dennis.oconnell.samplejavaapi.configurations;


import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.activation.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
//@EnableJpaRepositories("com.javaspringclub.repository")
@PropertySource(value = {"classpath:application.properties"})
public class TimeSheetAPIConfig {



}
