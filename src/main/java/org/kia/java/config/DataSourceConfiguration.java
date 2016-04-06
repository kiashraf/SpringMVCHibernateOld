package org.kia.java.config;



import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.Cloud;
import org.springframework.cloud.CloudFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("cloud")
public class DataSourceConfiguration {

	@Bean
	public Cloud cloud(){
		
		
		return new CloudFactory().getCloud();
	}
	
	@Bean
	//@ConfigurationProperties(DataSourceProperties.PREFIX)
	public DataSource dataSource(){
		
		
		return cloud().getSingletonServiceConnector(DataSource.class,null);
	}
	
	/*@Bean
	public DataSource datasource(){
		
		CloudFactory cloudFactory = new CloudFactory();
		Cloud cloud = cloudFactory.getCloud();
		String serviceID = cloud.getServiceID();
		
		
		
		
		
	}
	*/
	
}