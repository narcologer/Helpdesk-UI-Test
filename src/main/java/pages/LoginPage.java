package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class LoginPage extends AbstractPage {

    private final WebDriver driver;

    // Обычный поиск элемента
    private WebElement username;

    // Поиск элемента через аннотацию
    //@FindBy(id = "password")
    private WebElement passfield;

    // todo: остальные элементы страницы
    private WebElement loginButton;

    public LoginPage(WebDriver driver) throws IOException {
        this.driver=driver;
        driver.navigate().to(System.getProperty("site.auth"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
        username = driver.findElement(By.id("username"));
        passfield= driver.findElement(By.id("password"));
        loginButton = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div/div/div/div[2]/form/input[1]"));
    }

    public void login(String user, String password) {
        username.sendKeys(user);
        passfield.sendKeys(password);
        loginButton.click();
    }
}
