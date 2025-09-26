package com.eviltester.axe;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.selenium.AxeReporter;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class GovBadPageTest {

    /*

    2017 blog post on the UK government site listing the results of using multiple tools for accessibility:

        https://accessibility.blog.gov.uk/2017/02/24/what-we-found-when-we-tested-tools-on-the-worlds-least-accessible-webpage/

    That post lists a test page they created to evaluate tools against,
    this could be a useful page for testing and learning accessibility.

    I don't know of any other sites designed for testing accessibility:

        https://alphagov.github.io/accessibility-tool-audit/test-cases.html

     */

    @Test
    void expectPageToHaveAccessibilityIssues(){

        WebDriver driver = new ChromeDriver();

        driver.get("https://alphagov.github.io/accessibility-tool-audit/test-cases.html");

        Results accessibilityScanResults = new AxeBuilder().analyze(driver);

        List<Rule> violations = accessibilityScanResults.getViolations();

        AxeReporter.getReadableAxeResults("Default", driver, violations);
        System.out.println(AxeReporter.getAxeResultString());

        assertFalse(
            accessibilityScanResults.violationFree(),
            "You should have accessibility issues on the page"
        );

        driver.quit();
    }

}
