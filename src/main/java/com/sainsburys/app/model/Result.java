package com.sainsburys.app.model;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by matthew.bateup on 14/01/2016.
 */
public class Result {

    public List<Product> getResults() {
        return results;
    }

    public void setResults(List<Product> results) {
        this.results = results;
    }

    private List<Product> results;

    public BigDecimal getTotalPrice() {

        BigDecimal totalPrice = new BigDecimal(0);

        if (results != null) {
            for (Product product : results) {
                totalPrice = totalPrice.add(product.getUnit_price());
            }
        }
        return totalPrice;
    }
}