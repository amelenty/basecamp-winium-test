package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.allure.annotations.Step;


public class CalculatorPage {

    private WebDriver driver;

    private By equal = By.name("=");
    private By clean = By.name("Clear");

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step
    public String calculate(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
                case 'B':
                    driver.findElement(By.name("Backspace")).click();
                    break;
                case 'C':
                    driver.findElement(By.name("Clear")).click();
                    break;
                default:
                    driver.findElement(By.name(""+ expression.charAt(i)+"")).click();
            }
        }
        driver.findElement(equal).click();
        return driver.findElement(By.id("1000")).getText();
    }

    @Step
    public void clear() {
        driver.findElement(clean).click();
    }
}
