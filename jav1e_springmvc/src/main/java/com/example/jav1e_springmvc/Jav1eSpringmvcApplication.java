package com.example.jav1e_springmvc;


import org.springframework.boot.SpringApplication;

//Java Program to Illustrate DemoApplication

//Importing package module to code fragment

//Importing required classes

import com.example.bai4.MyServiceClass;
import com.example.girl.Girl;
import com.example.girl.GỉrlService;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class Jav1eSpringmvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(Jav1eSpringmvcApplication.class, args);
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.example.bai4");
		context.scan("com.example.girl");
		context.refresh();
		MyServiceClass myServiceClass = context.getBean(MyServiceClass.class);
		//context.scan("com.example.bai4");
		
		// Testing the factorial method
        int factorialOf5 = myServiceClass.factorial(5);
        System.out.println("Factorial of 5 is: " + factorialOf5);
        
        
        GỉrlService girlService = context.getBean(GỉrlService.class);
        
        // Lấu ra random một cô gái từ tầng service
        Girl girl = girlService.getRandomGirl();
        
        // In ra màn hình
        System.out.println(girl);
        
        // Closing the spring context
        // using close() method
        context.close();        
	}

}
