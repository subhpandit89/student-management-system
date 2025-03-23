package com.learning.student_management_system.utilities;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanGenerator {

    @Bean
    public CustomBean getCusBean(){
        return new CustomBean();
    }


}
