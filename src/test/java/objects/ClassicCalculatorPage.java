package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;

public class ClassicCalculatorPage {

    private By button_0 = By.xpath("//input[@value='0']");
    private By button_1 = By.xpath("//input[@value='1']");
    private By button_2 = By.xpath("//input[@value='2']");
    private By button_3 = By.xpath("//input[@value='3']");
    private By button_4 = By.xpath("//input[@value='4']");
    private By button_5 = By.xpath("//input[@value='5']");
    private By button_6 = By.xpath("//input[@value='6']");
    private By button_7 = By.xpath("//input[@value='7']");
    private By button_8 = By.xpath("//input[@value='8']");
    private By button_9 = By.xpath("//input[@value='9']");
    private By button_plus = By.xpath("//input[@value='+']");
    private By button_minus = By.xpath("//input[@value='-']");
    private By button_divide = By.xpath("//input[@value='/']");
    private By button_multiply = By.xpath("//input[@value='x']");
    private By button_clear = By.xpath("//input[@value='C']");
    private By button_dot = By.xpath("//input[@value='.']");
    private By button_equal = By.xpath("//input[@value='=']");
    private By result_box = By.cssSelector("#resultsbox");

    private WebDriver driver;

    public ClassicCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }


    public void click(String button) {
        driver.findElement(By.xpath("//input[@value='" + button + "']")).click();
    }

    public void click(Keys key) {
        click(key.toString());
    }

    public void click_0() {
        driver.findElement(button_0).click();
    }

    public void click_1() {
        driver.findElement(button_1).click();
    }

    public void click_2() {
        driver.findElement(button_2).click();
    }

    public void click_3() {
        driver.findElement(button_3).click();
    }

    public void click_4() {
        driver.findElement(button_4).click();
    }

    public void click_5() {
        driver.findElement(button_5).click();
    }

    public void click_6() {
        driver.findElement(button_6).click();
    }

    public void click_7() {
        driver.findElement(button_7).click();
    }

    public void click_8() {
        driver.findElement(button_8).click();
    }

    public void click_9() {
        driver.findElement(button_9).click();
    }

    public void click_plus() {
        driver.findElement(button_plus).click();
    }

    public void click_minus() {
        driver.findElement(button_minus).click();
    }

    public void click_divide() {
        driver.findElement(button_divide).click();
    }

    public void click_multiply() {
        driver.findElement(button_multiply).click();
    }

    public void click_dot() {
        driver.findElement(button_dot).click();
    }

    public void click_equal() {
        driver.findElement(button_equal).click();
    }


    public void clear() {
        driver.findElement(button_clear).click();
    }


    public String getResult() {
        return driver.findElement(result_box).getAttribute("value");
    }


    public void open() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("calc.html").getFile());
        driver.get("file:///" + file.getAbsolutePath());
    }

}