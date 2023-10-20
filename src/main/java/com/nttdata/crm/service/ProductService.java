package com.nttdata.crm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.nttdata.crm.entity.Product;
import com.nttdata.crm.request.ProductRequest;
import com.nttdata.crm.repository.ProductRepository;


@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	public Product saveProduct(ProductRequest productRequest) {
		Product product = Product.build(0, productRequest.getName(), productRequest.getQuantity(), productRequest.getPrice());
		return repository.save(product);
	}
	
	public List<Product> saveProducts(List<ProductRequest> productRequests) {
		List<Product> products = new ArrayList<>();
		for (ProductRequest productRequest : productRequests) {
			Product product = Product.build(0, productRequest.getName(), productRequest.getQuantity(), productRequest.getPrice());
			products.add(product);
		}
		return repository.saveAll(products);
	}
	
	public List<Product> getProducts(){
		return repository.findAll();
	}
	
	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	
	public Product getProductByName(String name) {
		return repository.findByName(name);
	}
	
	public ResponseEntity<Product> deleteProduct(int id) {
		
		if(!repository.existsById(id)) {
			System.out.println("product not found !!" + id);
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(id);
		System.out.println("product removed !!" + id);
		
		return ResponseEntity.noContent().build();
	}
	
	public ResponseEntity<Product> updateProduct(ProductRequest productRequest) {
		Product product = Product.build(0, productRequest.getName(), productRequest.getQuantity(), productRequest.getPrice());

		if(!repository.existsById(product.getId())) {
			System.out.println("product removed !!" + product.getId());
			return ResponseEntity.notFound().build();
		}
		repository.deleteById(product.getId());
		System.out.println(product.getId());
		
		product.setName(product.getName());
		product.setQuantity(product.getQuantity());
		product.setPrice(product.getPrice());
		repository.save(product);
		return ResponseEntity.noContent().build();
		
	}

}
