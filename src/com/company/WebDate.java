package com.company;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.LocalDateTime;


public class WebDate extends Website {

    By date = By.className("date");

    public WebDate(WebDriver driver, String url) {
        super(driver, url);
    }


    public void checkDate() {
        try {

            setUp("N12 – אתר החדשות של ישראל");

            LocalDateTime now = LocalDateTime.now();
            String[] current_date = java.time.LocalDate.now().toString().split("-");
            String actuallyDay = current_date[2];
            String actuallyMonth = current_date[1];
            String actuallyYear = (current_date[0].substring(2)); // get year and taking the last 2 digits.

            // get date from n12 website and split. getDate() returns the date from n12.
            String[] n12_date = getDate().split("\\.");
            String day = ((n12_date[0]).split(" ")[1]);
            String month = ((n12_date[1]));
            String year = ((n12_date[2]));

            if(!(actuallyDay.equals(day) && actuallyMonth.equals(month) && actuallyYear.equals(year)))
            {
                throw new Exception();
            }
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


    public String getDate() {

        return driver.findElement(date).getText();

    }


}
