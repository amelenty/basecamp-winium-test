package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;

import java.io.File;


public class CalculatorPage {

    WebDriver driver;

    String button = "//input[@value='%s']";

    By resultBox = By.cssSelector("#resultsbox");
    By equal = By.xpath("//input[@value='=']");
    By clean = By.xpath("//input[@value='C']");

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public String calculate(String expression) {

        for (int i = 0; i < expression.length(); i++) {
            driver.findElement(By.xpath(String.format(button, expression.charAt(i)))).click();
        }

        driver.findElement(equal).click();

        return driver.findElement(resultBox).getAttribute("value");
    }

    @Step
    public void open() {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("calc.html").getFile());
        driver.get("file:///" + file.getAbsolutePath());
    }

    @Step
    public void clear() {
        driver.findElement(clean).click();
    }
}
