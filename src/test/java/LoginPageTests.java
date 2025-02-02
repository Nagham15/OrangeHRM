import Pages.DashboardPage;
import Pages.LoginPage;
import Pages.ResetPasswordPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginPageTests extends BaseTest {
    LoginPage LP;
    DashboardPage DP;

    @BeforeMethod
    public void Preconditions(){
        LP=new LoginPage(driver);
        DP=new DashboardPage(driver);
    }

    @Test (description = "Login with valid username and password")
    public void validLogin(){
        LP.addUserName("Admin");
        LP.addPassword("admin123");
        LP.clickLoginButton();
        assertTrue(DP.isDashboardWordVisible());
    }
    @Test(description ="Login with invalid username and valid password")
    public void invalidUserName(){
        LP.addUserName("Nagham");
        LP.addPassword("admin123");
        LP.clickLoginButton();
        assertTrue(LP.isErrorMessageVisible());
    }
    @Test (description = "Login with invalid password and valid username")
    public void invalidPassword(){
        LP.addUserName("Admin");
        LP.addPassword("12345");
        LP.clickLoginButton();
        assertTrue(LP.isErrorMessageVisible());
    }
    @Test(description = "Login with empty username")
    public void emptyUserName(){
       LP.addUserName("");
       LP.addPassword("admin123");
       LP.clickLoginButton();
        assertTrue(LP.isValidationMessagesVisible());
    }
    @Test(description = "Login with empty password")
    public void emptyPassword(){
        LP.addUserName("Admin");
        LP.addPassword("");
        LP.clickLoginButton();
        assertTrue(LP.isValidationMessagesVisible());
    }
    @Test(description = "Login with empty username and password")
    public void emptyUserNameAndPassword(){
        LP.addUserName("");
        LP.addPassword("");
        LP.clickLoginButton();
        assertTrue(LP.isValidationMessagesVisible());
    }
    @Test(description = "Click on forgot your password ?")
    public void forgotYourPassword(){
       ResetPasswordPage RP= LP.clickForgotPassword();
       assertEquals(RP.getResetPasswordUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode");

    }

}
