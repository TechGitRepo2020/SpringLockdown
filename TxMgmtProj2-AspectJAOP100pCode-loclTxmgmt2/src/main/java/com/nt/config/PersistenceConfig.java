package com.nt.config;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
public class PersistenceConfig {
	
	@Bean(name="hkds")
	public DataSource createDS() {
		HikariDataSource hkds=new HikariDataSource();
		hkds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		hkds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:orcl");
		hkds.setUsername("scott");
		hkds.setPassword("tiger");
		hkds.setMaximumPoolSize(20);
		hkds.setMinimumIdle(10);
		hkds.setIdleTimeout(2000);
		return hkds;
	}
	
	@Bean(name="jt")
	public JdbcTemplate createJT() {
		return new JdbcTemplate(createDS());
	}

}
