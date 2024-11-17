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

public class calculateSetsOfData_Chrome {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeEach
    public void chromedriverSetup() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://zarobki.pracuj.pl/zaawansowany-kalkulator-wynagrodzen");
        WebElement confirmationButton = driver.findElement(By.xpath("//*[@id=\"gp_cookie_agreements\"]/div[2]/div/div/div[3]/div/button[1]"));
        wait = new WebDriverWait(driver, Duration.ofMillis(2000));
        wait.until(ExpectedConditions.visibilityOf(confirmationButton)).click();
    }

    @Test
    public void setOfData001() {
        WebElement salaryBase = driver.findElement(By.id("advanced_calculator_employment_salary_base"));
        salaryBase.sendKeys("5000");
        salaryBase.submit();
        WebElement yearSalary = driver.findElement(By.xpath("//*[@id=\"js-agreement-employment-contract\"]/div/div/div[2]/div/div[2]/div/table/tbody/tr[13]/td[8]/b[1]"));
        assertEquals("44 858.28", yearSalary.getText());
    }

    @Test
    public void setOfData002() {
        driver.findElement(By.id("advanced_calculator_employment_salary_base")).sendKeys("10000");
        driver.findElement(By.id("advanced_calculator_employment_salary_bonus")).sendKeys("500");
        driver.findElement(By.id("advanced_calculator_employment_submit")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("calculator_main_data")));
        WebElement yearSalary = driver.findElement(By.xpath("//*[@id=\"js-agreement-employment-contract\"]/div/div/div[2]/div/div[2]/div/table/tbody/tr[13]/td[8]/b[1]"));
        assertEquals("89 856.12", yearSalary.getText());
    }

    @AfterEach
    public void chromedriverQuit() {
        driver.quit();
    }
}
