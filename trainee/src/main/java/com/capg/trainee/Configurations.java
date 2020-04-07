package com.capg.trainee;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.capg.virtual.demo")
@PropertySource("info.properties")
public class Configurations {

}
