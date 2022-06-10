package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

    By addEmployee = By.xpath("//a[@href='/invite']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage addEmployeeButton() {
        driver.findElement(addEmployee).click();
        return this;
    }
}
