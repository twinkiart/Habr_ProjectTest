package com.example.habr_projecttest;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;

public class MainPageTest {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        // Fix the issue https://github.com/SeleniumHQ/selenium/issues/11750
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.habr.com/");

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void Disign() {
        WebElement DisignButon = driver.findElement(By.xpath("//*[contains(text(), 'Дизайн')]"));
        DisignButon.click();

        WebElement Company = driver.findElement(By.xpath("//*[contains(text(), 'Компании')]"));
        Company.click();

        assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Дизайн')]")).isDisplayed(), "Дизайн не найден");
    }
    @Test
    public void Sience() {
        WebElement Sience = driver.findElement(By.xpath("//*[contains(text(), 'Научпоп')]"));
        Sience.click();

        WebElement Filter = driver.findElement(By.xpath("//*[contains(text(), 'Все подряд')]"));
        Filter.click();

        WebElement Best = driver.findElement(By.xpath("//*[contains(text(), 'Лучшие')]"));
        Best.click();

        WebElement Accept = driver.findElement((By.xpath("//*[contains(text(), 'Применить')]")));
        Accept.click();

        assertTrue(driver.findElement(By.xpath("//*[contains(text(), 'Лучшие за сутки')]")).isDisplayed(), "Лучшие за сутки не найден");
    }

}
