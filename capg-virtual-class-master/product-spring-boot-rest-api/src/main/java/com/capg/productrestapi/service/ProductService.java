package com.capg.productrestapi.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.capg.productrestapi.exception.ProductNotFoundException;
import com.capg.productrestapi.model.Product;
import com.capg.productrestapi.repository.ProductJpaRepo;

@Service
public class ProductService {
	@Autowired(required = true)
	ProductJpaRepo productRepo;

	public List<Product> getListOfProducts(){
      	return productRepo.findAll();
	}
	public Product getProduct(int productId) {
		if(!productRepo.existsById(productId)) {
			throw new ProductNotFoundException("Product with id : ["+productId+"] Not Found"); 
		}
		return productRepo.getOne(productId);
	}
	@Transactional
	public Product addProduct(Product product) {
		return productRepo.save(product);
	}	

}
