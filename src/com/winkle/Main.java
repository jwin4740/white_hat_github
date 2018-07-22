package com.winkle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;


public class Main  {
    public static void main(String[] args) throws InterruptedException {
    	Properties prop = new Properties();
    	InputStream input = null;
    	String userName = null;
    	String passWord = null;

    	try {

    		input = new FileInputStream("config.properties");

    		// load a properties file
    		prop.load(input);

    		// get the property value and print it out
    		userName = prop.getProperty("username");
    		passWord = prop.getProperty("password");
    	

    	} catch (IOException ex) {
    		ex.printStackTrace();
    	} finally {
    		if (input != null) {
    			try {
    				input.close();
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
    	}

      
    
        // Notice that the remainder of the code relies on the interface, 
        // not the implementation.
    	System.setProperty("webdriver.chrome.driver", "/home/james/bin/chromedriver");
    	WebDriver driver = new ChromeDriver();

        // And now use this to visit Google
        driver.get("https://github.com/login");
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

        
        //Close the browser
//        driver.quit();
    }
}