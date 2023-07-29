package abstractions.pageobjects.AnySimpleExamplesOfPageObjectsAndAbstractions.logical.calculator;

import abstractions.pageobjects.AnySimpleExamplesOfPageObjectsAndAbstractions.pageobjects.calculator.CalculatorPage;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class Calculator {
    private WebDriver driver;

    HashMap<String,String> operatorToFunction;

    public Calculator(WebDriver driver) {
        this.driver = driver;
        driver.navigate().to("https://testpages.herokuapp.com/styled/calculator");

        operatorToFunction = new HashMap<String, String>();
        operatorToFunction.put("+", "plus");
        operatorToFunction.put("*", "times");
        operatorToFunction.put("-", "minus");
        operatorToFunction.put("/", "divide");

    }

    public long calculate(Calculation calculation) {
        CalculatorPage calculatorPage = new CalculatorPage(driver);

        calculatorPage.
                enterNumberOne(String.valueOf(calculation.getNumber1())).
                then().
                enterNumberTwo(String.valueOf(calculation.getNumber2())).
                then().
                selectFunction(operatorToFunction.get(calculation.getOperator())).
                and().
                calculate();

        return Long.parseLong(calculatorPage.getAnswer());
    }
}
