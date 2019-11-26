package edu.mum.cs544;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		IProductService productService = new ProductService();

		Product product1 = productService.getProduct(423);
		if (product1 != null) {
			System.out.println(product1.toString());
		}
		Product product2 = productService.getProduct(239);
		if (product2 != null) {
			System.out.println(product2.toString());
		}
		Product product3 = productService.getProduct(245);
		if (product3 != null) {
			System.out.println(product3.toString());
		}
		Product product4 = productService.getProduct(483);
		if (product4 != null) {
			System.out.println(product4.toString());
		}
		ApplicationContext context= new ClassPathXmlApplicationContext("SpringConfig.xml");
		Greeting  greeting =context.getBean("greeting",Greeting.class);
		greeting.sayHello();
	}
}
