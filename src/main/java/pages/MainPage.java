package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    private WebElement newTicketButton;
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage goAndCreate(){
        driver.get(System.getProperty("site.url"));
        newTicketButton = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/ul/li[2]/a"));
        newTicketButton.click();
        return this;
    }

}
