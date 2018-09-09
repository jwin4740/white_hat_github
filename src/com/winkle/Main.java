package com.winkle;

import com.winkle.ConfigUtils.IConfigLoaderImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        IConfigLoaderImpl j = new IConfigLoaderImpl();
        WebDriver driver = j.getDriver();
        HashMap<String, String> props = j.getPropsMap();
        // And now use this to visit Google
        login(driver, props);
//        driver.get(baseUrl + "jwin4740?tab=repositories");
//        IRepoParserImpl l = new IRepoParserImpl();
//        l.gatherRepoLinks(driver);
//        HashMap k = l.getRepos();


        // Close the browser
//        driver.quit();
    }

    private static void login(WebDriver driver, HashMap<String, String> props) {


        driver.get(props.get("baseUrl") + "login");

        WebElement uname = driver.findElement(By.id("login_field"));
        WebElement pass = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.name("commit"));


        uname.sendKeys(props.get("username"));
        pass.sendKeys(props.get("password"));
        submitBtn.click();
    }
}