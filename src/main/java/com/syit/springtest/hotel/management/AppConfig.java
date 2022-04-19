package com.syit.springtest.hotel.management;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		var dataSource = new DriverManagerDataSource();
		if (true) throw new RuntimeException("Configure your own DataSource first!");
		return dataSource;
	}

	@Bean
	@Primary
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		var factory = new LocalContainerEntityManagerFactoryBean();
		factory.setDataSource(dataSource());
		factory.setPackagesToScan("com.syit.springtest.hotel.management");
		factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		factory.setJpaProperties(jpaProperties());
		return factory;
	}

	public Properties jpaProperties() {
		Properties props = new Properties();
		// https://stackoverflow.com/questions/43716068/invalid-syntax-error-type-myisam-in-ddl-generated-by-hibernate/43720565
		//jpaProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MariaDBDialect");
		props.setProperty("hibernate.show_sql", "true");
		// hbm = hibernate mapping, ddl = data definition language
		props.setProperty("hibernate.hbm2ddl.auto", "update");
		return props;
	}
}
