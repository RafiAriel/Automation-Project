package com.company;

import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tests {

    @Test
    public void test1()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Java/chrome95/chromedriver.exe");
        WebNavBar webNavBar = new WebNavBar(new ChromeDriver(), "https://www.n12.co.il/");
        webNavBar.clickSubject();

    }

    @Test
    public void test2()
    {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Java/chrome95/chromedriver.exe");
        WebDate webDate = new WebDate(new ChromeDriver(), "https://www.n12.co.il/");
        webDate.checkDate();

    }

    @Test
    public void test3() {
        System.setProperty("webdriver.chrome.driver", "C:/Program Files/Java/chrome95/chromedriver.exe");
        WebWeather webWeather = new WebWeather(new ChromeDriver(), "https://www.n12.co.il/");
        webWeather.checkWeather();

    }


}
