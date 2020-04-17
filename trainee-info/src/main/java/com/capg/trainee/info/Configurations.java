package com.capg.trainee.info;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("Capgemini.vc_info")
@PropertySource("info.properties")
public class Configurations {

}
