package tests

import objects.CalculatorPage
import objects.ClassicCalculatorPage
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.support.ui.WebDriverWait
import spock.lang.Shared
import spock.lang.Specification

class BaseSpec extends Specification {

    @Shared
    WebDriver driver
    @Shared
    WebDriverWait wait
    @Shared
    ClassicCalculatorPage c_calc
    @Shared
    CalculatorPage calc

    def setupSpec() {
        DesiredCapabilities cap = new DesiredCapabilities()
        cap.setCapability("app", "C:\\Users\\ada.melentyeva\\Documents\\BaseCamp\\Automation\\TestWin\\Calculator.exe")
        driver = new RemoteWebDriver(new URL("http://localhost:9999"), cap)
        wait = new WebDriverWait(driver,30)
        calc = new CalculatorPage(driver)
        c_calc = new ClassicCalculatorPage(driver)
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("=")))
    }

    def cleanupSpec() {
        driver.quit()
    }
}