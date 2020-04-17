package com.capg.productrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.productrestapi.model.Product;
import com.capg.productrestapi.service.ProductService;


@RestController
@RequestMapping("/api")
public class ProductRestController {
	@Autowired
	ProductService service;
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProduct(){
		List<Product> allProducts=service.getListOfProducts();
		
		return new ResponseEntity<List<Product>>(allProducts,HttpStatus.OK);
	}
	
	@GetMapping("/products/id/{id}")
	
	public ResponseEntity<Product> getProductById(@PathVariable("id") int productId) {
		
		Product product= service.getProduct(productId);
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	@PostMapping("/products")
	public ResponseEntity<Product> addProduct(@RequestBody Product product){
		service.addProduct(product);
		return new ResponseEntity<Product>(product,HttpStatus.CREATED);
	}


}
