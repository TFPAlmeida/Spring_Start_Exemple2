package com.nttdata.crm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.crm.entity.Product;
import com.nttdata.crm.request.ProductRequest;
import com.nttdata.crm.service.ProductService;

import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody ProductRequest productRequest) {
		return new ResponseEntity<>(service.saveProduct(productRequest), HttpStatus.CREATED);
	}
	
	@PostMapping("/addProducts")
	public ResponseEntity<List<Product>> addProducts(@Valid @RequestBody List<ProductRequest> productRequests) {
		return new ResponseEntity<>(service.saveProducts(productRequests), HttpStatus.CREATED);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> findAllProducts() {
		return ResponseEntity.ok(service.getProducts());
	}
	
	@GetMapping("/findProductById/{id}")
	public ResponseEntity<Product> findProductById(@PathVariable int id) {
		return ResponseEntity.ok(service.getProductById(id));
	}
	
	@GetMapping("/findProductByName/{name}")
	public ResponseEntity<Product> findProductByName(@PathVariable String name) {
		return ResponseEntity.ok(service.getProductByName(name));
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<Product> updateProduct(@RequestBody ProductRequest productRequest) {
		
		return  service.updateProduct(productRequest);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable int id) {
		return service.deleteProduct(id);
	}
}
