import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Locators {
    private WebDriver driver;
    @BeforeTest
    public void doBeforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("d:/work2/TechMe/IdeaProjects/Herokuapp/src/main/resources/SomePage.html");
    }
    @Test
   public void findByLocators(){

        WebElement field = driver.findElement(By.xpath("//input[@data-qa = 'qa_input_field']"));
        field.sendKeys("Hello");
        WebElement checkbox = driver.findElement(By.xpath("//input[@data-qa = 'qa_checkbox']"));
        checkbox.click();
        WebElement dropdown = driver.findElement(By.xpath("//*[@data-qa = 'qa_dropdown']"));
        Select select = new Select(dropdown);
        select.selectByIndex(1);
        WebElement button = driver.findElement(By.xpath("//button[@data-qa = 'qa_button']"));
        button.click();
        WebElement text = driver.findElement(By.xpath("//*[@data-qa = 'qa_text']"));
        assertEquals(text.getText(), "Some text here","Текст не соответствует ожидаемому" );
        WebElement link = driver.findElement(By.xpath("//a[text() = 'Visit tut.by']"));
        link.click();
    }
}
