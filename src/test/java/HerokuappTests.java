import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.json.JsonOutput;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class HerokuappTests {
    private WebDriver driver;

    @BeforeTest
    public void doBeforeTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterTest
    public void doAfterTest() {
        driver.quit();
    }

    @Test
    public void addRemoveElements() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element = driver.findElement(By.xpath("//button[text()='Add Element']"));
        element.click();
        element.click();
        WebElement element_delete = driver.findElement(By.xpath("//button[text()='Delete']"));
        element_delete.click();

        //коллекция с элементами "delete"
        List<WebElement> listOfElements = driver.findElements(By.xpath("//button[text()='Delete']"));
        //проверить количество
        assertEquals(listOfElements.size(), 1, "Количество элементов равно 1");

    }

    @Test
    public void CheckCheckboxes() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        WebElement element = driver.findElement(By.xpath("//*[@type='checkbox']"));
        if (!element.isSelected()) {
            System.out.println("Checkbox is Togged Off");
        }
        element.click();
        if (element.isSelected()) {
            System.out.println("Checkbox is Togged On");
        }
        //не работает
        WebElement element2 = driver.findElement(By.xpath("//input[@checked='true']"));
        element2.click();
        if (!element2.isSelected()) {
            System.out.println("Checkbox is Togged Off");
        }
    }

    @Test
    public void CheckDropdown() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement dropdownElement = driver.findElement(By.id("dropdown"));

        Select select1 = new Select(dropdownElement);
//        List<WebElement> listOfElements = driver.findElement(By.id("dropdown")).findElements(By.xpath("//option[text()='Option*']"));
//        List options = select.getOptions();
//        List selectedOptions = select.getAllSelectedOptions();
//        System.out.println(listOfElements);

        select1.selectByValue("1");
        if (dropdownElement.isSelected()) {
            System.out.println("Option 1 выбрана");
        }
        assertEquals(dropdownElement.isSelected(), dropdownElement.isSelected(), "Выбран первый элемент ");

        Select select2 = new Select(dropdownElement);
        select2.selectByValue("2");
        dropdownElement.isSelected();
        assertEquals(dropdownElement.isSelected(), dropdownElement.isSelected(), "Выбран второй элемент ");
        if (dropdownElement.isSelected()) {
            System.out.println("Option 2 выбрана");
        } else {
            System.out.println("Не выбрана");
        }
    }
}



