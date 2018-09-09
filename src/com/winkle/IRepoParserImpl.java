package com.winkle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class IRepoParserImpl implements IRepoParser {
    private HashMap<String, String> repos = new HashMap<>();


    public void gatherRepoLinks(WebDriver driver) {
        for (int i = 1; i < 2; i++) {
            WebElement j = driver.findElement(By.xpath("//*[@id=\"user-repositories-list\"]/ul/li[" + i + "]/div[1]/h3/a"));
            enterFile(driver, j);
            String repoName = j.getText();
            System.out.println(repoName);
            this.repos.put(repoName, j.getAttribute("href"));
        }

    }


    public void enterFile(WebDriver driver, WebElement j) {
        j.click();
        //*[@id="js-repo-pjax-container"]/div[2]/div[1]/div[5]/div[3]/a[2]
        //*[@id="js-repo-pjax-container"]/div[2]/div[1]/div[5]/div[3]/a[2]

        WebElement k = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/div[1]/div[5]/div[3]/a[2]"));

        driver.get( k.getAttribute("href"));



    }

    public HashMap getRepos() {
        return repos;
    }

}
