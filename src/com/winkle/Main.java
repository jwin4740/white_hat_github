package com.winkle;

import com.winkle.ConfigUtils.IConfigLoaderImpl;
import com.winkle.RepoLInks.IRepoParserImpl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        IConfigLoaderImpl j = new IConfigLoaderImpl();
        WebDriver driver = j.getDriver();
        HashMap<String, String> props = j.getPropsMap();
        ArrayList<String> userArr = j.grabUsersFromFile();
        init(driver, props, userArr);
//        driver.get(baseUrl + "jwin4740?tab=repositories");


        // Close the browser
//        driver.quit();
    }

    private static void init(WebDriver driver, HashMap<String, String> props, ArrayList<String> userArr) {

        // login to github
        driver.get(props.get("baseUrl") + "login");

        WebElement uname = driver.findElement(By.id("login_field"));
        WebElement pass = driver.findElement(By.id("password"));
        WebElement submitBtn = driver.findElement(By.name("commit"));
        uname.sendKeys(props.get("username"));
        pass.sendKeys(props.get("password"));
        submitBtn.click();
        Runtime r = Runtime.getRuntime();
        System.out.println("No of Processor: " +
                r.availableProcessors());
        System.out.println("Total memory: " + r.totalMemory());
        System.out.println("Free memory: " + r.freeMemory());
        System.out.println("Memory occupied: " +
                (r.totalMemory() - r.freeMemory()));

//        r.gc();

        System.out.println("::Memory status::");
        System.out.println("Total memory: "+r.totalMemory());
        System.out.println("Free memory: "+r.freeMemory());
        System.out.println("Memory occupied: "+
                (r.totalMemory()-r.freeMemory()));
        for (String name : userArr) {
            IRepoParserImpl l = new IRepoParserImpl(props.get("baseUrl") + name + "?tab=repositories");
            l.gatherRepoLinks(driver, props);
            HashMap k = l.getRepos();
        }
    }
}