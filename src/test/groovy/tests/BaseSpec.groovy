package tests


import io.github.bonigarcia.wdm.ChromeDriverManager
import objects.CalculatorPage
import objects.ClassicCalculatorPage
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import spock.lang.Shared
import spock.lang.Specification

class BaseSpec extends Specification {

    @Shared
    WebDriver driver
    @Shared
    ClassicCalculatorPage c_calc
    @Shared
    CalculatorPage calc

    def setupSpec() {
        ChromeDriverManager.getInstance().setup()
        driver = new ChromeDriver()
        calc = new CalculatorPage(driver)
        c_calc = new ClassicCalculatorPage(driver)
    }

    def cleanupSpec() {
        driver.quit();
    }

}