package com.iftm.E1.Ex1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class Ex1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex1Application.class, args);
	}
	@GetMapping("/client")
	public Client cliente(){
		var cliente = new Client("Carlos",23,produto());
		return new Client("Josue",21,produto());
	}
	@GetMapping("/product")
	public List<Product> produto(){
		var listaDeProdutos = new ArrayList<Product>();
		listaDeProdutos.add(new Product("Chave",21.50));
		listaDeProdutos.add(new Product("Parafuso",1.50));
		listaDeProdutos.add(new Product("Martelo",50.30));
		return listaDeProdutos;
	}


}
