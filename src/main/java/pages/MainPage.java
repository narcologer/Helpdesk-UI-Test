package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MainPage extends AbstractPage {

    @FindBy(xpath = "//*[@id=\"wrapper\"]/ul/li[2]")
    private WebElement newTicketButton;
    @FindBy(name="ticketTable_length")
    private WebElement length;
    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
 ;

    public MainPage goAndCreate(){
        driver.get(System.getProperty("site.url"));
        newTicketButton.click();
        return this;
    }

    public MainPage finalSearch(){
        Select selLength =new Select(length);
        selLength.selectByValue("100");
        return this;
    }

    public boolean isElementPresent(String xpath) {
        try {
            driver.findElement(By.xpath(xpath));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
