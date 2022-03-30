package org.selenium.pom.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class RestaurentPage extends BasePage {
   private final By review=By.xpath("//a[text()='Reviews']");
    private final By highestcomment=By.xpath("((((//div[@color='#0E5020'])[1]//parent::div)[1]//parent::div)[1]//following-sibling::p)[2]");
    private final By ratinghigh=By.xpath("//div[@color='#0E5020']");
    private final By lowrating=By.xpath("//div[@color='#EF4F5F']");
    private final By lowratingcomment=By.xpath("((((//div[@color='#EF4F5F'])[1]//parent::div)[1]//parent::div)[1]//following-sibling::p)[2]");
    public RestaurentPage(WebDriver driver, ExtentTest test) {
        super(driver,test);
    }
    public RestaurentPage navigateToReviewTab()
    {
        visiblityofElement(review);
        driver.findElement(review).click();
        test.log(Status.PASS,"Navigated to the Review Section");
        return this;
    }
    public String fetchHighestRatingComment()
    {
        String highestComm="";
        presenceofElement(ratinghigh);
        presenceofElement(highestcomment);
        if(driver.findElements(ratinghigh).size()>0)
        {
            highestComm= driver.findElement(highestcomment).getText();
        }
        return highestComm;
    }
    public String fetchLowestRatingComment()
    {
        String lowestComm="";
        presenceofElement(lowrating);
        presenceofElement(lowratingcomment);
        if(driver.findElements(lowrating).size()>0)
        {
            lowestComm= driver.findElement(lowratingcomment).getText();
        }
        return lowestComm;
    }
}
