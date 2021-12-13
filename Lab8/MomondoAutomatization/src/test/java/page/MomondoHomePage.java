package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MomondoHomePage extends AbstractPage{

    private static final String PAGE_URL = "https://www.momondo.by/";
    private static final String HEADER_XPATH = "//div[@class=\"Common-Layout-React-StandardHeader-container\"]";
    private static final String FIND_BUTTON_XPATH = "//button[contains(@class,\"Iqt3 Iqt3-mod-stretch\")]";
    private static final String ERROR_MESSAGE_XPATH = "//div[@class=\"Pbmc-title\"]";

    @FindBy (xpath = FIND_BUTTON_XPATH)
    private WebElement findButton;

    public MomondoHomePage(WebDriver driver) {
        super(driver);
    }

    public MomondoHomePage openPage(){
        driver.get(PAGE_URL);
        return this;
    }

    public MomondoHomePage pressFindButton(){
        findButton.click();

        return this;
    }

    public boolean isPageContainsError(){

        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ERROR_MESSAGE_XPATH)));
        return driver.findElements(By.xpath(ERROR_MESSAGE_XPATH)).size() > 0;
    }
}
