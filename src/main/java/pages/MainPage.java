package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends AbstractPage {
    private WebElement newTicketButton;
    private final WebDriver driver;
    public WebElement ok;
    private Select length;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
 ;

    public MainPage goAndCreate(){
        driver.get(System.getProperty("site.url"));
        newTicketButton = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/ul/li[2]/a"));
        newTicketButton.click();
        return this;
    }

    public MainPage finalSearch(){
        length = new Select(driver.findElement(By.name("ticketTable_length")));
        length.selectByValue("100");
        ok=driver.findElement(By.xpath("//*[text()[contains(.,'BANANA')]]"));
        return this;
    }
}
