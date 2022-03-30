package org.selenium.pom.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.factory.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected  WebDriver driver;
    protected ExtentReports extentReports;
    protected ExtentSparkReporter extentSparkReporter;
    protected ExtentTest ve;
    @BeforeMethod
    public  void startDriver()
    {
        driver=new DriverManager().initializeDriver();
        extentReports= new ExtentReports();
        extentSparkReporter=new ExtentSparkReporter("targets/Spark.html");
        extentReports.attachReporter(extentSparkReporter);
        ve = extentReports.createTest("Zomato test case start");


    }
    @AfterMethod
    public void quitDriver()
    {
      extentReports.flush();
driver.quit();
    }
}
