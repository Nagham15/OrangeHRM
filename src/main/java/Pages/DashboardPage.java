package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;
    public DashboardPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    // TODO: define locators
    private By dashboardText=By.xpath("//h6[text()='Dashboard']");
    private By timeSheetsOption=By.cssSelector("button[title='Timesheets'] svg");
    private By search=By.xpath("//input[@placeholder='Search']");
    private By adminCategory=By.cssSelector("a[href='/web/index.php/admin/viewAdminModule']");

    //TODO: define action methods
    public boolean isDashboardWordVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardText));
        return driver.findElement(dashboardText).isDisplayed();
    }
    public void clickTimeSheets(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(timeSheetsOption));
        driver.findElement(timeSheetsOption).click();
    }
    public void clickSearch(String category){
        driver.findElement(search).sendKeys(category);
    }
    public void chooseAdminCategory(){
        driver.findElement(adminCategory).click();
    }

}
