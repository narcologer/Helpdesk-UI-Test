package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends AbstractPage {

    private final WebDriver driver;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement passfield;

    @FindBy(xpath = "//*[@id=\"content-wrapper\"]/div/div/div/div[2]/form/input[1]")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) throws IOException {
        this.driver=driver;
        PageFactory.initElements(driver, this);
        driver.navigate().to(System.getProperty("site.auth"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
        }

    public void login(String user, String password) {
        username.sendKeys(user);
        passfield.sendKeys(password);
        loginButton.click();
    }
}
