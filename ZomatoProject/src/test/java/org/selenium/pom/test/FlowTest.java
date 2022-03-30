package org.selenium.pom.test;
import com.aventstack.extentreports.Status;
import org.selenium.pom.pages.RestaurentPage;
import org.testng.annotations.Test;
import org.selenium.pom.base.BaseTest;
import org.selenium.pom.pages.HomePage;

public class FlowTest extends BaseTest {

    @Test
    public void zomatoTest()
    {

        HomePage home=new HomePage(driver,ve).enterRestaurent("Cafe Coffee Day");
        //System.out.println("Dinning rating is="+home.dinningRatingis());
        ve.log(Status.INFO,"the dining rating is "+ home.dinningRatingis());
        //System.out.println("Delivery rating is="+home.deliveryRatingis());
        ve.log(Status.INFO,"the delivery rating is "+ home.deliveryRatingis());
        RestaurentPage restaurentPage=home.navigateToRestaurentPage("Cafe Coffee Day").navigateToReviewTab();
        //System.out.println("Highest Rating comment is= "+restaurentPage.fetchHighestRatingComment());
        ve.log(Status.INFO,"Highest Comment is = "+restaurentPage.fetchHighestRatingComment());
        //System.out.println("Lowest Rating comment is ="+restaurentPage.fetchLowestRatingComment());
        ve.log(Status.INFO,"Lowest Rating comment is = "+restaurentPage.fetchLowestRatingComment());
    }
}
