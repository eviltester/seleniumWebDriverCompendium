This article appeared in Professional Tester Issue 16.

And is on my website: https://eviltester.com/2012/08/abstraction-in-action.html

> Good development requires good programming. Testing validates development. Therefore automated test design requires better programming
 
## Adopt different views of Test Automation.

It's useful to adopt different views of
test automation. For example viewing it as
a programming activity has forced me to
improve my knowledge of coding styles,
patterns and libraries. Viewing it as a way
to increase coverage of data, requirements
and other realities has led me to learn test
driven development which in turn has
helped me learn to write better test code.

But I view test automation primarily as a
modelling process. This view has allowed
me to learn to architect better test frameworks and expand use of test automation
by using the same framework for multiple
test objectives and types. Here are some
examples showing how, using Java,
JUnit, WebDriver and the simple calculator
application at https://testpages.herokuapp.com/styled/calculator

## The modelling perspective

Consider the simple test script shown below. It models the behaviour of a user.
Its goal is described by the test method
name “canAddTwoNumbers”.
 
~~~~~~~~
@Test
public void canAddTwoNumbers(){

 WebDriver driver = new FirefoxDriver();

 driver.navigate().to(
    "https://testpages.herokuapp.com/styled/calculator");
 driver.findElement(By.id("number1")).sendKeys("2");
 driver.findElement(By.id("function")).sendKeys("plus");
 driver.findElement(By.id("number2")).sendKeys("3");
 driver.findElement(By.id("calculate")).click();

//... code removed
}
~~~~~~~~
 
Every test script is a model. Models are
formed using abstractions. This script
builds the model in Java code using the
abstraction layer WebDriver. The abstraction layer hides the implementation details
involved in pressing and releasing keys
and mouse buttons,

## Modelling the physical world with page objects

The page object model (POM) is a physical
model in which the abstractions exist at the
page level rather than the browser/DOM
level as provided by WebDriver. The code below
shows an initial page object for
the calculator.
 
~~~~~~~~
public class CalculatorPage {

 private WebDriver driver;

 public CalculatorPage(WebDriver driver){ /*.. */}
 public void enterNumberOne(String numberOne){ /*.. */}
 public void enterNumberTwo(String numberTwo){ /*.. */}
 public void selectFunction(String functionName){ /*.. */}
 public void calculate(){ /*.. */}
 public String getAnswer(){ /*.. */} 

}
~~~~~~~~
 
Using the POM allows me to model at
a higher level, working with a functional
model of the page as the main object.
The script still models the physical world,
but has moved closer to modelling user
interactions with functionality rather than
layout. As shown below:
 
~~~~~~~~
@Test
 public void canAddTwoNumbers(){
     WebDriver driver = new FirefoxDriver();

     driver.navigate().to(
        "https://testpages.herokuapp.com/styled/calculator");

     CalculatorPage calculatorPage = new CalculatorPage(driver);

     calculatorPage.enterNumberOne("3");
     calculatorPage.selectFunction("plus");
     calculatorPage.enterNumberTwo("4");
     calculatorPage.calculate();

     assertEquals(calculatorPage.getAnswer(), "7");

     driver.close();
 }
~~~~~~~~
 
## Making coding decisions

All I have done so far is refactor to
methods using an existing coding pattern.
If you are not familiar with this concept,
I recommend Martin Fowler's book
_Refactoring: Improving the Design of
Existing Code_ (ISBN 9780201485677).

The test automation specialists with whom
I work on projects are usually very good at
coding, refactoring and using patterns. But
to what to refactor and what patterns to
use are modelling decisions, and these
are hard. For example, I made here a
modelling decision not to move the
“driver.navigate().to(...)” code into
the page object.

Why?

I could have, easily. The page object
pattern is pretty non-specific. Navigation
seems like a page detail, ie where the
page is located. It would have made the
test script code neater since I could have
modelled the navigation in my test as
“calculatorPage.visit()”.

But I didn't. I made a modelling decision
not to. I decided that the page should not
know where it is located because no page
should know how to navigate to itself.
These are modelling decisions, and
subjective.

