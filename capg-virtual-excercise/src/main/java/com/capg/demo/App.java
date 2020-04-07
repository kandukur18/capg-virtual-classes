package com.capg.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
   
    	
    	public static void main( String[] args )
        {
    		Trainee trainee;
           
           ApplicationContext context=
        		   new AnnotationConfigApplicationContext(Configurations.class);
        	//	   new AnnotationConfigApplicationContext("spring.xml");
           trainee=(Trainee) context.getBean("trainee");
           trainee.display();
    	
    	
        }
}
