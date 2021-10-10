package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    private WebElement newTicketButton = driver.findElement(By.xpath("//*[@id=\"wrapper\"]/ul/li[2]/a"));
    public void goAndCreate(){
        newTicketButton.click();
    }
}
