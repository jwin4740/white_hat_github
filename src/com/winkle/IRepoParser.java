package com.winkle;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public interface IRepoParser {
    HashMap<String, String> repos = new HashMap<>();
    void gatherRepoLinks(WebDriver driver);
    void enterFile(WebDriver driver, WebElement j);


}
