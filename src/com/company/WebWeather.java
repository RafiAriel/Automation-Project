package com.company;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.bind.Element;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebWeather extends Website {

    By ul = By.xpath("/html/body/main/div[2]/ul");
    By cityTitle = By.xpath("/html/body/main/div[1]/form/button/span[2]");

    public WebWeather(WebDriver driver, String url) { super(driver, url); }


    public void checkWeather() {
        try {
            setUp("N12 – אתר החדשות של ישראל");
            driver.navigate().to("https://www.mako.co.il/news-weather?partner=NavBar");
            String baseUrlWeather = "http://www.mako.co.il/news-weather?city=";
            ArrayList<String> cities = new ArrayList<>();

            // get all names of cities and add to array
            WebElement list = driver.findElement(ul);
            List rows = list.findElements(By.tagName("li"));
            for(int i=0; i<rows.size(); i++) {
                WebElement cityElement = (WebElement) rows.get(i);
                String[] city = cityElement.getText().split("\\n");
                cities.add(city[0]); // add the city name to arraylist.
            }

            for(int i=0; i<cities.size(); i++) {
                String cityName = cities.get(i);
                driver.get(baseUrlWeather + cityName);
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
                if (!(driver.findElement(cityTitle).getText().equals(cityName))) {
                    throw new Exception();
                }
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

}
