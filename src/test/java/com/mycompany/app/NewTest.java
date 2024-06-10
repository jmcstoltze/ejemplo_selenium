package com.mycompany.app;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {

    private WebDriver driver;

    @Test
    public void f() {
        WebElement cuadroBusqueda = driver.findElement(By.name("q"));
        cuadroBusqueda.sendKeys("página principal iplacex");
        cuadroBusqueda.click();

        cuadroBusqueda.submit();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        assertEquals("página principal iplacex - Google search", driver.getTitle());
    }

    @BeforeTest
    public void BeforeTest() {
        System.setProperty("webdriver.chrome.driver",  "/home/jmcstolz/proyectos_integracion_continua/ejemplo-selenium/src/test/driver/chromedriver");

        // System.setProperty("webdriver.chrome.bin",  "/home/jmcstolz/proyectos_integracion_continua/ejemplo-selenium/src/test/driver/chromedriver");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
    }

    @AfterTest
    public void afterTest() {
        driver.quit();
    }
}