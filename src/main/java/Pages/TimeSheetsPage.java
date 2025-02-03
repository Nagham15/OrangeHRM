package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TimeSheetsPage {

    WebDriver driver;
    WebDriverWait wait;

    public TimeSheetsPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    // TODO: define locators
    private By timeSheetsText =By.cssSelector(".oxd-text.oxd-text--h6.oxd-topbar-header-breadcrumb-module");
    private By employeeNameField=By.cssSelector("input[placeholder='Type for hints...']");
    private By viewButton=By.cssSelector("button[type='submit']");


    //TODO: define action methods
    public boolean isTimeSheetsTextVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(timeSheetsText));
        return driver.findElement(timeSheetsText).isDisplayed();
    }
    public void selectEmployee(String employee){
        driver.findElement(employeeNameField).sendKeys(employee);
        driver.findElement(viewButton).click();
    }
}
