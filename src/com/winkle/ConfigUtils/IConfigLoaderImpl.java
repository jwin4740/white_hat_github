package com.winkle.ConfigUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import java.util.Scanner;

public class IConfigLoaderImpl implements IConfigLoader {
    private Properties prop = new Properties();
    private InputStream input = null;
    private String passWord = null;
    private String userName = null;
    private String driverLocation;
    private HashMap<String, String> props = new HashMap<>();


    public ArrayList<String> grabUsersFromFile() {


        ArrayList<String> arr = new ArrayList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("./users.txt"));
            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                arr.add(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public WebDriver setDriverOptions() {
        ChromeOptions o = new ChromeOptions();
        o.addArguments("--start-maximized");

        // location of your chromdriver
        System.setProperty("webdriver.chrome.driver", this.driverLocation);

        return new ChromeDriver(o);
    }

    public void setProperties() {
        try {

            InputStream input = new FileInputStream("config.properties");

            // load a properties file
            prop.load(input);

            this.props.put("baseUrl", prop.getProperty("baseUrl"));
            this.driverLocation = prop.getProperty("driverLocation");
            this.props.put("driverLocation", prop.getProperty("driverLocation"));
            this.props.put("username", prop.getProperty("username"));
            this.props.put("password", prop.getProperty("password"));
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
    }

    public WebDriver getDriver() {
        setProperties();
        return setDriverOptions();
    }

    public HashMap<String, String> getPropsMap() {
        return this.props;
    }

}
