package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DashboardPage extends AbstractPage {
    private final WebDriver driver;
    public WebElement ok;
    private Select length;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }
    public DashboardPage finalSearch(){
        length = new Select(driver.findElement(By.name("ticketTable_length")));
        length.selectByValue("100");
        ok=driver.findElement(By.xpath("//*[text()[contains(.,'BANANA')]]"));
        return this;
    }
}
