package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    // Обычный поиск элемента
    private WebElement username = driver.findElement(By.id("username"));

    // Поиск элемента через аннотацию
    //@FindBy(id = "password")
    private WebElement passfield= driver.findElement(By.id("password"));;

    // todo: остальные элементы страницы
    private WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div/div/div/div[2]/form/input[1]"));

    public void login(String user, String password) {
        username.sendKeys(user);
        passfield.sendKeys(password);
        loginButton.click();
    }
}
