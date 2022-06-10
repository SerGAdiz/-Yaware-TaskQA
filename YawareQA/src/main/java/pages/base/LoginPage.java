package pages.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static list_enums.Constant.Urls.YAWARE_TIME_TRACKER;

public class LoginPage extends BasePage {
    private final String title = "Yaware.TimeTracker - Автоматический учет времени и продуктивности";

    By userNameLocator = By.id("email");
    By passwordLocator = By.id("password");
    By signInButton = By.id("login-submit");

    public LoginPage(WebDriver driver) {
        super(driver);
        open(YAWARE_TIME_TRACKER);

        if(!title.equals(driver.getTitle())) {
            throw new IllegalStateException("This is not the login page!");
        }
    }

    public LoginPage typeUserName(String userName) {
        driver.findElement(userNameLocator).sendKeys(userName);
        return this;
    }

    public LoginPage typePassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
        return this;
    }

    public Object submitLogin() {
        driver.findElement(signInButton).click();
        return new Object();  //driver
    }

    public void signInButton() {
        driver.findElement(signInButton).click();
    }

    public Object loginAs(String username, String password) {
        typeUserName(username);
        typePassword(password);
        return submitLogin();
    }
}
