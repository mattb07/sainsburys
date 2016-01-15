package com.sainsburys.app.model;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

/**
 * Created by matthew.bateup on 14/01/2016.
 */
public class ResultTest {

    private static BigDecimal ZERO_VALUE = BigDecimal.ZERO;
    private static Result result;

    @Mock
    private Product product1;

    @Mock
    private Product product2;

    @Mock
    private Product product3;

    @Before
    public void setup() {

        //this must be called for the @Mock annotations above to be processed
        MockitoAnnotations.initMocks(this);

        result = new Result();
        doReturn(new BigDecimal("2.00")).when(product1).getUnit_price();
        doReturn(new BigDecimal("3.00")).when(product2).getUnit_price();
        doReturn(new BigDecimal("4.00")).when(product3).getUnit_price();
    }

    @Test
    public void testZeroValue() {
        BigDecimal total = result.getTotalPrice();
        assertEquals(ZERO_VALUE,total);
    }

    @Test
    public void shouldReturnTotalCorrectlyWithTopTwoProducts() {

        List<Product> results = new ArrayList<Product>();
        results.add(product1);
        results.add(product2);
        result.setResults(results);

        BigDecimal total = result.getTotalPrice();

        assertEquals(0, new BigDecimal(5.00).compareTo(total));
    }

    @Test
    public void shouldReturnTotalCorrectlyWithBottomTwoProducts() {

        List<Product> results = new ArrayList<Product>();
        results.add(product2);
        results.add(product3);
        result.setResults(results);

        BigDecimal total = result.getTotalPrice();

        assertEquals(0, new BigDecimal(7.00).compareTo(total));
    }

    @Test
    public void testGetterResultList() {

        List<Product> results = new ArrayList<Product>();
        result.setResults(results);

        assertEquals(results,result.getResults());
    }
}