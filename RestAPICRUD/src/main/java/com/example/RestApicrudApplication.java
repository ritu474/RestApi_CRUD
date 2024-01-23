package com.example;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.entity.Product;
import com.example.repository.ProductRepository;

@SpringBootApplication
public class RestApicrudApplication implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(RestApicrudApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Product p1=Product.builder().name("TV").description("It is used for watching shows").price(60000.0).build();
		Product p2=Product.builder().name("PC").description("an electronic device that processes data and performs various tasks ").price(1000000.0).build();
		Product p3=Product.builder().name("Washing Machine").description("A washing machine is a household appliance designed for cleaning and laundering clothes").price(30090.2).build();
		Product p4=Product.builder().name("AC").description("Air conditioning is a system that cools and dehumidifies indoor air to create a more comfortable environment, especially during hot or humid weather").price(50000.0).build();
		Product p5=Product.builder().name("Mobile").description("Phones, short for telephones, are communication devices used for voice calls").price(12000.0).build();
	
	List<Product> lp=List.of(p1,p2,p3,p4);
	productRepository.saveAll(lp);
	}
	
	
	

}
