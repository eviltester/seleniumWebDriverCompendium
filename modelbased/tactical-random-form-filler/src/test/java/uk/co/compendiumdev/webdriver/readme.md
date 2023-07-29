# Input Form Test

The `InputFormTest.java` is an example Tactial Automated Execution example.

Build to demonstrate what can be achieved in about an hour.

As a result:

- It has not been documented or refactored.
- You can see that it was built linearly, top to bottom.
- With 'methods' used as thinking abstractions to avoid large chunks of code.

## What Makes it Model Based?

- model of the form fields
- randomly select order of fields to fill
- randomly generate data to fill in the forms, from an Equivalence Class model i.e. all the data is 'valid'
- model of form submission `submitForm`
   - which randomly submits the form in different ways

The `aTest` models a single path through the application.

- visit form
- fill form (with valid details)
- submit form
- check input is valid


## Next Steps

This could be used as a basis from which to:

- build a page object
- build a form filler object
- create some random data generation classes
- create a `SelfFillingRandomObjectQueue` which the `CountryObjectRandomPicker` uses to implement.
- take a screenshot on error, named with the 'test number' that failed
- write the 'error report' to a file, as it is created to allow investigation during the model based execution itself.

These are suggested exercises for the interested reader.

## Supporting Videos

This is a cut down example illustrating the principles of automating prior to a system being stable, discussed in this talk:

- [Web scraping as a Test Design Approach using Selenium](https://www.eviltester.com/conference/seleniummeetup2011_conference/)

This will be used as an example in my [Breakpoint 2020](https://www.browserstack.com/events/breakpoint) talk