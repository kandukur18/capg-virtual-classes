package com.capg.spring1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context= new AnnotationConfigApplicationContext(EmployeeConfiguration.class);
        
        Employee e=(Employee)context.getBean("employee");
        System.out.println("Employee Details.."+"\n ------------------------");
        System.out.println("Employee ID     :"+ e.getEmployeeId());
        System.out.println("Employee Name   :"+ e.getEmployeeName());
        System.out.println("Employee salary :"+ e.getSalary());
        System.out.println("Employee BU     :"+ e.getBusinessUnit());
        System.out.println("Employee Age    :"+ e.getAge());
       
    }
}
