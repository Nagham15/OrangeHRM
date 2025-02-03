package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PasswordSentPage {
    WebDriver driver;
    WebDriverWait wait;
    // TODO: define locators
    private  By resetPasswordLinkSent= By.xpath("//h6[text()='Reset Password link sent successfully']");

    //TODO: define action methods
    public PasswordSentPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public boolean resetPasswordMessage(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(resetPasswordLinkSent));
       return driver.findElement(resetPasswordLinkSent).isDisplayed();
    }

}
