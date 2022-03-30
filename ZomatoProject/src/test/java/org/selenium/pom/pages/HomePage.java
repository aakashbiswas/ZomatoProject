package org.selenium.pom.pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.base.BasePage;

public class HomePage extends BasePage {
    private final  By restaurentEnter= By.xpath("//input[@placeholder='Search for restaurant, cuisine or a dish']");
   private final By dinning_rating=By.xpath("((//input[@value='Cafe Coffee Day']//following::div[@color='#24963F'])[1]//div)[3]");
    private final By delivery_rating=By.xpath("((//input[@value='Cafe Coffee Day']//following::div[@color='#267E3E'])[1]//div)[3]");
    private  By dyanamicres;
    public HomePage(WebDriver driver, ExtentTest test) {
        super(driver,test);
    }
    public HomePage enterRestaurent(String restaurentName)
    {
        driver.get("https://www.zomato.com/");
        test.log(Status.INFO,"Url passed is https://www.zomato.com/");
        visiblityofElement(restaurentEnter);
        driver.findElement(restaurentEnter).sendKeys(restaurentName);
        test.log(Status.PASS,"The restaurent passed is"+restaurentName);
        driver.findElement(restaurentEnter).click();
        return this;
    }
    public String dinningRatingis()
    {
        visiblityofElement(dinning_rating);
        return driver.findElement(dinning_rating).getText();
    }
    public String deliveryRatingis()
    {
        visiblityofElement(delivery_rating);
        return driver.findElement(delivery_rating).getText();
    }
    public RestaurentPage navigateToRestaurentPage(String restaurentName)
    {
        dyanamicres=By.xpath("//p[text()='"+restaurentName+"']");
        visiblityofElement(dyanamicres);
        driver.findElement(dyanamicres).click();
        test.log(Status.PASS,"Navigated to the "+restaurentName+" page");
        return new RestaurentPage(driver,test);

    }
}
