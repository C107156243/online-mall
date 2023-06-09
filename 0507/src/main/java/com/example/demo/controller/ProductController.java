package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@CrossOrigin("http://localhost:8081/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping("/")
	public List<Product> getAllProduct(){
		
		return productService.getAllproduct();
	}
	
	@GetMapping("/getProductByPid/{pid}")
	public Product getProductByPid(@PathVariable String pid) {
		return productService.getProductByPid(pid);
	}
	
	@PostMapping("/")
	public void addProduct(@RequestBody Product product) {
		productService.addProduct(product);
	}
	
	@DeleteMapping("/deleteProduct/{pid}")
	public void deleteProduct(@PathVariable String pid) {
		productService.deleteProduct(pid);
	}
	
	@PutMapping("/updateProduct")
	public void updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
	}
}
