package com.winkle.RepoLInks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public interface IRepoParser {

    void gatherRepoLinks(WebDriver driver, HashMap<String, String> props);

    void enterFile(WebDriver driver, WebElement j);


}
