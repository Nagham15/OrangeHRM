import Pages.AdminPage;
import Pages.DashboardPage;
import Pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DashboardTests extends BaseTest{
    LoginPage LP;
    DashboardPage DP;
    AdminPage AP;
    @BeforeMethod
    public void preConditions(){
        LP=new LoginPage(driver);
        DP=new DashboardPage(driver);
        AP=new AdminPage(driver);
    }
    @Test
    public void searchForCategory(){
        LP.loginSteps("Admin","admin123");
        assertTrue(DP.isDashboardWordVisible());
        DP.clickSearch("Admin");
        DP.chooseAdminCategory();
        assertTrue(AP.isAdminTextVisible());

    }
}
