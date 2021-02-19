package com.missile.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.missile.bean.Yellow;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Missile
 * @Date 2021-02-19-23:34
 */
@PropertySource("classpath:/jdbc.properties")
@Configuration
public class MainConfigOfProfile {

    String user;
    String password;
    String driverClass;
    InputStream is = MainConfigOfProfile.class.getClassLoader().getResourceAsStream("jdbc.properties");
    Properties properties = new Properties();

    private DataSource load(String JdbcUrl) throws Exception {
        properties.load(is);
        user = properties.getProperty("db.user");
        password = properties.getProperty("db.password");
        driverClass = properties.getProperty("db.driverClass");
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setUser(user);
        dataSource.setPassword(password);
        dataSource.setDriverClass(driverClass);
        dataSource.setJdbcUrl(JdbcUrl);
        return dataSource;
    }

    @Profile("test")
    @Bean
    public Yellow yellow(){
        return new Yellow();
    }

    @Profile({"test","default"})
    @Bean("testDataSource")
    public DataSource dataSourceTest() throws Exception {
        return load("jdbc:mysql://localhost:3306/test");

    }

    @Profile("dev")
    @Bean("devDataSource")
    public DataSource dataSourceDevelop() throws Exception {
        return load("jdbc:mysql://localhost:3306/develop");

    }

    @Profile("prod")
    @Bean("prodDataSource")
    public DataSource dataSourceProd() throws Exception {
        return load("jdbc:mysql://localhost:3306/prod");
    }


}
