package abstractions.pageobjects.AnySimpleExamplesOfPageObjectsAndAbstractions.pageobjects.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage {

    private WebDriver driver;

    public CalculatorPage(WebDriver driver){
        this.driver = driver;
    }

    public CalculatorPage enterNumberOne(String numberOne){
        driver.findElement(By.id("number1")).sendKeys(numberOne);
        return this;
    }

    public CalculatorPage enterNumberTwo(String numberTwo){
        driver.findElement(By.id("number2")).sendKeys(numberTwo);
        return this;
    }

    public CalculatorPage selectFunction(String functionName){
        driver.findElement(By.id("function")).sendKeys(functionName);
        return this;
    }

    public CalculatorPage calculate(){
        driver.findElement(By.id("calculate")).click();
        return this;
    }

    public String getAnswer(){
        ExpectedCondition foundAnswer = new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("answer"));
            }
        };

        WebElement answer = (WebElement)new WebDriverWait(driver,5).until(foundAnswer);

        return answer.getText();
    }

    /* Synatactic sugar for literate programming */
    public CalculatorPage then(){return this;}
    public CalculatorPage and(){return this;}

}
