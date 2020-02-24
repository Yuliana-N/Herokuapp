import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class HerokuappTests {
    @Test
    public void addRemoveElements() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.xpath("//button[text()='Add Element']"));
        element.click();
        element.click();
        WebElement element_delete = driver.findElement(By.xpath("//button[text()='Delete']"));
        element_delete.click();

        //коллекция с элементами "delete"
        List<WebElement> listOfElements = driver.findElements (By.xpath ("//button[text()='Delete']"));
        //проверить количество
        assertEquals(listOfElements.size(), 1, "Количество элементов равно 1");

        driver.quit();
    }
}
