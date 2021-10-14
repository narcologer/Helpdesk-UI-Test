package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TicketsPage extends AbstractPage {
    private final WebDriver driver;
    Select queue;
    WebElement title;
    WebElement description;
    WebElement calendar;
    WebElement email;
    WebElement submitButton;

    public TicketsPage(WebDriver driver) {
        this.driver = driver;
        queue = new Select(driver.findElement(By.name("queue")));
        title = driver.findElement(By.name("title"));
        description = driver.findElement(By.name("body"));
        calendar = driver.findElement(By.name("due_date"));
        email = driver.findElement(By.name("submitter_email"));
        submitButton = driver.findElement(By.xpath("//*[@id=\"content-wrapper\"]/div/div/div/div[2]/form/button"));
    }

    public TicketsPage fillAndSubmitForm(){
        queue.selectByIndex(1);
        title.sendKeys("BANANA");
        description.sendKeys("12345678");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        calendar.sendKeys("2021-10-15 00:00:00");
        email.sendKeys("2pizza@gmail.ru");
        submitButton.click();
        return this;
    }
}
