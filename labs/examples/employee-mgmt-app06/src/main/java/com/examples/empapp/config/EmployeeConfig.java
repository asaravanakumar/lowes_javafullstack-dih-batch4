package com.examples.empapp.config;

import com.examples.empapp.dao.EmployeeDao;
import com.examples.empapp.dao.EmployeeDaoJdbcImpl;
import com.examples.empapp.dao.EmployeeDaoJdbcTempImpl;
import com.examples.empapp.service.EmployeeService;
//import org.postgresql.ds.PGSimpleDataSource;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.examples.empapp")
public class EmployeeConfig {

    @Bean
    public EmployeeService empService() {
        return new EmployeeService();
    }

    @Bean
    public EmployeeDao empDao() {
		return new EmployeeDaoJdbcImpl();
//        return new EmployeeDaoJdbcTempImpl();
    }

    // Enable for MySQL
	@Bean
	public MysqlDataSource dataSource() {
		MysqlDataSource datasource = new MysqlDataSource();
		datasource.setServerName("localhost");
		datasource.setDatabaseName("jdbctraining");
		datasource.setUser("training");
		datasource.setPassword("training");

		return datasource;
	}

//    public PGSimpleDataSource dataSource() {
//        PGSimpleDataSource datasource = new PGSimpleDataSource();
//        datasource.setServerNames(new String[]{"localhost"});
//        datasource.setDatabaseName("training");
//        datasource.setUser("postgres");
//        datasource.setPassword("postgres");
//
//        return datasource;
//    }

    @Bean
    public Connection connection() {
        Connection conn = null;
        try {
            // Enable for MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctraining", "training", "training");

//            Class.forName("org.postgresql.Driver");
//            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/training", "postgres", "postgres");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    @Bean
    public DataSource driverManagerDataSource() {
        DriverManagerDataSource datasource = new DriverManagerDataSource();
        // Enable for MySQL
		datasource.setUrl("jdbc:mysql://localhost:3306/jdbctraining");
		datasource.setUsername("training");
		datasource.setPassword("training");

//        datasource.setUrl("jdbc:postgresql://localhost:5432/training");
//        datasource.setUsername("postgres");
//        datasource.setPassword("postgres");

        return datasource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(driverManagerDataSource());
    }
}
