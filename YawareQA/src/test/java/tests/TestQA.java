package tests;

import common.FileInteraction;
import list_enums.Popup;
import list_enums.OsList;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestQA extends BaseTest {
    public static final String userName = "o.babeniuk+555@yaware.com";
    public static final String password = "123456";

    public static final String windows = "winqt/AgentSetup.exe";
    public static final String linux = "linux/yaware-installer.sh";
    public static final String macOS = "mac/yaware2.0.6.42.dmg";

    @BeforeTest
    public void createCvsFile() {
        FileInteraction.createCsvFile();
        loginPage.loginAs(userName, password);
        homePage.addEmployeeButton();
    }

    @Test
    public void test() {
        addEmployeePage.importEmployeeButtonFromGrid();
        addEmployeePage.uploadUsersFile();

        //Get list of imported employees.
        List<WebElement> employee = addEmployeePage.getGridOfImportedEmployees();
        String nameEmployee = addEmployeePage.getNameOfImportedEmployee(employee.get(0));

        //Get links for 'Window/Linux/MacOS' platform.
        String windowsLink = addEmployeePage.copyLinkToDownload(employee.get(0), OsList.Windows);
        String linuxLink = addEmployeePage.copyLinkToDownload(employee.get(0), OsList.Linux);
        String macOSLink = addEmployeePage.copyLinkToDownload(employee.get(0), OsList.MacOS);

        //Verification links
        Assert.assertTrue(
                windowsLink.contains(windows));
        Assert.assertTrue(
                linuxLink.contains(linux));
        Assert.assertTrue(
                macOSLink.contains(macOS));

        //Send invitation from employee
        addEmployeePage.sendInvitationAgain(employee.get(0));

        //Verification popup window 'After invitation'
        Assert.assertTrue(
                addEmployeePage.isDisplayed(Popup.SuccessInvitation));

        //Delete employee from imported employee grid
        addEmployeePage.deleteInvitation(employee.get(0));

        //Verified that the popup appeared and employee deleted
        Assert.assertTrue(
                addEmployeePage.isDisplayed(Popup.Ready));

        employee = addEmployeePage.getGridOfImportedEmployees();
        Assert.assertFalse(
                addEmployeePage.getNameOfImportedEmployee(employee.get(0)).
                        equals(nameEmployee));
    }
}