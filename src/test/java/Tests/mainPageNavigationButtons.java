package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class mainPageNavigationButtons {
        WebDriver driver;
        WebDriverWait wait;

        @BeforeEach
        public void chromedriverSetup() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.navigate().to("https://zarobki.pracuj.pl/");
            WebElement confirmationButton = driver.findElement(By.xpath("//*[@id=\"gp_cookie_agreements\"]/div/div/div/div[3]/div/button[1]"));
            wait = new WebDriverWait(driver, Duration.ofMillis(2000));
            wait.until(ExpectedConditions.visibilityOf(confirmationButton)).click();
        }
    @Test
    public void grossNetCalculatorBtn() {
        WebElement grossNetCalculatorBtn = driver.findElement(By.xpath("//*[@id=\"calculator\"]/div[3]/div/div/div/div/div/div/ul/li[1]/a"));
        grossNetCalculatorBtn.click();
        assertEquals("https://zarobki.pracuj.pl/kalkulator-wynagrodzen", driver.getCurrentUrl());
    }
    @Test
    public void hourlyCalculatorBtn() {
        WebElement hourlyCalculatorBtn = driver.findElement(By.xpath("//*[@id=\"calculator\"]/div[3]/div/div/div/div/div/div/ul/li[2]/a"));
        hourlyCalculatorBtn.click();
        assertEquals("https://zarobki.pracuj.pl/kalkulator-godzinowy", driver.getCurrentUrl());
    }
    @Test
    public void maternityLeaveLengthCalculatorBtn() {
        WebElement maternityLeaveLengthCalculatorBtn = driver.findElement(By.xpath("//*[@id=\"calculator\"]/div[3]/div/div/div/div/div/div/ul/li[3]/a"));
        maternityLeaveLengthCalculatorBtn.click();
        assertEquals("https://zarobki.pracuj.pl/kalkulator-urlopu-macierzynskiego-i-rodzicielskiego", driver.getCurrentUrl());
    }
    @Test
    public void domesticBusinessTripCalculatorBtn() {
        WebElement domesticBusinessTripCalculatorBtn = driver.findElement(By.xpath("//*[@id=\"calculator\"]/div[3]/div/div/div/div/div/div/ul/li[4]/a"));
        domesticBusinessTripCalculatorBtn.click();
        assertEquals("https://zarobki.pracuj.pl/kalkulator-krajowej-podrozy-sluzbowej", driver.getCurrentUrl());
    }
    @AfterEach
    public void chromedriverQuit() {
            driver.quit();
    }
}
