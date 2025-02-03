import Pages.LoginPage;
import Pages.PasswordSentPage;
import Pages.ResetPasswordPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ResetPasswordTests extends BaseTest{
    ResetPasswordPage RP;
    LoginPage LP;
    @BeforeMethod
    public void Preconditions(){
        RP=new ResetPasswordPage(driver);
        LP=new LoginPage(driver);
    }
    @Test (description = "Reset password with valid username")
    public void ValidUser(){
        LP.clickForgotPassword();
        LP.addUserName("Admin");
       PasswordSentPage PS= RP.clickResetPasswordButton();
       assertTrue(PS.resetPasswordMessage());

    }
    @Test(description = "Reset password with empty user name")
    public void emptyUserName(){
        LP.clickForgotPassword();
        LP.addUserName("");
        RP.clickResetPasswordButton();
        assertTrue(LP.isValidationMessagesVisible());
    }
    @Test(description = "Click on cancel button")
    public void clickCancelButton(){
        LP.clickForgotPassword();
        LoginPage LP= RP.clickCancelButton();
        assertEquals(LP.getLoginUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

    }

}
