package com.company;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class Website {

    WebDriver driver;
    String url;


    public Website(WebDriver driver, String url) {
        this.driver = driver;
        this.url = url;

    }

    public void setUp(String title) {
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        if (!driver.getTitle().equals(title))
        {
            Assert.fail("Title is wrong. please check url");
            driver.close();
            driver.quit();
        }

    }

}




