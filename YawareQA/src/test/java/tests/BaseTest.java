package tests;

import common.CommonAction;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import pages.base.AddEmployeePage;
import pages.base.HomePage;
import pages.base.LoginPage;

public class BaseTest {
    protected WebDriver driver = CommonAction.createDriver();
    protected LoginPage loginPage = new LoginPage(driver);
    protected HomePage homePage = new HomePage(driver);
    protected AddEmployeePage addEmployeePage = new AddEmployeePage(driver);

    @AfterSuite(alwaysRun = true)
    public void close() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
