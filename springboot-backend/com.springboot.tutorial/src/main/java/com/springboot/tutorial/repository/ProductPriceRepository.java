package com.springboot.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.tutorial.model.ProductPrice;

@Repository
public interface ProductPriceRepository extends JpaRepository<ProductPrice, Long> {

}