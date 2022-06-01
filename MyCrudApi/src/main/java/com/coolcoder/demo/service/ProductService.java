package com.coolcoder.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.coolcoder.demo.entity.Product;
import com.coolcoder.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	// post (Add) single product
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
	
	// post (Add) List Of Products 
	public List<Product> saveProducts(List<Product> products) {
		return productRepository.saveAll(products);
	}

	// Get product

	public List<Product> getProduct() {
		return productRepository.findAll();
	}

	public Product getProductById(int id) {
		return productRepository.findById(id).orElse(null);
	}

	public Product getProductByName(String name) {
		return productRepository.findByName(name);
	}

	// Delete Product

	public String deleteProduct(int id) {
		productRepository.deleteById(id);
		return "Prodcut Removed Sucessfully !! " + id;
	}

	// update product

	public Product updateProduct(Product product) {
		Product existingProduct = productRepository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQuantity(product.getQuantity());
		return productRepository.save(existingProduct);
	}
}
