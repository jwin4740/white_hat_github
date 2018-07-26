package com.winkle;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLOutput;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        IConfigLoaderImpl j = new IConfigLoaderImpl();
        j.setUsernameAndPassword();
        String userName = j.getUserName();
        String passWord = j.getPassword();

        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
        System.setProperty("webdriver.chrome.driver", "/home/james/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String baseUrl = "https://github.com/";
        // And now use this to visit Google
        login(driver, baseUrl, userName, passWord, js);
        driver.get(baseUrl + "jwin4740?tab=repositories");
        IRepoParserImpl l = new IRepoParserImpl();
        l.gatherRepoLinks(driver);
        System.out.println(l.getRepos());


        // Close the browser
//        driver.quit();
    }

    private static void login(WebDriver driver, String baseUrl, String userName, String passWord, JavascriptExecutor js) throws InterruptedException {

        driver.get(baseUrl + "login");


        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");

        // Find the text input element by its name
        WebElement uname = driver.findElement(By.id("login_field"));
        WebElement pass = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.name("commit"));

        // Enter something to search for
        uname.sendKeys(userName);
        pass.sendKeys(passWord);
        submitBtn.click();
        Thread.sleep(1000);

    }
}