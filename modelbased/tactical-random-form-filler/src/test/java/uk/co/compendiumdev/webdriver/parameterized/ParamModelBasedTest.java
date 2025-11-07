package uk.co.compendiumdev.webdriver.parameterized;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;
import java.util.stream.Stream;

// taken from the webdriver compendium project
public class ParamModelBasedTest {

    static WebDriver driver;
    static Random random = new Random();

    static Map<String, By> formFields;
    static CountryOptionRandomPicker countryPicker;
    String report="";
    String errorReport = "";

    @BeforeAll
    public static void startBrowser(){
        driver = new ChromeDriver();
        random = new Random();
        formFields = new HashMap<>();
        formFields.put("firstname", By.id("firstname"));
        formFields.put("lastname", By.id("surname"));
        formFields.put("age", By.id("age"));
        formFields.put("country", By.id("country"));
        formFields.put("notes", By.id("notes"));

        countryPicker = new CountryOptionRandomPicker(driver);
        countryPicker.getAllOptions();
    }

    @AfterAll
    public static void closeBrowser(){
        driver.close();
    }


    private static Stream<Arguments> provideFormListArguments() {

        // there are only about 165 countries in the list
        int numberOfTimesToRun=200;

        List<Arguments> inputs = new ArrayList<>();

        for(int x=0; x< numberOfTimesToRun; x++) {
            inputs.add(Arguments.of(getRandomFormInput()));
        }

        return inputs.stream();
    }


    @ParameterizedTest(name = "{index} – {0}")
    @MethodSource("provideFormListArguments")
    @DisplayName("Test with Object Parameter")
    void testTacticalModel(FormInputs input){


        report="";
        reportThis(String.format("firstname %s\n", input.firstname));
        reportThis(String.format("lastname %s\n", input.lastname));
        reportThis(String.format("age %s\n", input.age));
        reportThis(String.format("country %s\n", input.country));
        reportThis(String.format("notes %s\n", input.notes));

        try {
            visitForm();
            fillFormCorrectly(input);
            submitForm();
            checkValidInput();
        }catch(Exception e){
            errorReport = errorReport + report;
        }


        System.out.println("\n\n\nTest Error Report");
        System.out.println("==================");
        System.out.println(errorReport);

        if(errorReport.length()>0){
            Assertions.fail();
        }
    }

    private void visitForm() {
        driver.get("https://testpages.eviltester.com/apps/client-server-form-validation/");
    }

    private void fillFormCorrectly(FormInputs inputs) {
        String[] theFields = {"firstname", "lastname", "age", "country", "notes"};

        List<String> fieldNames = new ArrayList<>();
        fieldNames.addAll(Arrays.asList(theFields));

        while(fieldNames.size()>0){
            String nextFieldToFill = fieldNames.get(
                    random.nextInt(fieldNames.size()));
            fillFieldWithFormInputValue(nextFieldToFill, inputs);
            fieldNames.remove(nextFieldToFill);
        }
    }

    private void fillFieldWithFormInputValue(String nextFieldToFill, FormInputs inputs) {
        switch (nextFieldToFill){
            case "firstname":
                driver.findElement(formFields.get(nextFieldToFill)).sendKeys(inputs.firstname);
                break;
            case "lastname":
                driver.findElement(formFields.get(nextFieldToFill)).sendKeys(inputs.lastname);
                break;
            case "age":
                reportThis(String.format("Using for age:%n%s%n", inputs.age));
                driver.findElement(formFields.get(nextFieldToFill)).sendKeys(inputs.age);
                break;
            case "country":
                Select select = new Select(driver.findElement(formFields.get(nextFieldToFill)));
                select.selectByContainsVisibleText(inputs.country);
                reportThis(String.format("Using for Country:%n%s%n", select.getFirstSelectedOption().getText()));
                break;
            case "notes":
                driver.findElement(formFields.get(nextFieldToFill)).sendKeys(inputs.notes);
        }
    }


    static FormInputs getRandomFormInput() {

        FormInputs inputs = new FormInputs();

        inputs.firstname = getRandomLengthStringValue(5, 89, "firstname");
        inputs.lastname = getRandomLengthStringValue(11, 79, "lastname");
        inputs.age = Integer.toString(randomIntBetween(18,80));
        inputs.country = countryPicker.getNextRandomCountryName();
        inputs.notes = getRandomLengthStringValue(0, 25, "notes");

        return inputs;
    }

    static String getRandomLengthStringValue(final int minlen, final int maxlen, final String fieldName) {
        String validChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ ";
        String generatedValue = "";

        int charCount = randomIntBetween(minlen, maxlen);

        while(charCount>0){
            int charAt = random.nextInt(validChars.length());
            generatedValue = generatedValue + validChars.substring(charAt, charAt+1);
            charCount--;
        }
        return generatedValue;
    }

    private void reportThis(final String toReport) {
        report = report + "\n" + toReport;
        System.out.println(toReport);
    }

    private static int randomIntBetween(int min, int max){
        return random.nextInt((max-min)+1)+min;
    }

    private void checkValidInput() {

        new WebDriverWait(driver, Duration.ofSeconds(10)).
                until(ExpectedConditions.
                        presenceOfElementLocated(By.id("valid-input")));
    }

    private void submitForm() {
        if(random.nextBoolean()){
            reportThis("Submit Form");
            driver.findElement(By.name("userdata")).submit();
        }else{
            final WebElement button = driver.findElement(By.cssSelector("input[type=submit]"));
            if(random.nextBoolean()){
                reportThis("Submit Button");
                button.submit();
            }else{
                reportThis("Submit Button Click");
                button.click();
            }
        }
    }


    static class CountryOptionRandomPicker {
        private final WebDriver mydriver;
        List<Integer> unselectedOptions;
        List<String> options;

        public CountryOptionRandomPicker(final WebDriver driver) {
            mydriver = driver;
            unselectedOptions= new ArrayList<>();
            options = new ArrayList<>();
        }

        public void getAllOptions() {

            driver.get("https://testpages.eviltester.com/apps/client-server-form-validation/");

            List<WebElement> optionElems = mydriver.findElement(
                            formFields.get("country")).
                    findElements(By.tagName("option"));

            for(WebElement elem : optionElems) {
                options.add(elem.getText());
            }

            unselectedOptions= new ArrayList<>();
            for(int x = 0; x<options.size(); x++){
                unselectedOptions.add(x);
            }
        }

        public String getNextRandomCountryName() {
            if(unselectedOptions.size()==0){
                // this also refreshes the array if it is empty
                int numberOfOptions = options.size();
                for(int x = 0; x<numberOfOptions; x++){
                    unselectedOptions.add(x);
                }
            }
            int indexToReturn = random.nextInt(unselectedOptions.size());;
            String valueToReturn = options.get(unselectedOptions.get(indexToReturn));
            unselectedOptions.remove(indexToReturn);
            return valueToReturn;
        }
    }
}
