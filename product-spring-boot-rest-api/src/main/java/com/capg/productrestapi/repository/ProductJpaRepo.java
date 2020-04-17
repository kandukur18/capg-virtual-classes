package com.capg.productrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.productrestapi.model.Product;

public interface ProductJpaRepo extends JpaRepository<Product, Integer> {

}
