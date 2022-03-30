package org.selenium.pom.base;



import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected  ExtentTest test;

    public BasePage(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.test=test;
        wait=new WebDriverWait(driver, Duration.ofSeconds(15));
    }
public void visiblityofElement(By element)
{
    wait.until(ExpectedConditions.visibilityOfElementLocated(element));
}
public void presenceofElement(By element)
{
    wait.until(ExpectedConditions.presenceOfElementLocated(element));
}

}
