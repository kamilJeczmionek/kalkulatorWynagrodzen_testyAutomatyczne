package Tests;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class calculateSetsOfData_Chrome {
    WebDriver driver;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
    @BeforeEach
    public void chromedriverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://wynagrodzenia.pl/kalkulator-wynagrodzen");
        WebElement confirmationButton = driver.findElement(By.xpath("/html/body/div[15]/div[2]/div[2]/div[2]/div[2]/button[1]"));
        wait.until(ExpectedConditions.visibilityOf(confirmationButton)).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
    }

    @Test
    public void setOfData001() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"sky-form4\"]/div[2]/div[1]/button"));
        WebElement contractValue = driver.findElement(By.id("sedlak_calculator_earnings"));
        contractValue.sendKeys("5000");
        driver.findElement(By.id("sedlak_calculator_save")).click();
    }
    @AfterEach
    public void chromedriverQuit() {
        driver.quit();
    }
}
