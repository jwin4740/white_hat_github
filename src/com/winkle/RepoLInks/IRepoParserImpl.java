package com.winkle.RepoLInks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IRepoParserImpl implements IRepoParser {
    private HashMap<String, String> repos = new HashMap<>();
    public String gitUser;

    public IRepoParserImpl(String gitUser) {
        this.gitUser = gitUser;
    }

    public void gatherRepoLinks(WebDriver driver, HashMap<String, String> props) {
        Boolean result = false;

        ArrayList<String> repos = new ArrayList<>();
        driver.get(gitUser);
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        String script1 = "";
        String script2 = "var k = document.querySelectorAll('[itemprop=\"name codeRepository\"]'); var len = k.length; let arr = []; for (var i = 0; i < len; i++){\n" +
                "    arr.push(k[i].href);\n" +
                "}; return arr;";

        // get links into arraylist

        // check to see if there are more pages to scrape
        while (!result) {
            ArrayList<String> res2 = (ArrayList<String>) js.executeScript(script2);
            repos.addAll(res2);
            WebElement k;
            try {
                k = driver.findElement(By.xpath("//*[@id=\"js-pjax-container\"]/div/div[2]/div[3]/div[3]/div/a"));
                System.out.println(k.getText());
                k.click();
            } catch (Exception e) {
                result = true;
                System.out.println(e);
            } finally {
                for (String repo : repos) {
                    System.out.println(repo);
                }
                System.out.println("\n\n");

            }
        }


    }


    public void enterFile(WebDriver driver, WebElement j) {
        j.click();
        //*[@id="js-repo-pjax-container"]/div[2]/div[1]/div[5]/div[3]/a[2]
        //*[@id="js-repo-pjax-container"]/div[2]/div[1]/div[5]/div[3]/a[2]

        WebElement k = driver.findElement(By.xpath("//*[@id=\"js-repo-pjax-container\"]/div[2]/div[1]/div[5]/div[3]/a[2]"));

        driver.get(k.getAttribute("href"));


    }

    public HashMap getRepos() {
        return repos;
    }

}
