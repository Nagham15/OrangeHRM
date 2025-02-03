package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AdminPage {
    WebDriver driver;
    public AdminPage(WebDriver driver){
        this.driver=driver;
    }
    // TODO: define locators
    private By adminText=By.xpath("//h6[normalize-space()='Admin']");
    //TODO: define action methods
    public boolean isAdminTextVisible(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(adminText));
        return driver.findElement(adminText).isDisplayed();
    }
}