Instead I decided to model the concept
of navigation separately from the page
functionality. I decided that I did not (yet)
need to build an abstraction on top of the
existing WebDriver abstraction to perform
navigation. The more tests I build using the
abstraction layers, the more I will be forced
to revisit my modelling decisions.

## Making modelling decisions and introducing a logical model

There are a lot of nuances in modelling:
I particularly like Michael Jackson's
exploration of the topic in his books
_Software Requirements and Specifications_
(ISBN 9780201877120) and _Problem
Frames and Methods_ (ISBN
9780201596274). However I use a very
basic set of model partitions: logical and
physical. I see a lot of test automation that
involves physical models and abstractions
of the physical domain but far less around
the logical domain.

I could continue to focus my model refinement at the test script level. For example I
might decide that I want to model my test
script as shown below. Supporting this
does not require much of a programming
change: simply have the methods return
the CalculatorPage object to support
method chaining, and introduce two
methods for syntactic sugar (then & and).
This might make the test script much
more readable.

~~~~~~~~
calculatorPage.
 enterNumberOne("3").
 then().
 enterNumberTwo("4").
 then().
 selectFunction("plus").
 and().
 calculate();
~~~~~~~~

I could also make the calculate() method
return the answer value: after all calculate()
typically returns a value. That would make
the test look as shown below.

~~~~~~~~
String answer = calculatorPage.
               enterNumberOne("3").then().
               enterNumberTwo("4").then().
               selectFunction("plus").and().
               calculate(); 
~~~~~~~~

Whether or not to do this is a modelling
decision, ie it is based on how we want our
tests to look and under what circumstances
we want to reuse the abstractions. Is it a
good idea? I think not, and that I thought
of it because I didn't model the page object
correctly in the first place. I named the
calculate() method incorrectly: it does not
calculate, it clicks the “Calculate” button.
I mixed a 'logical' model concept (calculate)
into a 'physical' model (click button). If I had
named the method clickCalculateButton()
then I wouldn't have started thinking about
changing the test.

When modelling we have to be very clear
about what our abstractions are for, what
their purpose is, and what the limits of their
responsibility are. When we let our abstractions leak, we can make it harder to decide
where we should refactor code to, and
increase maintenance overhead.

However, returning a value from the
abstraction layer in the test does seem like
a good idea. So how might I model that?

## Introducing a logical model
 
The logical domain can be modelled in
terms of a “calculator” and a “calculation”,
as in the model as shown below. With
this approach I'm no longer modelling the
low-level functional details: I'm starting to
model the high-level functionality.

~~~~~~~~
@Test
public void canAddTwoNumbers(){
     Calculator calculator = new Calculator(driver);

     Calculation addTwoNumbers = new Calculation(2,"+",2);

     long result = calculator.calculate(addTwoNumbers);

     assertEquals(result,4L);
}
~~~~~~~~

To make the test code cleaner I have
instantiated the physical abstractions for
the driver in the @BeforeClass and tidy
up in the @AfterClass. This keeps the
test as clean as I can get it, without
further refactoring.

Note that the test has changed in that the
data is now represented using domain
concepts. The numbers and answer are
no longer strings but Java numeric
primitives. The function is now a string
with a mathematical operator because
this is more in keeping with the domain
with which this level of abstraction deals.

The transformation from "+" to "plus" is
done by the calculator's calculate method
because this method is helping me bridge
the gap between the logical and physical
models. The implementation that sits
behind this reuses the physical
abstractions already built.

Anand Ramdeo explained many of the
practicalities associated with refactoring
to abstraction layers at the Selenium
Conference earlier this year. His presentation can be seen at

http://www.youtube.com/watch?v=dFPgzH_XP1I.

## Modelling and test design

Modelling in the logical domain tends to
lead to tests whose expected outcome
involves the SUT performing its purpose
(sometimes called “positive tests”). In this
example, using the logical abstractions
helps with thinking about and choosing
valid input values to test the accuracy of
the calculator. Using the physical
abstractions does the same for “negative
tests”, in this case those whose expected
outcome is that no calculation occurs
because the input is invalid: eg “2”
“plus” “five”.

