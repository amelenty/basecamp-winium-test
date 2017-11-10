package tests

import objects.Keys
import ru.yandex.qatools.allure.annotations.Features
import ru.yandex.qatools.allure.annotations.Stories
import spock.lang.Unroll

class CalculatorSpec extends BaseSpec {

    @Stories("Add values")
    @Features("Calculator functions")
    def "Test Calculator"() {
        given:
        c_calc.clear()

        when:
        c_calc.click("1")
        c_calc.click(Keys.EIGHT)
        c_calc.click_4()
        c_calc.click_divide()
        c_calc.click_4()
        c_calc.click_equal()

        then:
        c_calc.getResult() == "46"
    }

    @Stories("Data driven test for all allowed operations")
    @Features("Calculator functions")
    @Unroll
    def "Calculator test [#expression = #expected]"() {
        setup:
        calc.clear()

        expect:
        calc.calculate(expression) == expected

        where:
        expression          | expected
        "20000000000002+3"  | "20000000000005"
        "1+1"               | "2"
        "-1-1"              | "-2"
        "0-1"               | "-1"
        "1-0"               | "1"
        "1/1"               | "1"
        "1*1"               | "1"
        "1.01+1.02"         | "2.03"
        "12563272*21312.32" | "267752473111.04"
        "2+3"               | "5"
        "2-3"               | "-1"
        "2*3"               | "6"
        "6/2"               | "3"
        "2/3"               | "0.666666666667"
        "0.5+1"             | "1.5"
        "0.5+0.5"           | "1"
        "0.5+0.6"           | "1.1"
        "4--3"              | "1"
        "4-+*/+3"           | "7"
        "4+3+5"             | "12"
    }
}
