package uk.co.compendiumdev.examples.coverage;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CoverageTest {

//     TODO:
//            QUESTION:
//                       - Should test code have code coverage applied to it?
//                       - Should abstraction layers have code coverage applied to it?
//            EXERCISE:
//                       - Run this test with code coverage and make sure it has 100%
//                         class, method and line coverage.
//                       - Then run all the tests with code coverage (ensuring that the
//                         test code is also measured, and expand the tests to use the
//                         uncovered methods (or delete the unused code).)
//                       - Fix any bugs in the abstraction layers that you find when you
//                         use any of the 'new' abstraction layer code.

    @Test
    public void thisTestUsesTestClasses(){
        // classes in the test folder are not normally covered by default
        // code coverage rules.
        // In IntelliJ Run Configurations, you can edit them in the coverage
        // tab to include the test code
        // https://www.jetbrains.com/help/idea/configuring-code-coverage-measurement.html

        Assert.assertTrue(MyInnerClass.getTrue());
        Assert.assertTrue(MyOuterClass.getTrue());
        Assert.assertTrue(MyMainClass.getTrue());
    }

    private static class MyInnerClass {
        public static boolean getTrue() {
            return true;
        }
    }

    /*
        Code coverage can help us identify risks in our abstraction libraries.

        If we run our tests with code coverage on, and see that there are
        unused parts of our abstraction layers. Then we don't know if they still
        execute. So the next time someone tries to use the abstraction layer, it
        might fail. And they have to spend time debugging the abstraction layer
        but they might also not know it is the abstraction layer since that is a
        trusted part of our code. So they waste time 'blaming' their @Test method
        or the area of functionality that they are trying to automate.

        Periodically running the automated execution with code coverage to check how
        well the abstraction layers are covered can help mitigate this risk.

        It might reveal:

        - unused parts of the abstraction layers because they are old
          and not longer required.
        - unused parts of abstraction layer that have never been used and
          are risky.
        - parts of the application that are not exercised because the
          abstraction layers are not used.
     */
}
