import Pages.DashboardPage;
import Pages.TimeSheetsPage;
import Pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class TimeSheetsPageTests extends BaseTest{
    LoginPage LP;
    DashboardPage DP;
    TimeSheetsPage TP;

    @BeforeMethod
    public void preConditions(){
        LP=new LoginPage(driver);
        DP=new DashboardPage(driver);
        TP=new TimeSheetsPage(driver);

    }
    @Test
    public void leaveForm(){
        LP.loginSteps("Admin","admin123");
        assertTrue(DP.isDashboardWordVisible());
        DP.clickTimeSheets();
        assertTrue(TP.isTimeSheetsTextVisible());
        TP.selectEmployee("shoval malka akhil kattan");
    }
}
