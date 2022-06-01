package com.coolcoder.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coolcoder.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	Product findByName(String name);

}
