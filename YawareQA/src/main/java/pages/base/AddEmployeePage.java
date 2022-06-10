package pages.base;

import list_enums.Popup;
import list_enums.OsList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

import static list_enums.Popup.*;
import static list_enums.Constant.TimeoutVariable.EXPLICIT_WAIT;

public class AddEmployeePage extends BasePage implements ActionsEmployee {
    By importEmployee = By.id("button-1037-btnInnerEl");
    By uploadFile = By.id("file");
    By importButton = By.id("yaware-modal-button-0");
    By gridOfImportedEmployees = By.xpath("//tbody[@id='gridview-1034-body']/tr");
    By refreshButton = By.id("button-1036-btnEl");
    By deleteButton = By.id("yaware-modal-button-0");
    By successInvitation = By.xpath("//div[@class='toast toast-success']");

    public AddEmployeePage(WebDriver driver) {
        super(driver);
    }

    public AddEmployeePage importEmployeeButtonFromGrid() {
        waitElementIsVisible(driver.findElement(importEmployee)).click();
        return this;
    }

    public AddEmployeePage uploadUsersFile() {
        File file = new File("users.csv");
        driver.findElement(uploadFile).sendKeys(file.getAbsolutePath());

        driver.findElement(importButton).click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(importButton).click();
        return this;
    }

    public List<WebElement> getGridOfImportedEmployees() {
        refresh();
        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT))
                .until(ExpectedConditions.presenceOfElementLocated(gridOfImportedEmployees)));
        return driver.findElements(gridOfImportedEmployees);
    }

    public String getNameOfImportedEmployee(WebElement element) {
        waitElementIsVisible(element);
        String id = element.getDomProperty("id");
        String name = driver.findElement(By.xpath("//tr[@id='" + id + "']/td[1]/div")).getText();
        return name;
    }

    public AddEmployeePage refresh() {
        driver.navigate().refresh();
        return this;
    }

    public boolean isDisplayed(Popup alert) {
        boolean isDisplayed = false;

        switch (alert) {
            case SuccessInvitation:
                isDisplayed = driver.findElement(By.xpath(SuccessInvitation.getPopup())).isDisplayed();
                break;
            case Error:
                isDisplayed = driver.findElement(By.xpath((Error.getPopup()))).isDisplayed();
                break;
            case Ready:
                isDisplayed = driver.findElement(By.xpath(Ready.getPopup())).isDisplayed();
                break;
            case Copied:
                isDisplayed = driver.findElement(By.xpath(Copied.getPopup())).isDisplayed();
        }
        return  isDisplayed;
    }

    @Override
    public String copyLinkToDownload(WebElement element, OsList os) {
        String id = element.getDomProperty("id");
        String downloadLink = "";
        driver.findElement(By.xpath("//tr[@id='" + id + "']/td[5]/div/a[1]")).click();

        switch (os) {
            case Windows:
                driver.findElement(By.id(OsList.Windows.getLinkForDownload())).click();
                downloadLink = driver.findElement(By.id(OsList.Windows.getLinkForDownload())).getAttribute("data-base");
                break;
            case Linux:
                driver.findElement(By.id(OsList.Linux.getLinkForDownload())).click();
                downloadLink = driver.findElement(By.id(OsList.Linux.getLinkForDownload())).getAttribute("data-base");
                break;
            case MacOS:
                driver.findElement(By.id(OsList.MacOS.getLinkForDownload())).click();
                downloadLink = driver.findElement(By.id(OsList.MacOS.getLinkForDownload())).getAttribute("data-base");
                break;
        }
        return downloadLink;
    }

    @Override
    public AddEmployeePage deleteInvitation(WebElement employee) {
        String id = employee.getDomProperty("id");

        WebElement element = (new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@id='" + id + "']/td[5]/div/a[2]")));
        element.click();

        element = (new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT)))
                .until(ExpectedConditions.elementToBeClickable(deleteButton));
        element.click();
        return this;
    }

    @Override
    public AddEmployeePage sendInvitationAgain(WebElement employee) {
        waitElementIsVisible(employee);
        String id = employee.getDomProperty("id");
        driver.findElement(By.xpath("//tr[@id='" + id + "']/td[5]/div/a[3]")).click();
        return this;
    }
}
