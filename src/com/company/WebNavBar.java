package com.company;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebNavBar extends Website {


    By li = By.xpath("/html/body/nav/ul/li[1]/ul/li[3]/a"); //  political li
    By h1 = By.xpath("/html/body/div[5]/main/header/h1"); // h1 - category subject political
    By stickyNavBar = By.xpath("/html/body/nav");
    String correctClass = "menu responsive v-2020 sticky slidedown in"; // stickyNavBar class


    public WebNavBar(WebDriver driver, String url) { super(driver, url); }

    public void clickSubject() {

        try {
            setUp("N12 – אתר החדשות של ישראל");

            if((driver.findElement(li).isEnabled() && (driver.findElement(li).isDisplayed())))
                driver.findElement(li).click(); // click "political"

            else
                throw new Exception();


            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            if(!(driver.findElement(h1).getText().equals("פוליטי")))
            {
                throw new Exception();
            }

            // scroll Down
            JavascriptExecutor jse = (JavascriptExecutor)driver;
            jse.executeScript("window.scrollBy(0,1500)");

            if (!(driver.findElement(stickyNavBar).getAttribute("class").equals(correctClass)))
                throw new Exception();

        }
        catch (Exception e)
        {
            Assert.fail();
        }
        finally {
            driver.close();
            driver.quit();
        }


        }

    }





