# Start Using Legacy Firefox WebDriver

The 'start using selenium webdriver' code that covers legacy firefox approaches.

This should really be 'stop' using legacy firefox webdriver since you really want to be as up to date with WebDriver as you can.

But I'll use this repo for code that shows how to use the older versions if required.

I'm pulling the code out of my Start using Selenium Web Driver project because that project is designed for beginners and cluttering it with legacy information seems more likely to confuse, than to help.


You can find instructions for installing Java nd IntelliJ in a separate repo

* Added the Mac Instructions, and moved Java install to the [Java checklist and project](https://github.com/eviltester/startUsingJavaJUnit/blob/master/speedrun_install_java_checklist.md)



## Notes for Selenium WebDriver Above 3.0.1

Versions of Selenium WebDriver 3.1.0 and above have removed the `MarionetteDriver` class, and `FirefoxDriver` should now be used for all versions of Firefox.

The `MyFirstTestFF48` has been commented out in the code.

If you are using version 3.0.1 or below then you can uncomment out the main class code and the imports and you can use this test.

## Notes for Selenium WebDriver 3.0.1

### Running with Firefox

If you are using Firefox 45 Extended Release version (or Firefox < v48) then to run the test from the command line use:

`mvn test -Dtest=MyFirstLegacyFFTest`

If you are using Firefox 48+ and have added Marionette `geckodriver.exe` to the path then use the command line:

`mvn test -Dtest=MyFirstTest`

The following will also work with Firefox 48+, but will fail in a future version of WebDriver because the `MarionetteDriver` is deprecated.

`mvn test -Dtest=MyFirstTestFF48`



## Update 7th July 2016

Firefox 47 was incompatible with Selenium 2.53.0 so we needed to use marionette driver.

Firefox 47.1 is compatible with Selenium 2.53.1 allowing us to use the `FirefoxDriver` again.

The blog post below describes how to use a local version of Selenium with maven if any incompatibility happens again and you need to move to a different version of WebDriver which is not on maven central.

* http://seleniumsimplified.com/2016/06/use_selenium_webdriver_jar_locally/

## Update 22nd June 2016

Added information about using portable firefox driver and more comments.

## Update 25th April 2016

Firefox 46 changes the way that WebDriver has to interact with it. So the built in `FirefoxDriver` did not work. You need to install Firefox 45 from [Firefox Extended Support Release](https://www.mozilla.org/en-US/firefox/organizations/all/) to continue using `FirefoxDriver`.

If you want to use Firefox 46 and later then you may need to use the [Marionette](https://developer.mozilla.org/en-US/docs/Mozilla/QA/Marionette/WebDriver) driver.

Follow the instructions on the Marionette page to download it. You do not need to add it to your path, you can control that through a system property - see the code in this project for more detail.

You can also use portable Firefox as described in this blog post

* http://seleniumsimplified.com/2016/06/using-portable-firefox-46-with-webdriver/

All of this is explained in the source code, or in the blog posts:

* http://seleniumsimplified.com/2016/04/how-to-use-the-firefox-marionette-driver/
* http://seleniumsimplified.com/2016/06/using-portable-firefox-46-with-webdriver/


## Pre April 2016 updates

The code has changed slightly because we now need to do a .close and a .quit to exit Firefox

And I've updated the version of WebDriver.