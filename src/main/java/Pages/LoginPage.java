package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    // TODO: define locators
    private By userNameField=By.name("username");
    private By passwordField=By.cssSelector("input[type='password']");
    private By loginButton=By.cssSelector("button[type='submit']");
    private By forgotPassword=By.xpath("//p[text()='Forgot your password? ']");
    private By errorMsg=By.cssSelector(".oxd-text.oxd-text--p.oxd-alert-content-text");
    private By validationMsg=By.tagName("span");

    public LoginPage(WebDriver driver){
        this.driver=driver;
        this.wait=new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    //TODO: define action methods
    public void addUserName(String userName){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        driver.findElement(userNameField).sendKeys(userName);
    }

    public void loginSteps(String userName,String password){
        wait.until(ExpectedConditions.visibilityOfElementLocated(userNameField));
        driver.findElement(userNameField).sendKeys(userName);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginButton).click();
    }
    public boolean isErrorMessageVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg));
        return driver.findElement(errorMsg).isDisplayed();
    }

    public boolean isValidationMessagesVisible(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(validationMsg));
        List<WebElement>requiredErrorList=driver.findElements(validationMsg);
        for (int i=0; i<requiredErrorList.size();i++){
            if(!requiredErrorList.get(0).isDisplayed()){
                return false;
            }
        }
        return true;
    }
    public ResetPasswordPage clickForgotPassword(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(forgotPassword));
        driver.findElement(forgotPassword).click();
        return new ResetPasswordPage(driver);
    }
    public String getLoginUrl(){
        return driver.getCurrentUrl();
    }
}
