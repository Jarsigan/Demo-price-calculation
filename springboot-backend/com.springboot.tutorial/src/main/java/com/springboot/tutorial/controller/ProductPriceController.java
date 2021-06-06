package com.springboot.tutorial.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.tutorial.exception.ResourceNotFoundException;
import com.springboot.tutorial.model.ProductPrice;
import com.springboot.tutorial.repository.ProductPriceRepository;
import com.springboot.tutorial.logic.Calculation;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ProductPriceController {

    @Autowired
    private ProductPriceRepository productPriceRepository;
    
    Calculation calculation = new Calculation(); 

    // get all productPrices
    @GetMapping("/productPrices")
    public List < ProductPrice > getAllProductPrice() {
        return productPriceRepository.findAll();
    }

    // create productPrices rest api
    @PostMapping("/productPrices")
    public ProductPrice createProductPrice(@RequestBody ProductPrice productPrice) {    
    	calculation.setCartonUnitProduct1(20);
    	calculation.setProduct1CartonPrice(175);
    	calculation.setCartonUnitProduct2(5);
    	calculation.setProduct2CartonPrice(825);
    	
    	float penguinEarsPrice = calculation.getTotalAmountForProduct(productPrice.getPenguinEarsCount(),
    			175,20,"unit");
    	float horseshoePrice = calculation.getTotalAmountForProduct(productPrice.getHorseshoeCount(),
    			825,5,"unit");    	
    	
        productPrice.setPenguinEarsCount(productPrice.getPenguinEarsCount());
        productPrice.setHorseshoeCount(productPrice.getHorseshoeCount());
        productPrice.setPenguinEarsPrice(penguinEarsPrice);
        productPrice.setHorseshoePrice(horseshoePrice);
        productPrice.setAmount(penguinEarsPrice+horseshoePrice);
        
        return productPriceRepository.save(productPrice);
    }

   
    @GetMapping("/productPrices/{id}")
    public ResponseEntity <ProductPrice> getProductPriceById(@PathVariable Long id) {
        ProductPrice productPrice = productPriceRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
        return ResponseEntity.ok(productPrice);
    }

    // delete productPrices rest api
    @DeleteMapping("/productPrices/{id}")
    public ResponseEntity < Map < String, Boolean >> deleteProductPrice(@PathVariable Long id) {
        ProductPrice productPrice = productPriceRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        productPriceRepository.delete(productPrice);
        Map < String, Boolean > response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}