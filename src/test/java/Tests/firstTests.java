package Tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class firstTests {
    public WebDriver getDriver(){
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://wynagrodzenia.pl/kalkulator-wynagrodzen");
        return driver;
    }
    @Test
    public void findElementById(){
        WebDriver driver = getDriver();
        WebElement button = driver.findElement(By.xpath("//*[@id=\"sky-form4\"]/div[2]/div[2]/button"));
        driver.quit();
    }
}
