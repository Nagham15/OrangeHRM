package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    WebDriver driver;
    WebDriverWait wait;

    private By dashboardIcon=By.xpath("//h6[text()='Dashboard']");
    public DashboardPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    public boolean isDashboardWordVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardIcon));
        return driver.findElement(dashboardIcon).isDisplayed();
    }
}
