package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.MomondoHomePage;

public class WebDriverMomondoTest {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserSetUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

    }


    @Test
    public void findTicketsWithSameDepartureAndArrivalTest() {
        String destinationPoint = "Minsk";
        MomondoHomePage homePage = new MomondoHomePage(driver)
                .openPage()
                .pressFindButton();
        Assert.assertTrue(homePage.isPageContainsError());

    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
    }


}
