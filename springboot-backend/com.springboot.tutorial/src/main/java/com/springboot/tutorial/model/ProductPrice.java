package com.springboot.tutorial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product_price")
public class ProductPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "penguin_ears_count")
    private Integer penguinEarsCount;

    @Column(name = "horseshoe_count")
    private Integer horseshoeCount;
    
    @Column(name = "penguin_ears_price")
    private Float penguinEarsPrice;
    
    @Column(name = "horseshoe_price")
    private Float horseshoePrice;

    @Column(name = "amount")
    private Float amount;

    public ProductPrice() {

    }

    public ProductPrice(Integer penguinEarsCount, Integer horseshoeCount, Float amount) {
        super();
        this.penguinEarsCount = penguinEarsCount;
        this.horseshoeCount = horseshoeCount;
        this.amount = amount;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Integer getPenguinEarsCount() {
        return penguinEarsCount;
    }
    public void setPenguinEarsCount(Integer penguinEarsCount) {
        this.penguinEarsCount = penguinEarsCount;
    }
    public Integer getHorseshoeCount() {
        return horseshoeCount;
    }
    public void setHorseshoeCount(Integer horseshoeCount) {
        this.horseshoeCount = horseshoeCount;
    }
    public Float getPenguinEarsPrice() {
        return penguinEarsPrice;
    }
    public void setPenguinEarsPrice(Float penguinEarsPrice) {
        this.penguinEarsPrice = penguinEarsPrice;
    }
    public Float getHorseshoePrice() {
        return horseshoePrice;
    }
    public void setHorseshoePrice(Float horseshoePrice) {
        this.horseshoePrice = horseshoePrice;
    }
    public Float getAmount() {
        return amount;
    }
    public void setAmount(Float amount) {
        this.amount = amount;
    }
}