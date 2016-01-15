package com.sainsburys.app.model;

import java.math.BigDecimal;

/**
 * Created by matthew.bateup on 14/01/2016.
 */
public class Product {

    private String title;
    private String size;
    private BigDecimal unit_price;
    private String description;

    public Product(String title, String size, BigDecimal unit_price, String description){
        this.title = title;
        this.size = size;
        this.unit_price = unit_price;
        this.description = description;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public BigDecimal getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(BigDecimal unit_price) {
        this.unit_price = unit_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}