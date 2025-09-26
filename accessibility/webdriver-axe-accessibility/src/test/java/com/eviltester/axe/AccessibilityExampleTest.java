package com.eviltester.axe;

import com.deque.html.axecore.results.Results;
import com.deque.html.axecore.results.Rule;
import com.deque.html.axecore.selenium.AxeBuilder;
import com.deque.html.axecore.selenium.AxeReporter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AccessibilityExampleTest {

    /*
     based on https://playwright.dev/java/docs/accessibility-testing

     I thought it was interesting that the Playwright documentation
     as its first example shows accessibility testing using axe from deque.

     https://www.deque.com/axe/

     But this is not a playwright feature, this is a feature of the axe-core library.
     And the axe-core library supports Playwright, Selenium, webdriverio, webdriverjs, puppeteer

    - https://github.com/dequelabs/axe-core

     add axe Selenium Integration maven dependency from axe core

     - https://mvnrepository.com/artifact/com.deque.html.axe-core
     - https://mvnrepository.com/artifact/com.deque.html.axe-core/selenium/4.10.2

     check the axe docs

     - https://github.com/dequelabs/axe-core-maven-html/blob/develop/selenium/README.md


     For human use you could try:

     - AxeGrinder https://github.com/claflamme/axegrinder
        - node based tool that crawls website and builds reports
     - Webatool https://github.com/balajihambeere/webatool
     - lighthouse https://developer.chrome.com/docs/lighthouse/overview


     see also:

     https://github.com/dequelabs/axe-core/blob/develop/doc/projects.md


     */

    WebDriver driver;

    @BeforeEach
    void initiateDriver() {
        driver = new ChromeDriver();
    }

    @Test
    void auditPageAndExpectIssues() {

        driver.get("https://testpages.eviltester.com/styled/basic-web-page-test.html");

        Results accessibilityScanResults = new AxeBuilder().analyze(driver);

        List<Rule> violations = accessibilityScanResults.getViolations();

        AxeReporter.getReadableAxeResults("Default", driver, violations);
        System.out.println(AxeReporter.getAxeResultString());

        assertFalse(
            accessibilityScanResults.violationFree(),
            "You should have accessibility issues on the page"
        );
    }

    @Test
    void limitAuditScopeToSectionOfPageAndExpectNoIssues() {

        driver.get("https://testpages.eviltester.com/styled/basic-web-page-test.html");

        AxeBuilder filteredAxeScope = new AxeBuilder().include(".page-body");

        Results accessibilityScanResults = filteredAxeScope.analyze(driver);

        List<Rule> violations = accessibilityScanResults.getViolations();

        AxeReporter.getReadableAxeResults("Default", driver, violations);
        System.out.println(AxeReporter.getAxeResultString());

        assertTrue(
            accessibilityScanResults.violationFree(),
            "You have unexpected accessibility issues due to the page content"
        );
    }

    @Test
    void limitWcagScopeToOfPageAndExpectOneIssues() {

        /*
            The WCAG standard lists a lot of rules.

            https://www.w3.org/TR/WCAG21/#wcag-2-layers-of-guidance

            It is possible to only use certain
            sections via tags.

            List of supported tags is here:

            https://www.deque.com/axe/core-documentation/api-documentation/#axecore-tags
         */
        driver.get("https://testpages.eviltester.com/styled/basic-web-page-test.html");

        AxeBuilder filteredAxeScope = new AxeBuilder().withTags(List.of("wcag2a"));

        Results accessibilityScanResults = filteredAxeScope.analyze(driver);

        List<Rule> violations = accessibilityScanResults.getViolations();

        AxeReporter.getReadableAxeResults("Default", driver, violations);
        System.out.println(AxeReporter.getAxeResultString());

        assertEquals(1, violations.size(),
                "You have unexpected accessibility issues due to the page content"
        );
    }


    @AfterEach
    void closeDriver() {
        driver.quit();
    }
}
