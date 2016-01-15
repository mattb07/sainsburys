package com.sainsburys.app.model;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * Created by matthew.bateup on 14/01/2016.
 */
public class ProductTest {

    @Test
    public void testTitleWord() {

        Product product = new Product("Banana",null,null,null);

        assertTrue(product.getTitle() == "Banana");
    }

    @Test
    public void testSizeWord() {

        Product product = new Product(null,"1230KB",null,null);

        assertTrue(product.getSize()=="1230KB");
    }

    @Test
    public void testUnitPrice() {

        BigDecimal bananaPrice = new BigDecimal(1.50);
        Product product = new Product(null,null,bananaPrice,null);

        assertTrue(product.getUnit_price() == bananaPrice);

    }

    @Test
    public void testDescriptionWord() {

        Product product = new Product(null,null,null,"South Africa origin");

        assertTrue(product.getDescription() == "South Africa origin");
    }
}