Using more abstraction layers makes it
easier to reuse test code for exploratory
testing, especially when they are “clean”,
that is they do not bleed responsibilities into
one another. I tend to use logical layers to
explore behavior under “normal use”, for
example to randomize input combinations
or for ad hoc performance testing, and
drop down to physical layers to explore
exploitation and exception scenarios.

Development and testing require very
different mindsets. The best developers
and the best testers are those allowed to
remain within one or the other of them for
long periods: that is, specialists. Yet a tester
creating automated tests is required to
switch between them frequently because
any executable automated test requires
setup code. Abstraction helps by creating
a clear distinction between writing code
intended to function as intended without
incident and code that has potential
to detect defects.

## Modelling and defects

Business domain tests (sometimes called
“system and acceptance tests”) use the
logical abstraction layers and these in turn
use the physical abstraction layers.

Therefore if the physical domain tests all
pass but a correct business domain test
fails the defect is in the business domain,
ie the requirements: in our example, the
calculation algorithm is wrong. If a correct
physical domain test fails the interface on
which it depends has changed in an unexpected way. In our example, perhaps a
developer changed the transmitted HTML
to include:

~~~~~~~~
<option value="plus" >plus</option>
~~~~~~~~

 instead of
 
~~~~~~~~
<option value="plus">Plus</option>.
~~~~~~~~

If the physical abstraction layers are correct,
correct logical domain tests should not fail.
Learning to model domains makes the
tester able to make many useful assertions
like these.

I recommend Domain-driven
_Design: Tackling Complexity in the Heart
of Software_ by Eric Evans (ISBN
9780321125217).

## Quality of test code

Abstraction and the simplicity it enables are
valuable to developers. They are enormously more valuable to testers and the
acquirers and users we serve. I learned
their value and how to achieve them
especially from _Implementation Patterns_
by Kent Beck (ISBN 9780321413093) and
_Growing Object-Oriented Software, Guided
by Tests_ by Steve Freeman and Nat Pryce
(ISBN 9780321503626).

Code intended for production should be
transparently readable. So should test
code, for exactly the same reasons. From
a development perspective, quality of
production code is more important than
quality of test code. Objectively the
opposite is true.

This sets a challenge for testers. Our code
must be as good as production code. We
must aim to become better programmers
than the developers whose code we test.
This does not mean a change of mindset
on either side. Developers must code well
with a development mindset while testers
code better with a testing mindset.
Abstraction makes that achievable. But
if you are good at modelling (which most
testers are instinctively) but not at programming, you limit the ways your test
framework can grow.

As a tester striving to become a better
programmer in order to test better I have
learned a lot of lessons and many of those
which have helped me most are listed by
Naresh Jain at http://blogs.agilefaqs.com/
2012/06/07/oo-design-principles retrieved
1st July 2012 0001 UTC. Testers should
consider especially “don't repeat yourself”,
“tell don't ask” and the “dependency
inversion principle”.

The purpose of abstracting is not to be
vague, but to create a a new semantic level
in which one can be absolutely precise
(Edsger W. Dijkstra in his Association for
Computing Machinery Turing Lecture 1972:
see http://cs.utexas.edu/~EWD/ewd03xx/EWD340.PDF
retrieved 1st July 2012 0002
UTC). The test programmer views test tools
as abstraction layers to support the modelling done to design tests and understands
exactly what each does. For example
WebDriver abstracts the physical interaction with the browser and the DOM;
FitNesse and Cucumber abstract the
mechanism of parsing a DSL making
data-driven testing easier. This approach
avoids dependence upon specific tools so
that the abstraction layers can be changed
as understanding of the SUT and how to
test it increases.

---


If you find this useful then you might also like my Oredev talk from 2014

https://www.youtube.com/watch?v=YExv0Dlm0bc

---

Since this article was written, I have now created a full course on abstraction layers:

- https://www.eviltester.com/page/onlinetraining/linkedin-page-objects/
