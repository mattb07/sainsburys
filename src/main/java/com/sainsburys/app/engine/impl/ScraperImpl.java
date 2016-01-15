package com.sainsburys.app.engine.impl;

import java.math.BigDecimal;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.sainsburys.app.engine.Scraper;
import com.sainsburys.app.model.Result;

/**
 * Created by matthew.bateup on 15/01/2016.
 */
public class ScraperImpl implements Scraper {

    public Result scraper(String url) {

        Result result = new Result();

        try {

            //Specify which URL to be used
            //Constraint - FIREFOX only
            WebDriver driver = new FirefoxDriver();
            driver.get(url);

            //For page loading purposes
            Thread.sleep(2000);

            //Pick up all the products within a web page
            List<WebElement> elements = getProductByClassName(driver);

            //Populate Result
            for (WebElement webE : elements) {

                final String PRODUCT_INNER = "productInner";

                WebElement prdInner = webE.findElement(By.className(PRODUCT_INNER));

                //Pick up Product Title
                final String ANCHOR = "h3 > a";
                WebElement anchor = prdInner.findElement(By.cssSelector(ANCHOR));
                String title = anchor.getText();

                //Pick up Product Size


                //Pick up Product Unit Price
                String unitPrice = getUnitPrice(prdInner);
                BigDecimal convertString = new BigDecimal(unitPrice);

                //Pick up Product Description






            }


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    private String getUnitPrice(WebElement prdInner) {

        String scrapeUnitPrice = prdInner.findElement(By.className("pricePerUnit")).getText();
        return scrapeUnitPrice.substring(1,scrapeUnitPrice.indexOf("/unit"));
    }

    private List<WebElement> getProductByClassName(WebDriver driver) {

        final String PRODUCT = "product";
        List<WebElement> elements = driver.findElements(By.className(PRODUCT));

        return elements;
    }
}