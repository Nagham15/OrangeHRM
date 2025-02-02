package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ResetPasswordPage {
    WebDriver driver;
    WebDriverWait wait;


    private By resetPasswordButton=By.cssSelector("button[type='submit']");
    private By cancelButton=By.cssSelector("button[type='button']");
    public ResetPasswordPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public String getResetPasswordUrl(){
        return driver.getCurrentUrl();
    }

    public PasswordSentPage clickResetPasswordButton(){

        driver.findElement(resetPasswordButton).click();
        return new PasswordSentPage(driver);
    }
    public LoginPage clickCancelButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(cancelButton));
        driver.findElement(cancelButton).click();
        return new LoginPage(driver);

    }
}
