package abstractions.dsl.HowToCreateFluentPageObjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HowToCreateFluentPageObjectsTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void exampleOfFluentPageObjectUsage(){
        driver.get("https://eviltester.github.io/simpletodolist/adminlogin.html");

        AdminLoginPage page = new AdminLoginPage(driver);
        page.
            enterUserName("Admin").
            enterPassword("AdminPass").
            doNotRememberMe().
            submitForm();

        Assertions.assertEquals(
                "Todo Admin View",
                driver.getTitle());
    }

    @AfterAll
    public static void endSelenium(){
        driver.quit();
    }

    private class AdminLoginPage {
        private final WebDriver driver;

        public AdminLoginPage(final WebDriver driver) {
            this.driver = driver;
        }

        public AdminLoginPage enterUserName(String username){
            final WebElement elem = driver.findElement(By.name("username"));
            elem.clear();
            elem.sendKeys(username);
            return this;
        }

        public AdminLoginPage enterPassword(String password){
            final WebElement elem = driver.findElement(By.name("password"));
            elem.clear();
            elem.sendKeys(password);
            return this;
        }

        public AdminLoginPage rememberMe(){
            final WebElement elem = driver.findElement(By.name("remember"));
            if(!elem.isSelected())
                elem.click();
            return this;
        }

        public AdminLoginPage doNotRememberMe(){
            final WebElement elem = driver.findElement(By.name("remember"));
            if(elem.isSelected())
                elem.click();
            return this;
        }

        public void submitForm(){
            driver.findElement(By.id("login")).click();
        }

    }
}
