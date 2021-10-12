import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.AbstractPage;
import pages.LoginPage;
import pages.MainPage;
import pages.TicketsPage;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelpdeskUITest {

    private WebDriver driver;

    @BeforeAll
    public void setup() throws IOException {
        // Читаем конфигурационный файл в System.properties
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver_win32\\chromedriver.exe");
        // Создание экземпляра драйвера
        driver = new ChromeDriver();
        // Устанавливаем размер окна браузера, как максимально возможный
        driver.manage().window().maximize();
        // Установим время ожидания для поиска элементов
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Установить созданный драйвер для поиска в веб-страницах
        AbstractPage.setDriver(driver);
    }

    @Test
    public void createTicketTest() throws IOException{
        driver.get(System.getProperty("site.url"));
        moveToTicketCreate();
        fillAndSubmit();
        // ...
        driver.navigate().to(System.getProperty("site.auth"));
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("user.properties"));
        login();
        // ...
        findCreatedTicket();
    }

    @Step
    public void moveToTicketCreate(){
        MainPage mainPage = new MainPage();
        mainPage.goAndCreate();
    }

    @Step
    public void fillAndSubmit(){
        TicketsPage ticketsPage=new TicketsPage();
        ticketsPage.fillAndSubmitForm();
    }

    @Step
    public void login(){
        LoginPage loginPage = new LoginPage();
        loginPage.login(System.getProperty("user"), System.getProperty("password"));
    }

    @Step
    public void findCreatedTicket(){
        Select length = new Select(driver.findElement(By.name("ticketTable_length")));
        length.selectByValue("100");
        WebElement ok=driver.findElement(By.xpath("//*[text()[contains(.,'BANANA')]]"));
        driver.close();
        Assertions.assertNotNull(ok);
    }
}
