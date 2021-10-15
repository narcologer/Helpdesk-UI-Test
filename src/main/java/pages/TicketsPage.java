package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TicketsPage extends AbstractPage {
    private final WebDriver driver;
    @FindBy(name="queue")
    WebElement queue;
    @FindBy(name="title")
    WebElement title;
    @FindBy(name="body")
    WebElement description;
    @FindBy(name="due_date")
    WebElement calendar;
    @FindBy(name="submitter_email")
    WebElement email;
    @FindBy(xpath="//*[@id=\"content-wrapper\"]/div/div/div/div[2]/form/button")
    WebElement submitButton;

    public TicketsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public TicketsPage fillAndSubmitForm(){
        Select selQueue = new Select(queue);
        selQueue.selectByIndex(1);
        title.sendKeys(System.getProperty("title.ticket"));
        description.sendKeys("12345678");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        calendar.sendKeys("2021-10-15 00:00:00");
        email.sendKeys("2pizza@gmail.ru");
        submitButton.click();
        return this;
    }
}
