package com.thisdatascience.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
//@PropertySource({"classpath:persitence-postgresq.properties")
@EntityScan("com.thisdatascience")
public class PersistenceJPAConfig {
	
	@Autowired 
	LocalContainerEntityManagerFactoryBean entityManagerFactory;
	
	@Bean
   	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		return entityManagerFactory;
		
   	}
   
	@Bean
   	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory().getObject());
		return transactionManager;
	}
}
