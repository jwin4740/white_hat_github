package com.winkle;

import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;

public interface IRepoParser {
    HashMap<String, String> repos = new HashMap<>();
    void gatherRepoLinks(WebDriver driver);


}
