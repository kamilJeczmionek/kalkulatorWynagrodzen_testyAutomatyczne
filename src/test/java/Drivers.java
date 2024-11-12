import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Drivers {
    @Test
    public void chromeDriverOnPath() {
        WebDriver driver = new ChromeDriver();
        driver.quit();
    }
}
