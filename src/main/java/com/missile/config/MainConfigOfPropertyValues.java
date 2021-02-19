package com.missile.config;

import com.missile.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Missile
 * @Date 2021-02-07-14:54
 */
@PropertySource(value = "classpath:/person.properties")
@Configuration

public class MainConfigOfPropertyValues {
    @Bean
    public Person person(){
        return new Person();
    }
}
