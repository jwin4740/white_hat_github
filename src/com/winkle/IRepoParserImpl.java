package com.winkle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class IRepoParserImpl implements IRepoParser {
    private HashMap<String, String> repos = new HashMap<>();



    public void gatherRepoLinks(WebDriver driver) {
        for (int i = 1; i < 25; i++) {
            WebElement j = driver.findElement(By.xpath("//*[@id=\"user-repositories-list\"]/ul/li[" + i + "]/div[1]/h3/a"));
            this.repos.put(j.getText(), j.getAttribute("href"));
        }

    }

    public HashMap getRepos() {
        return repos;
    }

}
