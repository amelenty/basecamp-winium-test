package tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;


public class CalculatorTest {

    private static WebDriver driver;

    @BeforeClass
    public static void start() {
        ChromeDriverManager.getInstance().setup();
        //ChromeOptions opt = new ChromeOptions().setHeadless(true);
        driver = new ChromeDriver();

    }

    @Before
    public void cleanup() {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("calc.html").getFile());
        driver.get("file:///" + file.getAbsolutePath());

        //driver.get("file:///D:/work/GlobalLogic/Trainings/BootCamp/code/calc.html");

        //driver.findElement(By.xpath("//input[@value='C']")).click();
    }


    @Test
    public void add_test() {

        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='+']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("7", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void subtract_test() {
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='-']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("-3", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void multiply_test() {
        driver.findElement(By.xpath("//input[@value='2']")).click();
        driver.findElement(By.xpath("//input[@value='x']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("10", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }

    @Test
    public void divide_test() {
        driver.findElement(By.xpath("//input[@value='1']")).click();
        driver.findElement(By.xpath("//input[@value='0']")).click();
        driver.findElement(By.xpath("//input[@value='/']")).click();
        driver.findElement(By.xpath("//input[@value='5']")).click();
        driver.findElement(By.xpath("//input[@value='=']")).click();
        Assert.assertEquals("2", driver.findElement(By.id("resultsbox")).getAttribute("value"));
    }


    @AfterClass
    public static void stop() {
        driver.quit();
    }


}
