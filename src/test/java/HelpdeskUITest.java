import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelpdeskUITest {

    private WebDriver driver;

    @Before
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

    @Step("Переход на страницу создания тикета")
    public void moveToTicketCreate() throws IOException {
        MainPage mainPage = new MainPage(driver);
        mainPage.goAndCreate();
        createScreenshot();
    }

    @Step("Заполнение формы")
    public void fillAndSubmit() throws IOException {
        TicketsPage ticketsPage=new TicketsPage(driver);
        ticketsPage.fillAndSubmitForm();
        createScreenshot();
    }

    @Step("Вход под админа")
    public void login() throws IOException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(System.getProperty("user"), System.getProperty("password"));
        createScreenshot();
    }

    @Step("Поиск в дэшборде созданного тикета")
    public void findCreatedTicket() throws IOException {
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.finalSearch();
        createScreenshot();
        driver.close();
        Assert.assertNotNull(dashboardPage.ok);
    }

    @Attachment
    private byte[] createScreenshot() throws IOException {
        final Screenshot screenshot = new AShot()
                .shootingStrategy(ShootingStrategies.viewportPasting(100))
                .takeScreenshot(driver);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(screenshot.getImage(),"PNG",baos);
        baos.flush();
        byte[] imageInByte = baos.toByteArray();
        baos.close();
        return imageInByte;
    }
}
