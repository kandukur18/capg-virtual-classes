package com.capg.productrestapi.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.capg.productrestapi.model.Product;
@Repository
public class ProductRepo {
	@PersistenceContext
	EntityManager em;
	
	public Product addProduct(Product product) {
		em.persist(product);
		return product;
	}
	
	public  Product getProduct(int productId) {
		return em.find(Product.class, productId);
	}

}
