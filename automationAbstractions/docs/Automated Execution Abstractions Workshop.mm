<map version="freeplane 1.6.0">
<!--To view this file, download free mind mapping software Freeplane from http://freeplane.sourceforge.net -->
<node TEXT="Automated&#xa;Execution&#xa;Abstractions&#xa;Workshop" FOLDED="false" ID="ID_674451198" CREATED="1565700044304" MODIFIED="1567771775387" STYLE="oval">
<font SIZE="18"/>
<hook NAME="MapStyle">
    <properties fit_to_viewport="false" show_note_icons="true" edgeColorConfiguration="#808080ff,#ff0000ff,#0000ffff,#00ff00ff,#ff00ffff,#00ffffff,#7c0000ff,#00007cff,#007c00ff,#7c007cff,#007c7cff,#7c7c00ff"/>

<map_styles>
<stylenode LOCALIZED_TEXT="styles.root_node" STYLE="oval" UNIFORM_SHAPE="true" VGAP_QUANTITY="24.0 pt">
<font SIZE="24"/>
<stylenode LOCALIZED_TEXT="styles.predefined" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="default" ICON_SIZE="12.0 pt" COLOR="#000000" STYLE="fork">
<font NAME="SansSerif" SIZE="10" BOLD="false" ITALIC="false"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.details"/>
<stylenode LOCALIZED_TEXT="defaultstyle.attributes">
<font SIZE="9"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.note" COLOR="#000000" BACKGROUND_COLOR="#ffffff" TEXT_ALIGN="LEFT"/>
<stylenode LOCALIZED_TEXT="defaultstyle.floating">
<edge STYLE="hide_edge"/>
<cloud COLOR="#f0f0f0" SHAPE="ROUND_RECT"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.user-defined" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="styles.topic" COLOR="#18898b" STYLE="fork">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subtopic" COLOR="#cc3300" STYLE="fork">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subsubtopic" COLOR="#669900">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.important">
<icon BUILTIN="yes"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.AutomaticLayout" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="AutomaticLayout.level.root" COLOR="#000000" STYLE="oval" SHAPE_HORIZONTAL_MARGIN="10.0 pt" SHAPE_VERTICAL_MARGIN="10.0 pt">
<font SIZE="18"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,1" COLOR="#0033ff">
<font SIZE="16"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,2" COLOR="#00b439">
<font SIZE="14"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,3" COLOR="#990000">
<font SIZE="12"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,4" COLOR="#111111">
<font SIZE="10"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,5"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,6"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,7"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,8"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,9"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,10"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,11"/>
</stylenode>
</stylenode>
</map_styles>
</hook>
<hook NAME="AutomaticEdgeColor" COUNTER="19" RULE="ON_BRANCH_CREATION"/>
<node TEXT="introduction" POSITION="right" ID="ID_1726963546" CREATED="1565705564248" MODIFIED="1567860804811">
<edge COLOR="#ff00ff"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      footer: @EvilTester | Copyright &#169; 2019, Compendium Developments Ltd
    </p>
    <p>
      slidenumbers: true
    </p>
    <p>
      Autoscale: true
    </p>
    <p>
      
    </p>
    <p>
      &lt;!-- footer: @EvilTester | Copyright &#169; 2019, Compendium Developments Ltd --&gt;
    </p>
    <p>
      <font color="rgb(68, 68, 68)" face="Menlo, Monaco, Consolas, Courier New, monospace">&lt;!-- page_number: true --&gt; </font>
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
<node TEXT="title" ID="ID_1803471607" CREATED="1567860816541" MODIFIED="1567862687655"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      # Hands on exploration of Page Objects and Abstraction Layers with Selenium WebDriver
    </p>
    <p>
      
    </p>
    <p>
      ## A Tutorial Workshop
    </p>
    <p>
      
    </p>
    <p>
      - Alan Richardson
    </p>
    <p>
      - @eviltester
    </p>
    <p>
      
    </p>
    <p>
      alan@compendiumdev.co.uk
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
    <p>
      - www.EvilTester.com
    </p>
    <p>
      - www.CompendiumDev.co.uk
    </p>
    <p>
      - www.JavaForTesters.com
    </p>
    <p>
      - www.SeleniumSimplified.com
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Intro" ID="ID_370601591" CREATED="1565705588954" MODIFIED="1567862691187"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Introduction
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Scope" ID="ID_1022842656" CREATED="1565705612017" MODIFIED="1567860823120"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      After gaining some experience of web automation tools, you start to realise that &#8220;yes, you have to learn the API&#8221;, but the real challenge is modeling the application and building an abstraction layer which supports different approaches to automation. And when we build an abstraction layer, we have lots of options to choose between.
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      - Do you use the Page Factory?
    </p>
    <p>
      - What counts as a page object?
    </p>
    <p>
      - Should a page object offer logical functions like &#8220;loginAs&#8221; or does it only model the physical world?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      - How do we deal with navigation? Return page objects, or with a different set of objects?
    </p>
    <p>
      - Do we need abstractions for Dom elements like input fields or is WebElement enough?
    </p>
    <p>
      - When do we synchronise with WebDriverWait and when do we use SlowLoadableComponent?
    </p>
    <p>
      - Should we build our own abstractions on top of SlowLoadableComponent?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      By using a simple web application, we will use these, and other questions, to discuss and experiment with, the most challenging parts of Web Automation &#8211; the modeling and construction of robust and re-usable abstraction layers.
    </p>
    <p>
      
    </p>
    <p>
      Existing practitioners, be prepared to discuss the choices you have made in the past, what worked, and what didn&#8217;t, so that we can learn and possibly build on some of those decisions.
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      This is open to novices and experienced practitioners, but if you want to take part then make sure you have a functioning Selenium WebDriver installation. All examples will be presented using Java, but that doesn&#8217;t stop you writing experiments in Python, .Net, or whatever other language you favour.
    </p>
    <p>
      
    </p>
    <p>
      Bring your laptop, and you&#8217;ll have the opportunity to explore different ways of building Page Objects and abstraction layers.
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Logistics Half Day" ID="ID_1957004601" CREATED="1565705658908" MODIFIED="1567863544867"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # What Will We Cover?
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      * Intro
    </p>
    <p>
      * General Abstractions Overview
    </p>
    <p>
      * Abstraction Approaches Overview &amp; Discussions
    </p>
    <p>
      * Modelling
    </p>
    <p>
      * Example Implementations
    </p>
    <p>
      * Additional Approaches
    </p>
    <p>
      * Hands on Exercises
    </p>
    <p>
      * Debriefs &amp; Wrap Ups
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
    <p>
      &lt;!--
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Logistics &amp; Plan For Half Day Workshop
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;11:00 &#8211; 12:30 == 1.5
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Intro
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;General Abstractions Overview
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Example Implementations &amp; Discussions
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Exercise (till lunch)
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;*&#160;&#160;&#160;Given some scenarios, create some tests and abstraction layers to support your tests
    </p>
    <p>
      *&#160;&#160;&#160;13:30 &#8211; 15:00 == 1.5
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Continue exercises and debrief
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Examples and Comparison with group
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Exercise (till end)
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Adjust your code, refactor to other approaches
    </p>
    <p>
      
    </p>
    <p>
      # Logistics for 3 Hours
    </p>
    <p>
      
    </p>
    <p>
      - take breaks when you need during exercises
    </p>
    <p>
      
    </p>
    <p>
      * Introduction, Exercise: download code get it working
    </p>
    <p>
      * Abstraction Concepts,&#160; Abstraction Approaches Overview, Frameworks Vs Libraries, Modelling
    </p>
    <p>
      * Example Implementations 15/15
    </p>
    <p>
      
    </p>
    <p>
      --&gt;
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Code and Links" ID="ID_1157472741" CREATED="1565705715495" MODIFIED="1567859394771"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Code Examples &amp; Slides
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;[<a charset="utf-8" href="https://github.com/eviltester/automationAbstractions">github.com/eviltester/automationAbstractions</a>](<a charset="utf-8" href="https://github.com/eviltester/automationAbstractions">https://github.com/eviltester/automationAbstractions</a>)
    </p>
    <p>
      *&#160;&#160;&#160;link to slides
    </p>
    <p>
      
    </p>
    <p>
      The code uses Maven, Java 1.8 (or above), everything is brought down as a dependency using Maven - you do not need to install WebDriver or Drivers. You do need to have Chrome (recommended), or Firefox, or Safari.
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Tour of the Code
    </p>
    <p>
      
    </p>
    <p>
      - pom.xml
    </p>
    <p>
      &#160;&#160;&#160;- dependencies
    </p>
    <p>
      &#160;&#160;&#160;- web driver manager
    </p>
    <p>
      - examples
    </p>
    <p>
      &#160;&#160;&#160;- uk.co.compendiumdev.examples
    </p>
    <p>
      &#160;&#160;&#160;- simple worked examples with exercises
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Tour of the code - Case Studies
    </p>
    <p>
      
    </p>
    <p>
      - casestudybasic
    </p>
    <p>
      &#160;&#160;&#160;- a basic test with no abstractions to refactor to page objects or other components
    </p>
    <p>
      - casestudyexample
    </p>
    <p>
      &#160;&#160;&#160;- an existing test with existing abstractions, fix, refactor, explore
    </p>
    <p>
      - casestudyrefactor
    </p>
    <p>
      &#160;&#160;&#160;- a test with a single page object, good basis to refactor from
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Who we?" ID="ID_1943060663" CREATED="1565705731808" MODIFIED="1565705734486">
<node TEXT="Experience" ID="ID_706926930" CREATED="1565705735814" MODIFIED="1567859426135"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Experiences Check
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Used WebDriver?
    </p>
    <p>
      *&#160;&#160;&#160;What Languages?
    </p>
    <p>
      *&#160;&#160;&#160;Abstraction Layers?
    </p>
    <p>
      *&#160;&#160;&#160;Frameworks?
    </p>
    <p>
      *&#160;&#160;&#160;Current setup
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Laptop With You? Ready to code?
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
</node>
<node TEXT="Abstraction Concepts" POSITION="right" ID="ID_411224746" CREATED="1565701359955" MODIFIED="1567860854612">
<edge COLOR="#ff0000"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Abstraction Concepts
    </p>
  </body>
</html>
</richcontent>
<node TEXT="What is Abstraction?" ID="ID_860182251" CREATED="1565705782412" MODIFIED="1565705786170">
<node TEXT="Discussion" ID="ID_773557616" CREATED="1565705788982" MODIFIED="1565705826310"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # What is Abstraction?
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Discuss
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Example List" ID="ID_771641799" CREATED="1565705794292" MODIFIED="1567859474309"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Abstraction
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Modelling
    </p>
    <p>
      *&#160;&#160;&#160;Separation of concerns
    </p>
    <p>
      *&#160;&#160;&#160;Logical vs Physical
    </p>
    <p>
      *&#160;&#160;&#160;Functional vs Structural
    </p>
    <p>
      *&#160;&#160;&#160;Interfaces vs Implementations
    </p>
    <p>
      *&#160;&#160;&#160;Data / Entities / Persistence
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Abstraction
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Functionality / Task Flow
    </p>
    <p>
      *&#160;&#160;&#160;Goals / Strategies
    </p>
    <p>
      *&#160;&#160;&#160;Layers &#8211; GUI, DB, HTTP
    </p>
    <p>
      *&#160;&#160;&#160;Etc.
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="What does Abstraction look like?" ID="ID_1901637595" CREATED="1565705982147" MODIFIED="1567087917210"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # What does abstraction look like?
    </p>
  </body>
</html>
</richcontent>
<node TEXT="No Abstraction Test" ID="ID_404889824" CREATED="1565705990899" MODIFIED="1567088194627"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Example Test Without Abstraction
    </p>
    <p>
      
    </p>
    <p>
      _NoAbstractionTest.java_
    </p>
    <p>
      
    </p>
    <p>
      _shown on next slide_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      @Test
    </p>
    <p>
      public void canCreateAToDo(){
    </p>
    <p>
      &#160;&#160;&#160;&#160;WebDriver driver = new ChromeDriver();&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      &#160;&#160;&#160;&#160;String siteURL = &quot;http://todomvc.com/examples/backbone/&quot;;
    </p>
    <p>
      &#160;&#160;&#160;&#160;driver.get(siteURL);
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;int originalNumberOfTodos = driver.findElements(
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;By.cssSelector(&quot;ul.todo-list li&quot;)).size();
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;WebElement createTodo = driver.findElement(
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;By.className(&quot;new-todo&quot;));
    </p>
    <p>
      &#160;&#160;&#160;&#160;createTodo.click();
    </p>
    <p>
      &#160;&#160;&#160;&#160;createTodo.sendKeys(&quot;new task&quot;);
    </p>
    <p>
      &#160;&#160;&#160;&#160;createTodo.sendKeys(Keys.ENTER);
    </p>
    <p>
      &#160;&#160;&#160;&#160;Assertions.assertTrue(driver.findElement(
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;By.className(&quot;filters&quot;)).isDisplayed());
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;int newToDoCount = driver.findElements(
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;By.cssSelector(&quot;ul.todo-list li&quot;)).size();
    </p>
    <p>
      &#160;&#160;&#160;&#160;Assertions.assertTrue(newToDoCount &gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;originalNumberOfTodos);
    </p>
    <p>
      &#160;&#160;&#160;&#160;driver.close();
    </p>
    <p>
      &#160;&#160;&#160;&#160;driver.quit();
    </p>
    <p>
      }
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      ## But there are abstractions
    </p>
    <p>
      
    </p>
    <p>
      - ChromeDriver
    </p>
    <p>
      - WebDriver
    </p>
    <p>
      - Variable Names, Method Names
    </p>
    <p>
      - Library Method calls
    </p>
    <p>
      - Assertion Libraries
    </p>
    <p>
      - JUnit Test Runner and Annotations
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Abstraction" ID="ID_1718815732" CREATED="1565705996614" MODIFIED="1567859592009"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Example Test With Abstraction
    </p>
    <p>
      
    </p>
    <p>
      _WithAbstractionTest.java_
    </p>
    <p>
      
    </p>
    <p>
      _shown on next slide_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      @Test
    </p>
    <p>
      public void canCreateAToDo(){
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;WebDriver driver = new ExecutionDriver().get();
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;TodoMVCUser user = new TodoMVCUser(driver,
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;new TodoMVCSite());
    </p>
    <p>
      &#160;&#160;&#160;&#160;user.
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;opensApplication().
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;and().
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;createNewToDo(&quot;new task&quot;);
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;TodoMVCPojoPage page =
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;new TodoMVCPojoPage(driver,
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;new TodoMVCSite().getURL());
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;assertThat(page.getCountOfTodoDoItems(), is(1));
    </p>
    <p>
      &#160;&#160;&#160;&#160;assertThat(page.isFooterVisible(), is(true));
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;ExecutionDriver.closeDriver(driver);
    </p>
    <p>
      }
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      ## What Abstractions?
    </p>
    <p>
      
    </p>
    <p>
      - `@Before, @After` - abstract setup and tear down
    </p>
    <p>
      - driver creation _using ExecutionDriver_
    </p>
    <p>
      - environment url management _using TodoMVCSite_
    </p>
    <p>
      - User Workflow abstraction _TodoMVCUser_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      ## What Abstractions?
    </p>
    <p>
      
    </p>
    <p>
      - Application page abstractions _ApplicationPageFunctional_
    </p>
    <p>
      - test method and variable naming
    </p>
    <p>
      - assertions from HamCrest
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="Why Abstractions?" ID="ID_75870470" CREATED="1565706093928" MODIFIED="1567001801582"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Why do we use Abstractions?
    </p>
    <p>
      
    </p>
    <p>
      - Discussion
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Why Abstraction?
    </p>
    <p>
      
    </p>
    <p>
      *&#160;Change implementations easily
    </p>
    <p>
      *&#160;Single Responsibility &#8211; only changes when necessary
    </p>
    <p>
      *&#160;Makes automation readable and maintainable
    </p>
    <p>
      * When app changes, fewer changes to test code
    </p>
    <p>
      * Code Completion when writing code
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Quotes" ID="ID_848086850" CREATED="1565706211649" MODIFIED="1565706213046">
<node TEXT="Lewis Carrol Quote" ID="ID_1460609873" CREATED="1565706156006" MODIFIED="1567859667769"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      &#8220;...The name of the song is called &#8216;Haddocks' Eyes.&#8217;&#8221;
    </p>
    <p>
      
    </p>
    <p>
      &#8220;Oh, that's the name of the song, is it?&quot; Alice said, trying to feel interested.
    </p>
    <p>
      
    </p>
    <p>
      &#8220;No, you don't understand,&#8221; the Knight said, looking a little vexed. &#8220;That's what the name is called. The name really is &#8216;The Aged Aged Man.&#8217;&#8221;
    </p>
    <p>
      
    </p>
    <p>
      - Lewis Carroll, Through The Looking Glass
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      &#8220;Then I ought to have said &#8216;That's what the song is called&#8217;?&#8221; Alice corrected herself.
    </p>
    <p>
      
    </p>
    <p>
      &#8220;No, you oughtn't: that's quite another thing! The song is called &#8216;Ways And Means&#8217;: but that's only what it's called, you know!&#8221;
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
    <p>
      &#8220;Well, what is the song, then?&#8221; said Alice, who was by this time completely bewildered. &#8220;I was coming to that,&#8221; the Knight said. &#8220;The song really is &#8216;A-sitting On A Gate&#8217;: and the tune's my own invention.&#8221;&#8221;
    </p>
    <p>
      
    </p>
    <p>
      - Lewis Carroll, Through The Looking Glass
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Dijkstra quote" ID="ID_500126156" CREATED="1565705830067" MODIFIED="1567088373472"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # &#8220;The purpose of abstraction is not to be vague, but to create a new semantic level in which one can be absolutely precise.&#8221;
    </p>
    <p>
      
    </p>
    <p>
      ## Edsger Dijkstra
    </p>
    <p>
      
    </p>
    <p>
      ## The Humble Programmer
    </p>
    <p>
      
    </p>
    <p>
      <a charset="utf-8" href="https://www.cs.utexas.edu/~EWD/transcriptions/EWD03xx/EWD340.html">[www.cs.utexas.edu/~EWD/transcriptions/EWD03xx/EWD340.html](https://www.cs.utexas.edu/~EWD/transcriptions/EWD03xx/EWD340.html)</a>
    </p>
    <p>
      <a charset="utf-8" href="https://www.cs.utexas.edu/~EWD/transcriptions/EWD03xx/EWD340.html">
</a>    </p>
    <p>
      <a charset="utf-8" href="https://www.cs.utexas.edu/~EWD/ewd03xx/EWD340.PDF">[www.cs.utexas.edu/~EWD/ewd03xx/EWD340.PDF](https://www.cs.utexas.edu/~EWD/ewd03xx/EWD340.PDF)</a>
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Blake Quote" ID="ID_1999878747" CREATED="1565705759911" MODIFIED="1567863328833"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      ![fit](images/blake.png)
    </p>
    <p>
      
    </p>
    <p>
      # &#8220;I must create a system. or be enslav'd by another Mans; I will not reason &amp; compare: my business is to create&#8221;
    </p>
    <p>
      
    </p>
    <p>
      ## William Blake, Jerusalem: The Emanation of the Giant Albion
    </p>
    <p>
      
    </p>
    <p>
      [http://www.blakearchive.org/search/?search=%22must%20create%20a%20system%22](http://www.blakearchive.org/search/?search=%22must%20create%20a%20system%22)
    </p>
    <p>
      
    </p>
    <p>
      [http://www.blakearchive.org/copy/jerusalem.a?descId=jerusalem.a.illbk.10](http://www.blakearchive.org/copy/jerusalem.a?descId=jerusalem.a.illbk.10)
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="lessons from quotes" ID="ID_1741896863" CREATED="1567001822964" MODIFIED="1567859721030"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Lessons from Quotes
    </p>
    <p>
      
    </p>
    <p>
      - names are easy to change
    </p>
    <p>
      - multiple nested abstractions
    </p>
    <p>
      - precision
    </p>
    <p>
      &#160;&#160;&#160;- create new layers when required
    </p>
    <p>
      &#160;&#160;&#160;- don't shove everything in one class
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Lessons from Quotes
    </p>
    <p>
      
    </p>
    <p>
      - flexibility, not control
    </p>
    <p>
      &#160;&#160;&#160;- make it easy to get the thing abstracted
    </p>
    <p>
      - abstractions for 'common' items
    </p>
    <p>
      - decision making (and re-making)
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="Abstraction Approaches Overview" POSITION="right" ID="ID_444938198" CREATED="1565705493575" MODIFIED="1567860875694">
<edge COLOR="#0000ff"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Abstraction Approaches Overview
    </p>
  </body>
</html>
</richcontent>
<node TEXT="Categorised - Data, Physical, etc." ID="ID_590222376" CREATED="1565706245040" MODIFIED="1567859764990"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Abstraction Layers Categorised
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;**Data**
    </p>
    <p>
      *&#160;&#160;&#160;**Physical**
    </p>
    <p>
      *&#160;&#160;&#160;**Domain**
    </p>
    <p>
      *&#160;&#160;&#160;**Logical**
    </p>
    <p>
      * **etc.**
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Abstraction Layers Categorised
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;**Data**
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Generic Data Abstractions e.g. email, postcode
    </p>
    <p>
      *&#160;&#160;&#160;**Physical**
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Physical layout of your application e.g. pages, components
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Navigation across pages
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Abstraction Layers Categorised
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;**Domain**
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Your application Entities domain e.g. user, account
    </p>
    <p>
      *&#160;&#160;&#160;**Logical**
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;User actions, workflows
    </p>
    <p>
      * **etc.**
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Common Examples" ID="ID_1625590576" CREATED="1565706282255" MODIFIED="1567859835551"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Common Automation Abstractions
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Page Objects
    </p>
    <p>
      *&#160;&#160;&#160;Element Abstractions: select, textbox, etc.
    </p>
    <p>
      *&#160;&#160;&#160;Domain Objects, Infrastructure
    </p>
    <p>
      *&#160;&#160;&#160;Gherkin (Given/When/And/Then)
    </p>
    <p>
      *&#160;&#160;&#160;Domain Specific Languages
    </p>
    <p>
      *&#160;&#160;&#160;Any More?
    </p>
    <p>
      
    </p>
    <p>
      &lt;!--
    </p>
    <p>
      
    </p>
    <p>
      Any more exercise:
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Create a List to discuss
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Any public examples?
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Any examples in the room that can be shared?
    </p>
    <p>
      
    </p>
    <p>
      --&gt;
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="image overview" ID="ID_1893853458" CREATED="1566208925451" MODIFIED="1566208928882">
<node TEXT="domain" ID="ID_895412889" CREATED="1566208957091" MODIFIED="1567857909214"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Abstractions - Domain
    </p>
    <p>
      
    </p>
    <p>
      ![right, fit](images/abstractions-domain.png)
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="app" ID="ID_1884198476" CREATED="1566208960195" MODIFIED="1567857914163"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Abstractions - APP
    </p>
    <p>
      
    </p>
    <p>
      ![right, fit](images/abstractions-app.png)
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="DOM" ID="ID_1055391464" CREATED="1566208962738" MODIFIED="1567857917917"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Abstractions - DOM
    </p>
    <p>
      
    </p>
    <p>
      ![right, fit](images/abstractions-dom.png)
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="Not Implementation" ID="ID_170936838" CREATED="1566209047271" MODIFIED="1566990203028"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Abstraction != Implementation
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Abstraction != Tool / Framework / Implementation
    </p>
    <p>
      *&#160;&#160;&#160;Gherkin != Cucumber
    </p>
    <p>
      *&#160;&#160;&#160;Page Object != Page Factory
    </p>
    <p>
      *&#160;&#160;&#160;Domain Specific Language != Keyword Driven
    </p>
    <p>
      
    </p>
    <p>
      ## If we want to get good at abstraction then we need to model, split apart, and make the relationships clear
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="WebDriver As Abstraction" ID="ID_1368675911" CREATED="1566209083137" MODIFIED="1567001997528"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # WebDriver is an Abstraction Layer
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Dom Abstraction
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;WebElement
    </p>
    <p>
      *&#160;&#160;&#160;Browser Abstraction
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;WebDriver
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;*&#160;&#160;&#160;FireFox, Chrome, Remote etc.
    </p>
    <p>
      *&#160;&#160;&#160;HTML Abstractions
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Cookies, Frames, etc.
    </p>
    <p>
      *&#160;&#160;&#160;'Support' classes augment WebDriver
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;e.g. _com.seleniumsimplified.selenium.support_
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Abstraction Libraries vs Frameworks" ID="ID_531287098" CREATED="1566223592430" MODIFIED="1567860099547"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Frameworks vs Libraries
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Frameworks vs Libraries
    </p>
    <p>
      
    </p>
    <p>
      - Frameworks
    </p>
    <p>
      &#160;&#160;&#160;- Control
    </p>
    <p>
      &#160;&#160;&#160;- Can only do what Framework allows
    </p>
    <p>
      &#160;&#160;&#160;- Calls your code
    </p>
    <p>
      
    </p>
    <p>
      _What else?_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Frameworks vs Libraries
    </p>
    <p>
      
    </p>
    <p>
      - Libraries
    </p>
    <p>
      &#160;&#160;&#160;- Freedom
    </p>
    <p>
      &#160;&#160;&#160;- Can be abstracted
    </p>
    <p>
      &#160;&#160;&#160;- Used for multiple purposes e.g. functional, performance, exploratory
    </p>
    <p>
      &#160;&#160;&#160;- You call it
    </p>
    <p>
      
    </p>
    <p>
      _What else?_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # What is it? Framework or Library?
    </p>
    <p>
      
    </p>
    <p>
      - JUnit
    </p>
    <p>
      - WebDriver
    </p>
    <p>
      - AssertJ, HamCrest
    </p>
    <p>
      - A Base Test Class that we extend
    </p>
    <p>
      
    </p>
    <p>
      _Discuss. Other Examples? Pros &amp; Cons?_
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Code Coverage of Abstractions" ID="ID_492720129" CREATED="1566903669718" MODIFIED="1566990684323">
<node TEXT="code coverage" ID="ID_466991951" CREATED="1566903676558" MODIFIED="1567088469143"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Code Coverage &amp; Unit Testing
    </p>
    <p>
      
    </p>
    <p>
      We write @Test methods that use abstractions to do stuff.
    </p>
    <p>
      
    </p>
    <p>
      - Do we write Unit Tests for our @Test code?
    </p>
    <p>
      - Do we write Unit Tests for our Abstraction Layers?
    </p>
    <p>
      - Do we run our @Test with code coverage?
    </p>
    <p>
      
    </p>
    <p>
      _see coverage package_
    </p>
    <p>
      
    </p>
    <p>
      &lt;!--
    </p>
    <p>
      
    </p>
    <p>
      Code coverage can help us identify risks in our abstraction libraries.
    </p>
    <p>
      
    </p>
    <p>
      If we run our tests with code coverage on, and see that there are
    </p>
    <p>
      unused parts of our abstraction layers. Then we don't know if they still
    </p>
    <p>
      execute. So the next time someone tries to use the abstraction layer, it
    </p>
    <p>
      might fail. And they have to spend time debugging the abstraction layer
    </p>
    <p>
      but they might also not know it is the abstraction layer since that is a
    </p>
    <p>
      trusted part of our code. So they waste time 'blaming' their @Test method
    </p>
    <p>
      or the area of functionality that they are trying to automate.
    </p>
    <p>
      
    </p>
    <p>
      Periodically running the automated execution with code coverage to check how
    </p>
    <p>
      well the abstraction layers are covered can help mitigate this risk.
    </p>
    <p>
      
    </p>
    <p>
      It might reveal:
    </p>
    <p>
      
    </p>
    <p>
      - unused parts of the abstraction layers because they are old
    </p>
    <p>
      &#160;&#160;and not longer required.
    </p>
    <p>
      - unused parts of abstraction layer that have never been used and
    </p>
    <p>
      &#160;&#160;are risky.
    </p>
    <p>
      - parts of the application that are not exercised because the
    </p>
    <p>
      &#160;&#160;abstraction layers are not used.
    </p>
    <p>
      
    </p>
    <p>
      --&gt;
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
</node>
<node TEXT="Modelling" POSITION="right" ID="ID_1554386921" CREATED="1566209109305" MODIFIED="1567860885593">
<edge COLOR="#00007c"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Modelling
    </p>
  </body>
</html>
</richcontent>
<node TEXT="Model The Application Under Test" ID="ID_1268090405" CREATED="1566209112680" MODIFIED="1567002368212"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Model the application under test
    </p>
    <p>
      
    </p>
    <p>
      The key to effective abstractions is modelling.
    </p>
  </body>
</html>
</richcontent>
<node TEXT="Given an App" ID="ID_1548431429" CREATED="1566209132750" MODIFIED="1567857961545"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Given an App &#8211; todomvc.com
    </p>
    <p>
      
    </p>
    <p>
      ![right, fit](images/todomvc.png)
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Overview Demo" ID="ID_1316213067" CREATED="1566209137498" MODIFIED="1567857967710"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # TodoMVC.com Functional Overview Demo
    </p>
    <p>
      
    </p>
    <p>
      ![right, fit](images/todomvc.png)
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Single Page App
    </p>
    <p>
      *&#160;&#160;&#160;Shows Counts
    </p>
    <p>
      *&#160;&#160;&#160;Data held in HTML5 local storage
    </p>
    <p>
      *&#160;&#160;&#160;Create/Edit/Complete a 'todo'
    </p>
    <p>
      *&#160;&#160;&#160;Clear Completed
    </p>
    <p>
      *&#160;&#160;&#160;Filter active/completed/all
    </p>
    <p>
      *&#160;&#160;&#160;Delete a todo
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Modelling Thoughts" ID="ID_1647520487" CREATED="1566209143550" MODIFIED="1567857973201"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Exercise Given an App &#8211; todomvc.com
    </p>
    <p>
      
    </p>
    <p>
      ![right, fit](images/todomvc.png)
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;What Abstractions might we build?
    </p>
    <p>
      *&#160;&#160;&#160;What thoughts do we have?
    </p>
    <p>
      *&#160;&#160;&#160;What underpins our analysis?
    </p>
    <p>
      *&#160;&#160;&#160;What might be hard?
    </p>
    <p>
      *&#160;&#160;&#160;What risks are there?
    </p>
    <p>
      &#160;&#160;&#160;- that impact our automating and modelling
    </p>
    <p>
      
    </p>
    <p>
      ## _...Then Debrief_
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Summary" ID="ID_1796613125" CREATED="1567002376830" MODIFIED="1567860275116"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Modelling
    </p>
    <p>
      
    </p>
    <p>
      Our code is a model of the application
    </p>
    <p>
      - `@Test` - flows
    </p>
    <p>
      - Abstraction Layers
    </p>
    <p>
      &#160;&#160;&#160;- models with a point of view
    </p>
    <p>
      &#160;&#160;&#160;&#160;- we can model the same page in different ways
    </p>
    <p>
      - Method, Class, Variable Naming
    </p>
    <p>
      &#160;&#160;&#160;&#160;- our Ubiquitous Language
    </p>
    <p>
      - Models reveal coverage
    </p>
    <p>
      &#160;&#160;&#160;&#160;- review Page Objects might reveal gaps in testing
    </p>
    <p>
      &#160;&#160;&#160;&#160;- if it isn't modelled, it isn't covered.
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
</node>
<node TEXT="Example Implementations" POSITION="right" ID="ID_1311755717" CREATED="1566209187449" MODIFIED="1567079074081">
<edge COLOR="#007c00"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Example Implementations
    </p>
  </body>
</html>
</richcontent>
<node TEXT="Overview" ID="ID_385706662" CREATED="1567079049798" MODIFIED="1567079052164">
<node TEXT="Summary of implementations" ID="ID_1008329097" CREATED="1567079058012" MODIFIED="1567079483695"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Example Implementations
    </p>
    <p>
      
    </p>
    <p>
      - Infrastructure - downloading dependencies and setting up tools
    </p>
    <p>
      - Driver Abstractions - don't instantiate drivers directly use an abstraction
    </p>
    <p>
      - Environment Abstractions - config abstraction, e.g. don 't code URLs into test
    </p>
    <p>
      - Element Abstractions - alternative to WebElement e.g. CheckBox, Select etc.
    </p>
    <p>
      - Page Object - model the page as common actions or physical elements
    </p>
    <p>
      - Fluent Page Objects - allow method chaining for readable tests avoiding BDD DSL tools
    </p>
    <p>
      - Navigation Abstractions - separate navigation from actions, so pages don't have to know about other pages
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Example Implementations
    </p>
    <p>
      
    </p>
    <p>
      - Component Abstractions - common chunks of the page as separate classes
    </p>
    <p>
      - Domain Abstractions - model the domain and work with data, or ubiquitous language
    </p>
    <p>
      - Gherkin as DSL Abstraction - using BDD style tools for DSL creation
    </p>
    <p>
      - Assertion Abstractions - different assertion approaches separate from test execution
    </p>
    <p>
      - Base Test - framework style implementation of abstraction layers
    </p>
    <p>
      - Browser Abstractions - access cookies, local storage etc.
    </p>
    <p>
      - Workarounds - abstractions to help work around bugs, limitations, in tooling
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="Infrastructure" ID="ID_393792208" CREATED="1566223075869" MODIFIED="1567860912867"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Infrastructure
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Infrastructure Abstraction
    </p>
    <p>
      
    </p>
    <p>
      - Maven and other dependency management tools
    </p>
    <p>
      - WebDriverManager - downloads drivers
    </p>
    <p>
      
    </p>
    <p>
      e.g. see _InfrastructureTest_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Maven
    </p>
    <p>
      
    </p>
    <p>
      Downloads dependencies.
    </p>
    <p>
      
    </p>
    <p>
      e.g. https://github.com/bonigarcia/webdrivermanager
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      &lt;dependency&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&lt;groupId&gt;io.github.bonigarcia&lt;/groupId&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&lt;artifactId&gt;webdrivermanager&lt;/artifactId&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&lt;version&gt;3.6.2&lt;/version&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&lt;scope&gt;test&lt;/scope&gt;
    </p>
    <p>
      &lt;/dependency&gt;
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # WebDriver Manager Usage
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      @Test
    </p>
    <p>
      public void ensureChromeDriverIsAvailable(){
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;WebDriverManager.chromedriver().setup();
    </p>
    <p>
      &#160;&#160;&#160;&#160;WebDriver driver = new ChromeDriver();
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;final TodoMVCSite todoMVCSite = new TodoMVCSite();
    </p>
    <p>
      &#160;&#160;&#160;&#160;driver.get(todoMVCSite.getURL());
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;driver.close();
    </p>
    <p>
      &#160;&#160;&#160;&#160;driver.quit();
    </p>
    <p>
      }
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Infrastructure Abstractions
    </p>
    <p>
      
    </p>
    <p>
      Abstraction is not just in your source code.
    </p>
    <p>
      
    </p>
    <p>
      - downloading, setup, install
    </p>
    <p>
      &#160;&#160;&#160;- chocolatey, homebrew
    </p>
    <p>
      &#160;&#160;&#160;- custom scripts
    </p>
    <p>
      - configuration
    </p>
    <p>
      &#160;&#160;&#160;- support multiple approaches (ability to override at different levels)
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;- global machine, command line, local in IDE, default
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Pros / Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros?
    </p>
    <p>
      - Cons?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Pros / Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros
    </p>
    <p>
      &#160;&#160;&#160;- Makes WebDriver installation simpler
    </p>
    <p>
      &#160;&#160;&#160;- Less to manage in version control
    </p>
    <p>
      - Cons
    </p>
    <p>
      &#160;&#160;&#160;- May reduce technical understanding of WebDriver
    </p>
    <p>
      &#160;&#160;&#160;- Which might impact adoption of cloud execution
    </p>
    <p>
      &#160;&#160;&#160;- Dependent on version manager updates
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Driver Control Abstractions" ID="ID_283432729" CREATED="1566223566082" MODIFIED="1567860924341"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Driver Control Abstractions
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Driver Manager Abstractions
    </p>
    <p>
      
    </p>
    <p>
      A common abstraction for Web GUI automating
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      WebDriver driver = Driver.get();
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      - `Driver` allows us to abstract away the configuration of browsers
    </p>
    <p>
      - To run our tests on multiple browsers without changing the test
    </p>
    <p>
      
    </p>
    <p>
      We have to be careful not to have this limit us.
    </p>
    <p>
      
    </p>
    <p>
      _see DriverManagerTest_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Driver Manager Options
    </p>
    <p>
      
    </p>
    <p>
      - Cached browsers to re-use browser
    </p>
    <p>
      - Creating uncached 'unique' browsers
    </p>
    <p>
      - Static fields for all tests
    </p>
    <p>
      - Unique browser per @Test to support parallelism
    </p>
    <p>
      - Configuration via Environment Variables or System Properties
    </p>
    <p>
      - Configuration via methods
    </p>
    <p>
      - etc.
    </p>
    <p>
      
    </p>
    <p>
      This can become complicated e.g.
    </p>
    <p>
      
    </p>
    <p>
      - [github.com/eviltester/selenium-driver-manager](https://github.com/eviltester/selenium-driver-manager)
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Driver Manager Pros &amp; Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros?
    </p>
    <p>
      - Cons?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Driver Manager Pros &amp; Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros
    </p>
    <p>
      &#160;&#160;&#160;&#160;- Easy to run tests on different browsers without changing test code
    </p>
    <p>
      &#160;&#160;&#160;&#160;- Easy to handle changes in how browsers startup or close
    </p>
    <p>
      &#160;&#160;&#160;&#160;- Central place to control extensions etc.
    </p>
    <p>
      - Cons
    </p>
    <p>
      &#160;&#160;&#160;&#160;- Can become complicated
    </p>
    <p>
      &#160;&#160;&#160;&#160;- People don't learn how to initiate or configure browsers
    </p>
    <p>
      &#160;&#160;&#160;&#160;- When baked into a framework can be harder to configure and use on an adhoc basis
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Environment Abstractions" ID="ID_415531846" CREATED="1566223574160" MODIFIED="1567860939800"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Environment Abstractions
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Environment Abstraction Example
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      driver.get(&quot;https://test.myenv.com&quot;);
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      Instead delegate the handling of information to other classes.
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      final AppEnv myenv = new AppEnv();
    </p>
    <p>
      driver.get(myenv.getURL());
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      _see EnvironmentAbstractionTest_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Environment Abstractions
    </p>
    <p>
      
    </p>
    <p>
      - helps us avoid hard coding in our test:
    </p>
    <p>
      &#160;&#160;&#160;&#160;- urls,
    </p>
    <p>
      &#160;&#160;&#160;&#160;- usernames,
    </p>
    <p>
      &#160;&#160;&#160;&#160;- passwords,
    </p>
    <p>
      &#160;&#160;&#160;&#160;- etc.
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;
    </p>
    <p>
      A 'Config' abstraction.
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Sensitive Data
    </p>
    <p>
      
    </p>
    <p>
      Because these classes often contain sensitive data they are likely to:
    </p>
    <p>
      
    </p>
    <p>
      - configure themselves from System Properties e.g. JVM -D parameters
    </p>
    <p>
      - configure themselves from Environment Variables
    </p>
    <p>
      - throw runtime exceptions if data not set
    </p>
    <p>
      - possibly have non-sensitive defaults
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Environment Abstraction Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros?
    </p>
    <p>
      - Cons?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Environment Abstraction Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros
    </p>
    <p>
      &#160;&#160;&#160;&#160;- switching between environments becomes easier
    </p>
    <p>
      - Cons
    </p>
    <p>
      &#160;&#160;&#160;&#160;- can become complicated
    </p>
    <p>
      &#160;&#160;&#160;&#160;- often not enough flexibility e.g. config by file, harder to amend at runtime
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Element Abstractions" ID="ID_1512820930" CREATED="1566212608123" MODIFIED="1567860948349"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Element Abstractions
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Element Abstractions
    </p>
    <p>
      
    </p>
    <p>
      ![right, fit](images/abstractions-dom.png)
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Element Abstraction Examples
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      public interface Checkbox {
    </p>
    <p>
      &#160;&#160;&#160;public boolean isChecked();
    </p>
    <p>
      &#160;&#160;&#160;public Checkbox check();
    </p>
    <p>
      &#160;&#160;&#160;public Checkbox uncheck();
    </p>
    <p>
      &#160;&#160;&#160;public Checkbox toggle();
    </p>
    <p>
      }
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      *&#160;Would you include 'toggle'?
    </p>
    <p>
      * Does it need to be an interface?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Element Abstraction Examples
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      public class CheckboxHTMLElement implements WrapsElement {
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;private final WebElement webelement;
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;public CheckboxHTMLElement(WebElement element){
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;webelement = element;
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;public boolean isChecked() {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;return webelement.isSelected();
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;public void check() {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;if(!isChecked())
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;toggle();
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      //...
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Element Abstractions
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Existing support: Select,
    </p>
    <p>
      *&#160;&#160;&#160;Possible: TextBox, Checkbox, TextBox, File etc.
    </p>
    <p>
      *&#160;&#160;&#160;`WrapsElement` enforces a 'standard' for abstractions
    </p>
    <p>
      *&#160;&#160;&#160;Can enforce Semantics
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Checkbox: isChecked, check(), uncheck(), toggle()
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;TextBox: clear(), enterText()
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;etc.
    </p>
    <p>
      *&#160;&#160;&#160;Pass back from Page Objects into test?
    </p>
    <p>
      *&#160;&#160;&#160;e.g. _Checkbox in elementabstraction_
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;new CheckBox(element)
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Element Abstraction Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros?
    </p>
    <p>
      - Cons?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Element Abstraction Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros
    </p>
    <p>
      &#160;&#160;&#160;*&#160;Can help 'restrict' code i.e. check or uncheck, rather than click
    </p>
    <p>
      &#160;&#160;&#160;- enforces 'semantics'
    </p>
    <p>
      - Cons
    </p>
    <p>
      &#160;&#160;&#160;*&#160;May have to create a custom page factory if using annotations
    </p>
    <p>
      &#160;&#160;&#160;* not returning the WebElement may restrict people using your library
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Page Objects Theory" ID="ID_466122091" CREATED="1565705552324" MODIFIED="1567860960138"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Page Objects Theory
    </p>
  </body>
</html>
</richcontent>
<node TEXT="What is a Page Object" ID="ID_645788399" CREATED="1566209207045" MODIFIED="1567858139546"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Page Objects
    </p>
    <p>
      
    </p>
    <p>
      ![right, fit](images/abstractions-app.png)
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;The most obvious automation abstraction
    </p>
    <p>
      *&#160;&#160;&#160;What is it?
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;A page? A Component?
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Experiences?
    </p>
    <p>
      *&#160;&#160;&#160;Do web applications still have pages?
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Example
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      public class TodoMVCPojoPage {
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;private static final By TODO_ITEMS = By.cssSelector(
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&quot;ul.todo-list li:not(.hidden)&quot;);
    </p>
    <p>
      &#160;&#160;&#160;&#160;private final WebDriver driver;
    </p>
    <p>
      &#160;&#160;&#160;&#160;private final String url;
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;public TodoMVCPojoPage(WebDriver driver, String url) {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;this.driver = driver;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;this.url = url;
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;public List&lt;WebElement&gt; getTodoItems() {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;return driver.findElements(TODO_ITEMS);
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;//... see TodoMVCPojoPage.java and TodoMVCPojoTest.java
    </p>
    <p>
      &#160;&#160;&#160;&#160;//... package uk.co.compendiumdev.examples.pojo;
    </p>
    <p>
      ~~~~~~~~
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Design Decisions" ID="ID_123769165" CREATED="1566209218453" MODIFIED="1567002767356"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Page Object Design Decisions
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;What methods does it have?
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Functional
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;*&#160;&#160;&#160;login(username, password),
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;*&#160;&#160;&#160;loginAs(user)
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Structural
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;*&#160;&#160;&#160;enterName(username), enterPassword(password), clickLogin(), submitLoginForm(username, password)
    </p>
    <p>
      *&#160;&#160;&#160;Does it expose elements or not?
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;public WebElement loginButton;
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;public WebElement getLoginButton();
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;public clickLoginButton();
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Navigation Decisions" ID="ID_546877232" CREATED="1566209232922" MODIFIED="1566209244165"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Navigation Design Decisions
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Does a Page Object return other pages?
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      public IssueListPage submit(){
    </p>
    <p>
      &#160;&#160;&#160;&#160;driver.findElement(By.id(&#8220;submit&#8221;)).click();
    </p>
    <p>
      &#160;&#160;&#160;&#160;return new IssueListPage(driver);
    </p>
    <p>
      }
    </p>
    <p>
      ~~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Pros?
    </p>
    <p>
      *&#160;&#160;&#160;Cons?
    </p>
    <p>
      *&#160;&#160;&#160;Experiences
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Rules and Guidelines?" ID="ID_1125524029" CREATED="1566209250855" MODIFIED="1566209260424"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Page Objects
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;What rules / guidelines / biases do you use for page objects?
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Possible Rules" ID="ID_681475799" CREATED="1566209266267" MODIFIED="1567860463962"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Possible Rules
    </p>
    <p>
      
    </p>
    <p>
      - No constructors, static factory methods
    </p>
    <p>
      - Do not expose WebElements
    </p>
    <p>
      - Never Return other Page Objects
    </p>
    <p>
      - Physical Actions, not logical
    </p>
    <p>
      - Only logical actions, not physical
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Implementing" ID="ID_1387637548" CREATED="1566209359350" MODIFIED="1567860536481"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Implementing Page Objects
    </p>
    <p>
      
    </p>
    <p>
      * POJO
    </p>
    <p>
      * Page Factory
    </p>
    <p>
      * LoadableComponent
    </p>
    <p>
      * SlowLoadableComponent
    </p>
    <p>
      * Functional vs Structural
    </p>
    <p>
      * Fluent Interfaces
    </p>
    <p>
      * Other approaches?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Implementing Page Objects
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;POJO
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Plain object, driver in constructor, methods use driver.&lt;method&gt;
    </p>
    <p>
      *&#160;&#160;&#160;Page Factory
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Annotated elements, lazy instantiation via reflection
    </p>
    <p>
      *&#160;&#160;&#160;LoadableComponent
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Common interface (load, isLoaded), isLoaded throws Error
    </p>
    <p>
      *&#160;&#160;&#160;SlowLoadableComponent
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Common interface, waits for on isLoaded
    </p>
    <p>
      *&#160;&#160;Functional vs Structural
    </p>
    <p>
      &#160;&#160;&#160;&#160;* type of methods represent user actions or physical actions
    </p>
    <p>
      *&#160;&#160;Fluent Interfaces
    </p>
    <p>
      &#160;&#160;&#160;&#160;- to support method chaining for readable tests
    </p>
    <p>
      *&#160;&#160;&#160;Other approaches?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Code Examples
    </p>
    <p>
      
    </p>
    <p>
      _see packages uk.co.compendiumdev.examples_
    </p>
    <p>
      
    </p>
    <p>
      - pojo,
    </p>
    <p>
      - pagefactory,
    </p>
    <p>
      - navigation,
    </p>
    <p>
      - structuralvsfunctional,
    </p>
    <p>
      - synchronisedcomponent,
    </p>
    <p>
      - component
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="POJO" ID="ID_1460838262" CREATED="1566209488998" MODIFIED="1567943642342"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # POJO
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # POJO Example
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      public class TodoMVCPojoPage {
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;private static final By TODO_ITEMS = By.cssSelector(
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&quot;ul.todo-list li:not(.hidden)&quot;);
    </p>
    <p>
      &#160;&#160;&#160;&#160;private final WebDriver driver;
    </p>
    <p>
      &#160;&#160;&#160;&#160;private final String url;
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;public TodoMVCPojoPage(WebDriver driver, String url) {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;this.driver = driver;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;this.url = url;
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;public List&lt;WebElement&gt; getTodoItems() {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;return driver.findElements(TODO_ITEMS);
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;//... see TodoMVCPojoPage.java and TodoMVCPojoTest.java
    </p>
    <p>
      &#160;&#160;&#160;&#160;//... package uk.co.compendiumdev.examples.pojo;
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # POJO
    </p>
    <p>
      
    </p>
    <p>
      *&#160;Simple Class
    </p>
    <p>
      *&#160;WebDriver passed to constructor
    </p>
    <p>
      *&#160;Refactor to Composition of any components
    </p>
    <p>
      * Single Responsibility?
    </p>
    <p>
      &#160;&#160;&#160;&#160;- Model Physical Page?
    </p>
    <p>
      &#160;&#160;&#160;&#160;- Model Common Functions use on the page?
    </p>
    <p>
      
    </p>
    <p>
      _see pojo \ TodoMVCPojoPage , other examples in the code base_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # POJO Discussion
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Pros
    </p>
    <p>
      *&#160;&#160;&#160;Cons
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # POJO Discussion
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Pros
    </p>
    <p>
      &#160;&#160;&#160;* easy to maintain
    </p>
    <p>
      &#160;&#160;&#160;* simple to understand and extend, requires basic java knowledge
    </p>
    <p>
      &#160;&#160;&#160;* easy to add synchronisation
    </p>
    <p>
      *&#160;&#160;&#160;Cons
    </p>
    <p>
      &#160;&#160;&#160;* might not have a common interface e.g. 'get', 'load', 'waitForReady'
    </p>
    <p>
      &#160;&#160;&#160;* easy to add too many methods and try to do too much
    </p>
  </body>
</html>

</richcontent>
</node>
<node TEXT="Page Factory Annotations" ID="ID_692004250" CREATED="1566209546103" MODIFIED="1567860981964"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Page Factory
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Page Factory Example
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      @FindBy(how = How.CSS, using=&quot;#todo-count strong&quot;)
    </p>
    <p>
      private WebElement countElementStrong;
    </p>
    <p>
      
    </p>
    <p>
      @FindBy(how = How.CSS, using=&quot;#todo-count&quot;)
    </p>
    <p>
      private WebElement countElement;
    </p>
    <p>
      
    </p>
    <p>
      @FindBy(how = How.CSS, using=&quot;#filters li a&quot;)
    </p>
    <p>
      List&lt;WebElement&gt; filters;
    </p>
    <p>
      
    </p>
    <p>
      public ApplicationPageStructuralFactory(WebDriver driver,
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;TodoMVCSite todoMVCSite) {
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;PageFactory.initElements(driver, this);
    </p>
    <p>
      &#160;&#160;&#160;this.driver = driver;
    </p>
    <p>
      &#160;&#160;&#160;//...
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Page Factory
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Annotate fields with @FindBy
    </p>
    <p>
      *&#160;&#160;&#160;Instantiate in constructor using PageFactory.initElements
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Can create your own page factory initialiser
    </p>
    <p>
      
    </p>
    <p>
      _compare pagefactory package with pojo_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Page Factory Discussion
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Pros
    </p>
    <p>
      *&#160;&#160;&#160;Cons
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Page Factory
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Pros
    </p>
    <p>
      &#160;&#160;&#160;&#160;- fast to get started
    </p>
    <p>
      &#160;&#160;&#160;&#160;- annotated elements can be used in WebDriverWait Expected Conditions that take WebElement parameters
    </p>
    <p>
      *&#160;&#160;&#160;Cons
    </p>
    <p>
      &#160;&#160;&#160;&#160;- people often forget about synchronisation
    </p>
    <p>
      &#160;&#160;&#160;&#160;- easy to fall back on implicit wait to fix synchronisation problems
    </p>
    <p>
      &#160;&#160;&#160;&#160;- too easy to make WebElements public
    </p>
    <p>
      &#160;&#160;&#160;&#160;- doesn't handle relative element finding easily
    </p>
    <p>
      &#160;&#160;&#160;&#160;- people can find it hard to mix method and annotation approach
    </p>
  </body>
</html>
</richcontent>
<font BOLD="false"/>
</node>
<node TEXT="Functional vs Structural" ID="ID_295518692" CREATED="1566209527316" MODIFIED="1567860994092"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Functional vs Structural
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Functional vs Structural
    </p>
    <p>
      
    </p>
    <p>
      Model the functions the page exposes, or the physical structure of the page.
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Functional
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;loginAs(username, password)
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;loginAs(user)&#160;&#160;// understands domain
    </p>
    <p>
      *&#160;&#160;&#160;Structural
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;enterUsername(username)
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;enterPassword(password)
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;clickLoginButton()
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;submitLoginForm(username, password)
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;getLoginButton()
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Functional can 'use' the Structural
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      private StructuralPage structure;
    </p>
    <p>
      
    </p>
    <p>
      public FunctionalPage(WebDriver driver,
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;TodoMVCSite todoMVCSite) {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;structure = new StructuralPage(driver, todoMVCSite);
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      public int getCountInFooter() {
    </p>
    <p>
      &#160;&#160;&#160;&#160;// if there is an exception because count is not visible
    </p>
    <p>
      &#160;&#160;&#160;&#160;// then there are 0 items
    </p>
    <p>
      &#160;&#160;&#160;&#160;try{
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;return structure.getCountInFooter();
    </p>
    <p>
      &#160;&#160;&#160;&#160;}catch(Exception e){
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;return 0;
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      public void filterOnAll() {
    </p>
    <p>
      &#160;&#160;&#160;&#160;structure.clickOnFilter(0);
    </p>
    <p>
      }
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Functional Vs Structural Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros?
    </p>
    <p>
      - Cons?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Functional Vs Structural Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros
    </p>
    <p>
      &#160;&#160;&#160;- simple modelling approach
    </p>
    <p>
      - Cons
    </p>
    <p>
      &#160;&#160;&#160;- might be too simple a model
    </p>
    <p>
      &#160;&#160;&#160;- might be confusing - what is logical, what is physical?
    </p>
    <p>
      &#160;&#160;&#160;- delegating from functional to structural seen as unnecessary maintenance
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Functional Vs Structural Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Many page objects are a mix of both - Pros? Cons?
    </p>
    <p>
      - How far could structural go?
    </p>
    <p>
      &#160;&#160;&#160;&#160;- a data object that manages By locators?
    </p>
    <p>
      &#160;&#160;&#160;&#160;- methods to do stuff, and locators?
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;- should locators be public?
    </p>
    <p>
      
    </p>
    <p>
      _see package structuralvsfunctional_
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;One way of answering &#8220;what methods to put on a page object&#8221;
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;Is it functional / behavioural?
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;Is it structural?
    </p>
    <p>
      &#160;&#160;&#160;&#160;* 'logical' vs 'physical'?
    </p>
    <p>
      *&#160;&#160;&#160;Functional 'uses' Structural implementation
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Fluent Page Objects" ID="ID_688900700" CREATED="1566209602196" MODIFIED="1567861032028"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Fluent Page Objects
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Fluent Page Objects
    </p>
    <p>
      
    </p>
    <p>
      - Allow writing tests in DSL type manner
    </p>
    <p>
      
    </p>
    <p>
      e.g.
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      page.
    </p>
    <p>
      &#160;&#160;&#160;&#160;open().
    </p>
    <p>
      &#160;&#160;&#160;&#160;and().
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;createTodo(&quot;My First Todo&quot;).
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;createTodo(&quot;M
    </p>
    <p>
      &#160;&#160;&#160;&#160;then().
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;toggleTodoStatus(1);
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      _see fluent package_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Fluent Page Object Implementation
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      public FluentTodoMVCPage createTodo(String name){
    </p>
    <p>
      &#160;&#160;&#160;&#160;return typeIntoNewToDo(name + Keys.ENTER);
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      public FluentTodoMVCPage open() {
    </p>
    <p>
      &#160;&#160;&#160;&#160;driver.get(url);
    </p>
    <p>
      &#160;&#160;&#160;&#160;return this;
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      public FluentTodoMVCPage and(){
    </p>
    <p>
      &#160;&#160;&#160;&#160;return this;
    </p>
    <p>
      }
    </p>
    <p>
      
    </p>
    <p>
      public FluentTodoMVCPage then(){
    </p>
    <p>
      &#160;&#160;&#160;&#160;return this;
    </p>
    <p>
      }
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Fluent Page Objects
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Methods return the page object or other objects to allow method chaining
    </p>
    <p>
      *&#160;&#160;&#160;Instead of
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;void clickDeleteButton();
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;PageObject clickDeleteButton();
    </p>
    <p>
      *&#160;&#160;&#160;Syntactic sugar methods:
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;and(), then(), also()
    </p>
    <p>
      *&#160;&#160;&#160;Work well at high levels of abstraction
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Fluent Page Objects Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros?
    </p>
    <p>
      - Cons?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Fluent Page Objects Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros
    </p>
    <p>
      &#160;&#160;&#160;- code completion makes writing test code easier
    </p>
    <p>
      &#160;&#160;&#160;- static Factory methods can be used to avoid `new Page`
    </p>
    <p>
      &#160;&#160;&#160;- code is easy to read
    </p>
    <p>
      &#160;&#160;&#160;- might avoid needing a BDD framework
    </p>
    <p>
      - Cons
    </p>
    <p>
      &#160;&#160;&#160;- can encourage long 'sentences' in the test code
    </p>
    <p>
      &#160;&#160;&#160;- chains can get deep if not careful about objects returned
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Loadable Component Interface" ID="ID_1878207772" CREATED="1567081146198" MODIFIED="1567861041996"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Loadable Component
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Loadable Component
    </p>
    <p>
      
    </p>
    <p>
      - Extending LoadableComponent provides a common interface for 'get'ing pages.
    </p>
    <p>
      - With an inbuilt erroring mechanism to check if on correct page
    </p>
    <p>
      
    </p>
    <p>
      _see SynchronisedComponentPojoPage_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Loadable Component Example
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      public class SynchronisedComponentPojoPage extends
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;LoadableComponent {
    </p>
    <p>
      //...
    </p>
    <p>
      &#160;&#160;&#160;&#160;@Override
    </p>
    <p>
      &#160;&#160;&#160;&#160;protected void load() {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;driver.get(url);
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      &#160;&#160;&#160;&#160;@Override
    </p>
    <p>
      &#160;&#160;&#160;&#160;protected void isLoaded() throws Error {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;boolean loaded = false;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;try{
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;if(driver.findElement(
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;By.className(&quot;new-todo&quot;))!=null){
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;loaded = true;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}catch (Exception e){
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;if(!loaded){
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;throw new Error(&quot;page not loaded&quot;);
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      //...
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Loadable Component
    </p>
    <p>
      
    </p>
    <p>
      * Extends LoadableComponent
    </p>
    <p>
      &#160;&#160;&#160;&#160;* Get
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;* If isLoaded, return this
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;* Else load()
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;* Check isLoaded()
    </p>
    <p>
      * Implement _load_
    </p>
    <p>
      &#160;&#160;&#160;&#160;* _Add any synchronisation in **load** to wait for the loading. Exit only when 'loaded'._
    </p>
    <p>
      * Implement _isLoaded_
    </p>
    <p>
      &#160;&#160;&#160;&#160;* _Check, and **throw Error** if not loaded_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Loadable Component Pros &amp; Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros?
    </p>
    <p>
      - Cons?
    </p>
    <p>
      
    </p>
    <p>
      _see SynchronisedComponentPojoPage_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Loadable Component Pros &amp; Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros
    </p>
    <p>
      &#160;&#160;&#160;- provides a common interface to 'pages' and 'components' i.e. `get`
    </p>
    <p>
      &#160;&#160;&#160;- can make isLoaded public if necessary
    </p>
    <p>
      - Cons
    </p>
    <p>
      &#160;&#160;&#160;- Uses Error instead of Exception
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Loadable Component
    </p>
    <p>
      
    </p>
    <p>
      - Because of the use of 'error', I tend not to use this
    </p>
    <p>
      - But I do use the concept of a single interface
    </p>
    <p>
      - and I like the notion of 'isLoaded' but I prefer it to return a boolean and create a custom 'ExpectedCondition' for detecting if 'isLoaded'
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Synchronisation" ID="ID_1868121264" CREATED="1566209348302" MODIFIED="1567861052276"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Synchronisation
    </p>
  </body>
</html>
</richcontent>
<node TEXT="What is it?" ID="ID_1285994334" CREATED="1567005468210" MODIFIED="1567005486073"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Synchronisation
    </p>
    <p>
      
    </p>
    <p>
      - The most important concept for reliable execution
    </p>
    <p>
      - basically
    </p>
    <p>
      &#160;&#160;&#160;- wait for something to be ready,
    </p>
    <p>
      &#160;&#160;&#160;- then interact with it
    </p>
    <p>
      - Can be done at any level - page, page load, element methods, functions
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Implicit or Explicit Wait" ID="ID_62897673" CREATED="1566209394564" MODIFIED="1567005974663"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Implicit or Explicit Wait?
    </p>
    <p>
      
    </p>
    <p>
      - Implicit Wait
    </p>
    <p>
      &#160;&#160;&#160;- configure once in WebDriver and all findElement calls will 'wait' for the element
    </p>
    <p>
      - Explicit Wait
    </p>
    <p>
      &#160;&#160;&#160;- explicitly use `new WebDriverWait(driver, 5).until(...)` in our code
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Implicit Wait Example" ID="ID_308841822" CREATED="1566209402461" MODIFIED="1567005868561"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Implicit Wait
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      driver.manage().timeouts().
    </p>
    <p>
      &#160;&#160;&#160;&#160;implicitlyWait(15L, TimeUnit.SECONDS);
    </p>
    <p>
      Assertions.assertTrue(
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;driver.findElement(
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;By.id(&quot;filters&quot;)).
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;isDisplayed());
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      The findElement 'waits' until element is in DOM before `isDisplayed`
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Explicit Wait Example" ID="ID_41254099" CREATED="1566209407704" MODIFIED="1567080660842"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      #&#160;Explicit Wait
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      driver.manage().timeouts().
    </p>
    <p>
      implicitlyWait(0L, TimeUnit.SECONDS);
    </p>
    <p>
      
    </p>
    <p>
      WebDriverWait wait = new WebDriverWait(driver,15);
    </p>
    <p>
      
    </p>
    <p>
      wait.until(ExpectedConditions.
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;elementToBeClickable(By.id(&quot;filters&quot;)));
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      _Example: firsttests / WebDriverWaitTest.java_
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Example" ID="ID_1132765942" CREATED="1567005514598" MODIFIED="1567088964594"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Simple Example
    </p>
    <p>
      
    </p>
    <p>
      Instead of:
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      WebElement createTodo =
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;driver.findElement(By.className(&quot;new-todo&quot;));
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      WebElement createTodo =
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;new WebDriverWait(driver,10).
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;until(ExpectedConditions.
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;visibilityOfElementLocated(
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;By.className(&quot;new-todo&quot;)));
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      _Thoughts? Discuss?_
    </p>
    <p>
      
    </p>
    <p>
      &lt;!--
    </p>
    <p>
      
    </p>
    <p>
      This uses the concept of wait and return.
    </p>
    <p>
      
    </p>
    <p>
      Sometimes we might wait, and then interact as two different statements.
    </p>
    <p>
      
    </p>
    <p>
      This makes it clear that waiting doesnt' add more to the 'test' than before.
    </p>
    <p>
      
    </p>
    <p>
      Issues?
    </p>
    <p>
      
    </p>
    <p>
      - If element is not present then test is slower to report a problem
    </p>
    <p>
      - creating a wait all the time
    </p>
    <p>
      - what timeout should we use?
    </p>
    <p>
      - where should be synchronise- on each element usage or at a component load level?
    </p>
    <p>
      
    </p>
    <p>
      --&gt;
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Thoughts" ID="ID_28475062" CREATED="1567005493267" MODIFIED="1567005917183"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Thoughts?
    </p>
    <p>
      
    </p>
    <p>
      - Implicit Wait or Explicit Wait?
    </p>
    <p>
      - Synchronise in Tests or Abstraction Layers?
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="Navigation Options" ID="ID_431095089" CREATED="1566209608114" MODIFIED="1567861065874"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Navigation
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Navigation Options
    </p>
    <p>
      
    </p>
    <p>
      Navigation is often not thought about.
    </p>
    <p>
      
    </p>
    <p>
      Many people default to methods that navigate returning new Page objects for&#160;the navigation path.
    </p>
    <p>
      
    </p>
    <p>
      Options:
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Direct in Test e.g. `driver.get`
    </p>
    <p>
      *&#160;&#160;&#160;Instantiate new pages based on test flow
    </p>
    <p>
      *&#160;&#160;&#160;Page Object methods might return other Pages
    </p>
    <p>
      *&#160;&#160;&#160;We might use navigation objects
    </p>
    <p>
      
    </p>
    <p>
      _see navigation package_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Navigation Using Test Flow
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Instantiate new pages based on test flow
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Navigation as side-effect, may have to bypass 'get'
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Loadable pages, non-loadable, support classes
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      allPage.clickOnActiveFilter(); // causes page change
    </p>
    <p>
      activePage = new ActiveToDosPage(driver, todoMVCSite);
    </p>
    <p>
      activePage.waitUntilLoaded();
    </p>
    <p>
      &#160;&#160;&#160;Assertions.assertEquals(4, countVisibleTodos());
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Page Object Return Other Pages
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;e.g. a method on the login page might be
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;*&#160;&#160;&#160;MyAccountPage clickLogin();
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;*&#160;&#160;&#160;Returns a new page
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;*&#160;&#160;&#160;void clickLogin();
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      ActiveToDosPage activePage = allPage.clickOnActiveFilter();
    </p>
    <p>
      activePage.waitUntilLoaded();
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Navigation objects
    </p>
    <p>
      
    </p>
    <p>
      *&#160;direct, or Path based (current page &#8594; desired page)
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Navigate.to(MyAccountPage.class)
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Jump.to(MyAccountPage.class)
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      new TodoMVCNav(driver, todoMVCSite).
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;open(ACTIVE_TODOS_PAGE);
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Navigation Options Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros?
    </p>
    <p>
      - Cons?
    </p>
    <p>
      
    </p>
    <p>
      _see navigation package_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Navigation Options Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros
    </p>
    <p>
      &#160;&#160;&#160;&#160;- separate navigation means reduced maintenance
    </p>
    <p>
      &#160;&#160;&#160;&#160;- make test responsible for knowing navigation path
    </p>
    <p>
      &#160;&#160;&#160;&#160;- navigation object means reducing test maintenance
    </p>
    <p>
      - Cons
    </p>
    <p>
      &#160;&#160;&#160;&#160;- pages returning other pages increases responsibility and maintenance
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;- i.e. page also has to know about app flow
    </p>
    <p>
      &#160;&#160;&#160;&#160;- what if an action has multiple options e.g. `clickLogin()` `clickLoginBad()`
    </p>
    <p>
      &#160;&#160;&#160;&#160;- inconsistency in page object methods, some return pages, some don't
    </p>
    <p>
      &#160;&#160;&#160;&#160;- encourages method chaining without fluency
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Component Abstractions" ID="ID_1958230383" CREATED="1566212996209" MODIFIED="1567861076489"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Component Abstractions
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Component Abstractions
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Components on the screen
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;e.g. `component` package
    </p>
    <p>
      *&#160;&#160;&#160;e.g. `VisibleToDoEntry`, `Filters`, `Footer`, `Header`, `VisibleToDoList`, etc.
    </p>
    <p>
      *&#160;&#160;&#160;Could have 'functional' representation for repeated items e.g. login forms
    </p>
    <p>
      *&#160;&#160;&#160;Could have 'structural' representation
    </p>
    <p>
      *&#160;&#160;&#160;Likely use : page object composition
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Component Abstraction Example
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      VisibleToDoEntry todo;
    </p>
    <p>
      todo = VisibleToDoEntry.getToDoAt(driver, 1);
    </p>
    <p>
      todo.edit(&quot;visible todo&quot;);
    </p>
    <p>
      todo.markActive();
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      _see `component` package_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Pros &amp; Cons of Component Abstractions
    </p>
    <p>
      
    </p>
    <p>
      - Pros?
    </p>
    <p>
      - Cons?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Pros &amp; Cons of Component Abstractions
    </p>
    <p>
      
    </p>
    <p>
      - Pros
    </p>
    <p>
      &#160;&#160;&#160;- can synchronise at component level
    </p>
    <p>
      &#160;&#160;&#160;- more semantic interaction
    </p>
    <p>
      &#160;&#160;&#160;- avoiding overloading page with methods
    </p>
    <p>
      &#160;&#160;&#160;- reduced maintenance of page objects
    </p>
    <p>
      - Cons
    </p>
    <p>
      &#160;&#160;&#160;- might lead to page methods duplicating component functionality
    </p>
    <p>
      &#160;&#160;&#160;- pages returning components might lead to too much method chaining
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Synchronised Components" ID="ID_1689951284" CREATED="1566400887846" MODIFIED="1567861091496"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Synchronised Components
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
<node TEXT="Slow Loadable Component Interface" ID="ID_37623523" CREATED="1566209578841" MODIFIED="1567089220579"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # SlowLoadable Component Example
    </p>
    <p>
      
    </p>
    <p>
      * same interface as LoadableComponent but 'get' is a synch mechanism
    </p>
    <p>
      * Extends SlowLoadableComponent
    </p>
    <p>
      * Constructor has to additionally call
    </p>
    <p>
      &#160;&#160;&#160;&#160;* super(new SystemClock(), 10);
    </p>
    <p>
      &#160;&#160;&#160;&#160;* Where 10 is a timeout # of seconds
    </p>
    <p>
      * _**get()**_
    </p>
    <p>
      &#160;&#160;&#160;&#160;* If isLoaded then return this Else load
    </p>
    <p>
      &#160;&#160;&#160;&#160;* While not loaded{ wait for 200 millseconds}
    </p>
    <p>
      * Implement _**load**_ and _**isLoaded**_
    </p>
    <p>
      &#160;&#160;&#160;&#160;* But can remove sync loops from load
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # SlowLoadableComponent Example
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      public class TodoEditField extends SlowLoadableComponent {
    </p>
    <p>
      private final WebDriver driver;
    </p>
    <p>
      
    </p>
    <p>
      public TodoEditField(WebDriver driver) {
    </p>
    <p>
      &#160;&#160;&#160;&#160;super(Clock.systemDefaultZone(), 20);
    </p>
    <p>
      &#160;&#160;&#160;&#160;this.driver = driver;
    </p>
    <p>
      }
    </p>
    <p>
      @Override
    </p>
    <p>
      protected void load() {}
    </p>
    <p>
      
    </p>
    <p>
      @Override
    </p>
    <p>
      protected void isLoaded() throws Error {
    </p>
    <p>
      &#160;&#160;&#160;&#160;try {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;WebElement element = driver.findElement(
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;By.cssSelector(&quot;li.editing input.edit&quot;));
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;if (element.isEnabled() &amp;&amp; element.isDisplayed()) {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;return;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;}
    </p>
    <p>
      &#160;&#160;&#160;&#160;}catch(Exception e){}
    </p>
    <p>
      &#160;&#160;&#160;&#160;throw new Error(&quot;Component not loaded&quot;);
    </p>
    <p>
      }
    </p>
    <p>
      //...
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Example in Code
    </p>
    <p>
      
    </p>
    <p>
      _synchronisedcomponent \ TodoEditField_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # SlowLoadable Component Discussion
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Pros?
    </p>
    <p>
      *&#160;&#160;&#160;Cons?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # SlowLoadable Component Discussion
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Pros
    </p>
    <p>
      &#160;&#160;&#160;&#160;- consistent interface
    </p>
    <p>
      &#160;&#160;&#160;&#160;- encourages creation of components
    </p>
    <p>
      *&#160;&#160;&#160;Cons
    </p>
    <p>
      &#160;&#160;&#160;&#160;- throws error not exception
    </p>
    <p>
      &#160;&#160;&#160;&#160;- synchronisation requires a `get` but semantically that might wrong i.e. component exists, why `get` it?
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="Domain Abstractions" ID="ID_1005842886" CREATED="1566212578738" MODIFIED="1567861102775"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Domain Abstractions
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Possible Domain Abstractions
    </p>
    <p>
      
    </p>
    <p>
      ![right, fit](images/abstractions-domain.png)
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Logical Objects
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;ToDo
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;ToDoList
    </p>
    <p>
      *&#160;&#160;&#160;Physical Objects
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;LocallyStoredToDo
    </p>
    <p>
      *&#160;&#160;&#160;Actors
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;User
    </p>
    <p>
      *&#160;&#160;&#160;Environment
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Site
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Implementation
    </p>
    <p>
      - Actions
    </p>
    <p>
      &#160;&#160;&#160;&#160;* TodoActions (high level activities) e.g. `createMultipleTodos`
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Example Usage for Functional
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      user.
    </p>
    <p>
      &#160;&#160;&#160;&#160;createNewToDo(&quot;My First Todo&quot;).
    </p>
    <p>
      &#160;&#160;&#160;&#160;and().
    </p>
    <p>
      &#160;&#160;&#160;&#160;createNewToDo(&quot;My Second Todo&quot;);
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      _see DomainTest_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Random Data
    </p>
    <p>
      
    </p>
    <p>
      - Domain objects make random data easier to manage
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      RandomTodoGenerator rnd =
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;new RandomTodoGenerator();
    </p>
    <p>
      myTodos.addNewToDoItem(
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;rnd.getRandomTodoName());
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      _Discus_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Page Objects &amp; Domain Objects
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Instead of
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;`todoMVC.enterNewToDo(&#8220;New Item&#8221;)`
    </p>
    <p>
      *&#160;&#160;&#160;We could have have
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;`ToDoItem newItem = new ToDoItem(&#8220;New Item&#8221;);`
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;`todoMVC.enterNewToDo(newItem);`
    </p>
    <p>
      *&#160;&#160;&#160;Discuss
    </p>
    <p>
      
    </p>
    <p>
      _See code in DomainBasedTest_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Domain Objects That Span Logical &amp; Physical
    </p>
    <p>
      
    </p>
    <p>
      e.g. User
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;user.createNewToDo(&#8220;new item&#8221;)
    </p>
    <p>
      *&#160;&#160;&#160;user.createNewToDo(newItem)
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Discuss
    </p>
    <p>
      
    </p>
    <p>
      _See use in NoAbstractionTest_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Domain Objects Pros &amp; Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros?
    </p>
    <p>
      - Cons?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Domain Objects Pros &amp; Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros
    </p>
    <p>
      &#160;&#160;&#160;&#160;- more semantic tests
    </p>
    <p>
      &#160;&#160;&#160;&#160;- random data can expand coverage
    </p>
    <p>
      &#160;&#160;&#160;&#160;- can make tests smaller
    </p>
    <p>
      &#160;&#160;&#160;&#160;- delegate to other objects to reduce maintenance
    </p>
    <p>
      - Cons
    </p>
    <p>
      &#160;&#160;&#160;&#160;- coupling might mean more maintenance if domain changes
    </p>
    <p>
      &#160;&#160;&#160;&#160;- random data needs management - logging and seeding
    </p>
    <p>
      &#160;&#160;&#160;&#160;- how far should domains be mixed?
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;- should a page know about a TodoItem object?
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;- or just the text of the todo?
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Gherkin as Abstraction Layer" ID="ID_880581920" CREATED="1566213008718" MODIFIED="1567861116831"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Gherkin as an abstraction layer
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Gherkin as an abstraction layer
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      Feature: We can create and edit To Do lists in ToDoMvc
    </p>
    <p>
      
    </p>
    <p>
      We want to amend todos in ToDoMVC because that is
    </p>
    <p>
      the set of exercises on the abstraction tutorial
    </p>
    <p>
      
    </p>
    <p>
      Scenario: Create a ToDo Item
    </p>
    <p>
      &#160;Given a user opens a blank ToDoMVC page
    </p>
    <p>
      &#160;When the user creates a todo &quot;new task&quot;
    </p>
    <p>
      &#160;Then they see 1 todo item on the page
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # About Gherkin Usage
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Implement steps using highest appropriate abstraction layer
    </p>
    <p>
      *&#160;&#160;&#160;CucumberJVM as 'DSL implementor'
    </p>
    <p>
      *&#160;&#160;&#160;'Expressibility' vs 'Step Re-use'
    </p>
    <p>
      *&#160;&#160;&#160;See `todomvc.feature` and `domaindslcucumberjvm` package
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Gherkin / Cucumber Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros?
    </p>
    <p>
      - Cons?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Gherkin / Cucumber Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros
    </p>
    <p>
      &#160;&#160;&#160;- easy to use DSL creation
    </p>
    <p>
      &#160;&#160;&#160;- easy data driven functionality
    </p>
    <p>
      - Cons
    </p>
    <p>
      &#160;&#160;&#160;- people think they are 'doing BDD'
    </p>
    <p>
      &#160;&#160;&#160;- people try to use for everything
    </p>
    <p>
      &#160;&#160;&#160;- code embedded in step rather than abstraction forces use of Cucumber
    </p>
    <p>
      &#160;&#160;&#160;- more skills required on team
    </p>
    <p>
      &#160;&#160;&#160;- should we create a feature or a test? splits focus
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Assertion Abstractions" ID="ID_349433621" CREATED="1566402320079" MODIFIED="1567861125649"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Assertion Abstractions
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Assertion Abstractions
    </p>
    <p>
      
    </p>
    <p>
      - Assertions are important for keeping `@Test` code readable
    </p>
    <p>
      - Self-documenting assertions can make it easier to understand the test fast
    </p>
    <p>
      - Assertion abstractions can usually be mixed across Cucumber, and Test Execution Frameworks
    </p>
  </body>
</html>
</richcontent>
<node TEXT="JUnit 5" ID="ID_1011862362" CREATED="1566913161556" MODIFIED="1567086213579"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Junit 5 Example
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      Assertions.assertEquals(0,
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;todoMVC.getTodoItems().size());
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      org.opentest4j.AssertionFailedError:
    </p>
    <p>
      Expected :0
    </p>
    <p>
      Actual&#160;&#160;&#160;:1
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Junit 4 and JUnit 5
    </p>
    <p>
      
    </p>
    <p>
      - Junit 4 `Assert.`
    </p>
    <p>
      - Junit 5 `Assertions.`
    </p>
    <p>
      - Hamcrest built in
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Hamcrest" ID="ID_663967326" CREATED="1566913166145" MODIFIED="1567086206910"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Hamcrest Example
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      assertThat(todoMVC.getTodoItems().size(), is(0));
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      java.lang.AssertionError:
    </p>
    <p>
      Expected: is &lt;0&gt;
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;but: was &lt;1&gt;
    </p>
    <p>
      Expected :is &lt;0&gt;
    </p>
    <p>
      Actual&#160;&#160;&#160;:&lt;1&gt;
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Hamcrest
    </p>
    <p>
      
    </p>
    <p>
      - english language syntax
    </p>
    <p>
      - static inclusion of 'is' etc.
    </p>
    <p>
      - More readable error messages than JUnit
    </p>
    <p>
      - http://hamcrest.org
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="AssertJ" ID="ID_1613596671" CREATED="1566913168980" MODIFIED="1567086203303"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # AssertJ Example
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      assertThat(todoMVC.getTodoItems().size()).isEqualTo(0);
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      org.opentest4j.AssertionFailedError:
    </p>
    <p>
      Expecting:
    </p>
    <p>
      &#160;&lt;1&gt;
    </p>
    <p>
      to be equal to:
    </p>
    <p>
      &#160;&lt;0&gt;
    </p>
    <p>
      but was not.
    </p>
    <p>
      Expected :0
    </p>
    <p>
      Actual&#160;&#160;&#160;:1
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # AssertJ
    </p>
    <p>
      
    </p>
    <p>
      - method chaining can make it easier to build assertions with less knowledge of the library
    </p>
    <p>
      - has SoftAssertions to allow multiple assertions 'fail' in test
    </p>
    <p>
      - has BDD style assertion `then`
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      todoMVC.editItem(0, &quot;Edited Todo&quot;);
    </p>
    <p>
      then(todoMVC.getTodoItems().size()).isEqualTo(1);
    </p>
    <p>
      ~~~~~~~~
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Pros and Cons" ID="ID_1429534060" CREATED="1567086229504" MODIFIED="1567086368330"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Assertion Library Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros?
    </p>
    <p>
      - Cons?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Assertion Library Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros
    </p>
    <p>
      &#160;&#160;&#160;- flexibility of how you want assertions to read
    </p>
    <p>
      &#160;&#160;&#160;- can improve on error understanding by using a different framework
    </p>
    <p>
      &#160;&#160;&#160;- different libraries can make assertions easier to write
    </p>
    <p>
      - Cons
    </p>
    <p>
      &#160;&#160;&#160;- might be harder to switch if existing tests
    </p>
    <p>
      &#160;&#160;&#160;- need to learn an Assertion library as well as an execution framework
    </p>
    <p>
      &#160;&#160;&#160;- soft asserts might encourage too many assertions in same test
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="Base Test" ID="ID_1459657629" CREATED="1567078933293" MODIFIED="1567861135461"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Base Test
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Base Test Case Example
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      public class BaseClassExampleTest
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;extends SeleniumBaseTestCase {
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;@Test
    </p>
    <p>
      &#160;&#160;&#160;&#160;public void canUseADefaultBrowser(){
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;final TodoMVCSite todoMVCSite = new TodoMVCSite();
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;driver().get(todoMVCSite.getURL());
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;Assertions.assertTrue(
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;driver().getTitle().contains(&quot;TodoMVC&quot;));
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      }
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Base Test Case
    </p>
    <p>
      
    </p>
    <p>
      - People often create a Base Test Case
    </p>
    <p>
      - And all tests extend the Base Test Case
    </p>
    <p>
      - This can create the browsers and supporting components/data
    </p>
    <p>
      
    </p>
    <p>
      _see basetest package_
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Base Test Case Pros &amp; Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros?
    </p>
    <p>
      - Cons?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Base Test Case Pros &amp; Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros
    </p>
    <p>
      &#160;&#160;&#160;- possibly less code to write in `@Test`
    </p>
    <p>
      &#160;&#160;&#160;- avoids boiler plate
    </p>
    <p>
      - Cons
    </p>
    <p>
      &#160;&#160;&#160;- might be hard to know what Best Test does
    </p>
    <p>
      &#160;&#160;&#160;- might not be possible to 'create a browser' or other setup without extending base test which might limit my testing.
    </p>
    <p>
      &#160;&#160;&#160;- base test case might setup more than it needs
    </p>
    <p>
      &#160;&#160;&#160;- what if we mix REST API and Web Usage in test, do we extend a RestAndWebTest?
    </p>
    <p>
      
    </p>
    <p>
      _Personal bias alert: I prefer not to use this, I prefer composition rather than inheritance._
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Browser Functionality" ID="ID_284574448" CREATED="1567078940988" MODIFIED="1567861144977"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Browser Functionality Abstractions
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Browser Functionality Abstractions
    </p>
    <p>
      
    </p>
    <p>
      - WebDriver itself is a browser abstraction
    </p>
    <p>
      - But it may not give us access to all the functionality e.g driver.manage gives access to cookies but not local storage
    </p>
    <p>
      - Using (JavaScriptExecutor) allows us access to anything that JS has access to, and that can include other features of the browser
    </p>
    <p>
      - We may also have to 'workaround' browser changes or nuances
    </p>
  </body>
</html>
</richcontent>
<node TEXT="e.g. Cookies" ID="ID_662445692" CREATED="1567078952845" MODIFIED="1567078970443"/>
<node TEXT="LocalStorage Example" ID="ID_1216241755" CREATED="1567078954961" MODIFIED="1567089343296"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Local Storage
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      public class Storage implements LocalStorage{
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;private final JavascriptExecutor js;
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;public Storage(JavascriptExecutor js){
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;this.js = js;
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;@Override
    </p>
    <p>
      &#160;&#160;&#160;&#160;public String getItem(String key) {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;return (String) js.executeScript( String.format(
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&quot;return window.localStorage.getItem('%s');&quot;, key));
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      //...
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Local Storage
    </p>
    <p>
      
    </p>
    <p>
      - WebDriver has a LocalStorage interface that isn't universally implemented
    </p>
    <p>
      - Implementing the Interface may make it easier to maintain longer term
    </p>
    <p>
      - Future versions of WebDriver and Browser Drivers might reduce need for this
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Local Storage Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros?
    </p>
    <p>
      - Cons?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Local Storage Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros
    </p>
    <p>
      &#160;&#160;&#160;- gain access to more than WebDriver provides
    </p>
    <p>
      - Cons
    </p>
    <p>
      &#160;&#160;&#160;- more code to maintain
    </p>
    <p>
      &#160;&#160;&#160;- risk of cross browser issues in our abstraction code
    </p>
    <p>
      &#160;&#160;&#160;- may require synchronisation
    </p>
    <p>
      &#160;&#160;&#160;- may be vulnerable to future security browser changes
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Workarounds" ID="ID_1947872151" CREATED="1567079018816" MODIFIED="1567089349213"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Workaround Example
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      public class EnsureWebElementIs {
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;public static void inViewOnThePage(
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;WebDriver driver,
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;WebElement todoListItem) {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;((JavascriptExecutor) driver).
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;executeScript(
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&quot;window.scrollTo(0,&quot; +
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;todoListItem.getLocation().getY() + &quot;)&quot;);
    </p>
    <p>
      &#160;&#160;&#160;&#160;}
    </p>
    <p>
      }
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Workarounds
    </p>
    <p>
      
    </p>
    <p>
      - often use JavaScript Executor
    </p>
    <p>
      - are often made unnecessary by WebDriver changes
    </p>
    <p>
      &#160;&#160;&#160;&#160;- e.g. now WebDriver scrolls elements in to view
    </p>
    <p>
      - can help mitigate driver changes e.g.
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      &#160;public static void closeDriver(WebDriver adriver){
    </p>
    <p>
      &#160;&#160;&#160;&#160;try {
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;adriver.close();
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;adriver.quit();
    </p>
    <p>
      &#160;&#160;&#160;&#160;}catch(Exception e){}
    </p>
    <p>
      }
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Workarounds Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros?
    </p>
    <p>
      - Cons?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Workarounds Pros and Cons
    </p>
    <p>
      
    </p>
    <p>
      - Pros
    </p>
    <p>
      &#160;&#160;&#160;- adding workarounds into abstraction layers keeps test running without impacting test code
    </p>
    <p>
      - Cons
    </p>
    <p>
      &#160;&#160;&#160;- people may not realise that we are using workaround and don't learn to debug flaky tests
    </p>
    <p>
      &#160;&#160;&#160;- people assume this is web driver functionality and can't work in other projects or companies
    </p>
    <p>
      &#160;&#160;&#160;- what if the test should fail, and workaround patches the system too much
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
</node>
<node TEXT="overview of others" POSITION="right" ID="ID_1397534437" CREATED="1566402297377" MODIFIED="1567861858276">
<edge COLOR="#00ffff"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Others
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Others
    </p>
    <p>
      
    </p>
    <p>
      - Base Page
    </p>
    <p>
      - JUnit 5 Selenium
    </p>
    <p>
      - Synchronisation Abstractions
    </p>
    <p>
      - Data Abstractions
    </p>
    <p>
      - Screenplay Pattern
    </p>
    <p>
      - Internal DSLs
    </p>
    <p>
      - Model Based Testing
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Others
    </p>
    <p>
      
    </p>
    <p>
      - Base Page - page all page objects inherit from
    </p>
    <p>
      - JUnit 5 Selenium - additional annotations to control and configure selenium
    </p>
    <p>
      - Synchronisation Abstractions - waiting classes, chaining waits, polling
    </p>
    <p>
      - Data Abstractions - random data, payload objects, property based, data driven
    </p>
    <p>
      - Screenplay Pattern - small actions vs pages
    </p>
    <p>
      - Internal DSLs - fluent and GWT like DSLs
    </p>
    <p>
      - Model Based Testing - a model traversed to automate
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
<node TEXT="JUnit 5 Selenium" ID="ID_403418987" CREATED="1566402300054" MODIFIED="1567861835058"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # JUnit 5 Selenium
    </p>
    <p>
      
    </p>
    <p>
      https://github.com/bonigarcia/selenium-jupiter
    </p>
    <p>
      
    </p>
    <p>
      ~~~~~~~~
    </p>
    <p>
      @ExtendWith(SeleniumExtension.class)
    </p>
    <p>
      public class ASeleniumTest {
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;@Test
    </p>
    <p>
      &#160;&#160;&#160;&#160;public void useChrome(ChromeDriver driver) {}
    </p>
    <p>
      
    </p>
    <p>
      &#160;&#160;&#160;&#160;@Test
    </p>
    <p>
      &#160;&#160;&#160;&#160;void useRemoteChrome(@DriverUrl(&quot;http://localhost:4444/wd/hub&quot;)
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;@DriverCapabilities(&quot;browserName=chrome&quot;)
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;RemoteWebDriver driver) {}
    </p>
    <p>
      ~~~~~~~~
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Synchronisation abstractions" ID="ID_1957556966" CREATED="1566402313239" MODIFIED="1566402319293"/>
<node TEXT="data abstractions" ID="ID_904282859" CREATED="1566402349082" MODIFIED="1566402352167"/>
<node TEXT="screenplay pattern" ID="ID_731555170" CREATED="1567860996970" MODIFIED="1567861804678"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Screenplay pattern
    </p>
    <p>
      
    </p>
    <p>
      - Actors
    </p>
    <p>
      - Roles
    </p>
    <p>
      - Tasks
    </p>
    <p>
      
    </p>
    <p>
      - https://serenity-js.org/design/screenplay-pattern.html
    </p>
    <p>
      - https://github.com/RiverGlide/screenplay-jvm
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="Exercise Automate Scenarios" POSITION="right" ID="ID_133417586" CREATED="1566209454977" MODIFIED="1567074899284"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Exercises
    </p>
    <p>
      
    </p>
    <p>
      - You control your focus.
    </p>
    <p>
      - what do you want to experiment with?
    </p>
    <p>
      - Model the application
    </p>
    <p>
      -&#160;Build abstraction layers to implement the model
    </p>
    <p>
      -&#160;Experiment with additional approaches mentioned that you haven't used
    </p>
    <p>
      -&#160;Use existing code and amend and experiment
    </p>
    <p>
      
    </p>
    <p>
      [github.com/eviltester/automationAbstractions](https://github.com/eviltester/automationAbstractions)
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Exercises
    </p>
    <p>
      
    </p>
    <p>
      - look at the 'examples' package, run tests, experiment
    </p>
    <p>
      - use the 'todos' view in IntelliJ, pick and choose some exercises
    </p>
    <p>
      - use the Case Studies as a basis to start from - refactor and expand
    </p>
    <p>
      - Start from scratch (Automate Scenarios):
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Create a ToDo (check: count, text)
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Can Delete a ToDo (check: footers, count)
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Can Mark a ToDo as completed
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Can create a bunch of ToDos and delete, mark as complete etc.
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;_Add additional checks as required_
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;_Create Abstraction layers as appropriate_
    </p>
    <p>
      
    </p>
    <p>
      [github.com/eviltester/automationAbstractions](https://github.com/eviltester/automationAbstractions)
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
<edge COLOR="#00007c"/>
</node>
<node TEXT="Debriefs" POSITION="right" ID="ID_611543841" CREATED="1566213038959" MODIFIED="1567074770151">
<edge COLOR="#7c007c"/>
<richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Additional Debrief
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Did anyone do anything different?
    </p>
    <p>
      *&#160;&#160;&#160;Any other abstraction approaches you used?
    </p>
    <p>
      *&#160;&#160;&#160;Anything else to add?
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Biases and Decisions" POSITION="right" ID="ID_1362520469" CREATED="1566213058220" MODIFIED="1566213061731">
<edge COLOR="#007c7c"/>
<node TEXT="Biases" ID="ID_150784881" CREATED="1566213093724" MODIFIED="1567075056092"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Are there rights and wrongs?
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Right / Wrong?
    </p>
    <p>
      *&#160;&#160;&#160;Decisions?
    </p>
    <p>
      *&#160;&#160;&#160;Project/Team/Organisation Standards?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Biases &amp; Preferences
    </p>
    <p>
      
    </p>
    <p>
      - Not about &quot;Right&quot; and &quot;Wrong&quot;
    </p>
    <p>
      - Those are 'fixed' viewpoints
    </p>
    <p>
      
    </p>
    <p>
      Instead:
    </p>
    <p>
      
    </p>
    <p>
      - agreed approach because...
    </p>
    <p>
      - we decided on X, because...
    </p>
    <p>
      - abstractions and models change and flex
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # My bias model has Driver as core
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;Driver
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Build around that so instantiate any page or component as required at any time
    </p>
    <p>
      *&#160;&#160;&#160;Synchronisation
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;To make sure that the desired object is available and ready for use (as defined by synchronisation)
    </p>
    <p>
      *&#160;&#160;&#160;Navigation
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Implicit (via actions)
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Explicit
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;*&#160;&#160;&#160;Open/jump (via driver.get)
    </p>
    <p>
      &#160;&#160;&#160;&#160;&#160;&#160;&#160;&#160;*&#160;&#160;&#160;To (state model from current, to desired)
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Biases
    </p>
    <p>
      
    </p>
    <p>
      *&#160;Examine some common abstraction biases
    </p>
    <p>
      * Discuss pros/cons based on experience
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Decisions" ID="ID_387254756" CREATED="1566213096133" MODIFIED="1567085492609"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Should we add asserts into abstraction layers?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Should Page Objects consume and return domain objects?
    </p>
    <p>
      
    </p>
    <p>
      e.g.
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;loginAs(user)
    </p>
    <p>
      *&#160;&#160;&#160;List&lt;User&gt; getUsersList()
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Should Page Objects return WebElements?
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Some Decision Considerations
    </p>
    <p>
      
    </p>
    <p>
      *&#160;&#160;&#160;The 'limits' and overlap of Abstraction Layers
    </p>
    <p>
      *&#160;&#160;&#160;Build it now, or 'refactor to' later
    </p>
    <p>
      *&#160;&#160;&#160;How much change is anticipated?
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;To which layer? GUI, Business domain, Workflow?
    </p>
    <p>
      *&#160;&#160;&#160;Who is working with the automation code?
    </p>
    <p>
      &#160;&#160;&#160;&#160;*&#160;&#160;&#160;Skill levels? Support needed?
    </p>
    <p>
      *&#160;&#160;&#160;How/When with the automation execute?
    </p>
    <p>
      
    </p>
  </body>
</html>
</richcontent>
</node>
<node TEXT="Robert Anton Wilson Quote" ID="ID_924385427" CREATED="1566213113796" MODIFIED="1567075092053"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # &#8220;To the creative mind there is no right or wrong. Every action is an experiment, and every experiment yields its fruit in knowledge.&#8221;
    </p>
    <p>
      
    </p>
    <p>
      ## The Illuminatus Trilogy
    </p>
    <p>
      
    </p>
    <p>
      ## Robert Anton Wilson
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="Closing Slides" POSITION="right" ID="ID_916996601" CREATED="1567075160804" MODIFIED="1567075165621">
<edge COLOR="#007c00"/>
<node TEXT="About Alan" ID="ID_755749989" CREATED="1567075587094" MODIFIED="1567075720376"><richcontent TYPE="NOTE">

<html>
  <head>
    
  </head>
  <body>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # End Credits
    </p>
    <p>
      
    </p>
    <p>
      * [www.eviltester.com](http://www.eviltester.com)
    </p>
    <p>
      * [@eviltester](https://twitter.com/eviltester)
    </p>
    <p>
      * [www.youtube.com/user/EviltesterVideos](https://www.youtube.com/user/EviltesterVideos)
    </p>
    <p>
      * [www.compendiumdev.co.uk](http://www.compendiumdev.co.uk)
    </p>
    <p>
      * [uk.linkedin.com/in/eviltester](http://uk.linkedin.com/in/eviltester)
    </p>
    <p>
      
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      ## Follow
    </p>
    <p>
      
    </p>
    <p>
      - Linkedin - [@eviltester](https://uk.linkedin.com/in/eviltester)
    </p>
    <p>
      - Twitter - [@eviltester](https://twitter.com/eviltester)
    </p>
    <p>
      - Youtube - [EvilTesterVideos](https://www.youtube.com/user/EviltesterVideos)
    </p>
    <p>
      - Instagram - [@eviltester](https://www.instagram.com/eviltester)
    </p>
    <p>
      - Github - [@eviltester](https://github.com/eviltester/)
    </p>
    <p>
      - Slideshare - [@eviltester](www.slideshare.net/eviltester)
    </p>
    <p>
      - Facebook - [@eviltester](https://facebook.com/eviltester/)
    </p>
    <p>
      - Pinterest - [@eviltester](https://uk.pinterest.com/eviltester/)
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      ## BIO
    </p>
    <p>
      &#160;
    </p>
    <p>
      Alan is a test consultant who enjoys testing at a technical level using techniques from psychotherapy and computer science. In his spare time Alan is currently programming a [multi-user text adventure game](http://compendiumdev.co.uk/page/restmud) and some [buggy JavaScript games](http://compendiumdev.co.uk/games/buggygames/) in the style of the Cascade Cassette 50. Alan is the author of the books &quot;[Dear Evil Tester](http://www.eviltester.com/page/dearEvilTester/)&quot;, &quot;[Java For Testers](http://javafortesters.com/page/about/)&quot; and &quot;[Automating and Testing a REST API](http://compendiumdev.co.uk/page/tracksrestapibook)&quot;.
    </p>
    <p>
      
    </p>
    <p>
      ---
    </p>
    <p>
      
    </p>
    <p>
      # Visit EvilTester.com
    </p>
    <p>
      
    </p>
    <p>
      Alan's main website is [www.eviltester.com](http://www.eviltester.com) and he blogs at [blog.eviltester.com](http://blog.eviltester.com)
    </p>
  </body>
</html>
</richcontent>
</node>
</node>
<node TEXT="to add in summary form only,&#xa;not in code" FOLDED="true" POSITION="left" ID="ID_691608577" CREATED="1565878905018" MODIFIED="1566402376916">
<edge COLOR="#00ffff"/>
<node TEXT="JUnit 5 Selenium Abstractions" ID="ID_907417134" CREATED="1565878908666" MODIFIED="1565878915037">
<node TEXT="https://bonigarcia.github.io/selenium-jupiter/#using-options" ID="ID_699091992" CREATED="1566402220628" MODIFIED="1566402222025"/>
<node TEXT="seems a bit complex and more like a framework" ID="ID_646811745" CREATED="1566402223035" MODIFIED="1566402247562"/>
<node TEXT="add to an ecosystem training" ID="ID_1910650351" CREATED="1566402249135" MODIFIED="1566402258205"/>
</node>
<node TEXT="Synchronisation Abstractions" ID="ID_1433256129" CREATED="1565878915754" MODIFIED="1565878922124">
<node TEXT="Waiter" ID="ID_734426801" CREATED="1565878968090" MODIFIED="1565878973693"/>
</node>
<node TEXT="Common Abstraction Patterns" ID="ID_1436231956" CREATED="1565879100504" MODIFIED="1565879106737"/>
<node TEXT="mixing automated domains" ID="ID_644270078" CREATED="1567007649594" MODIFIED="1567007659182">
<node TEXT="rest/http and GUI" ID="ID_181889749" CREATED="1567007660080" MODIFIED="1567007665819"/>
</node>
<node TEXT="Model Based Testing" ID="ID_1577645440" CREATED="1566899886226" MODIFIED="1566899899121">
<node TEXT="Data Driven" ID="ID_269115746" CREATED="1566899899545" MODIFIED="1566899903755">
<node TEXT="JUnit 5" ID="ID_304257567" CREATED="1566899904091" MODIFIED="1566899906906"/>
<node TEXT="Cucumber Examples" ID="ID_1530048405" CREATED="1566899907331" MODIFIED="1566899910236"/>
<node TEXT="Property Based" ID="ID_13990182" CREATED="1566899917749" MODIFIED="1566899920699"/>
</node>
<node TEXT="Model Based Test Execution" ID="ID_325072291" CREATED="1566899957327" MODIFIED="1566899965136"/>
</node>
</node>
<node TEXT="to change" FOLDED="true" POSITION="left" ID="ID_97081246" CREATED="1565881652366" MODIFIED="1565881655180">
<edge COLOR="#7c0000"/>
<node TEXT="we want simple examples" ID="ID_1612583215" CREATED="1565881655538" MODIFIED="1565881661998">
<node TEXT="for each concept" ID="ID_1068255060" CREATED="1566213211424" MODIFIED="1566213215520">
<node TEXT="Simple tests with no abstractions" ID="ID_479335404" CREATED="1566224509812" MODIFIED="1566224524302">
<icon BUILTIN="button_ok"/>
</node>
<node TEXT="infrastructure" ID="ID_1659737801" CREATED="1566223398028" MODIFIED="1566382325028">
<icon BUILTIN="button_ok"/>
<node TEXT="maven" ID="ID_1087970295" CREATED="1566223405857" MODIFIED="1566223422022">
<icon BUILTIN="button_ok"/>
</node>
<node TEXT="webdriver manager" ID="ID_335328298" CREATED="1566223407906" MODIFIED="1566223424248">
<icon BUILTIN="button_ok"/>
</node>
</node>
<node TEXT="Driver Abstractions" FOLDED="true" ID="ID_173289347" CREATED="1566223521982" MODIFIED="1566382322441">
<icon BUILTIN="button_ok"/>
<node TEXT="Driver Control Abstractions" ID="ID_1307247320" CREATED="1566309060887" MODIFIED="1566312048812">
<icon BUILTIN="button_ok"/>
</node>
<node TEXT="static access" ID="ID_1760488135" CREATED="1566381372753" MODIFIED="1566381378118">
<icon BUILTIN="button_ok"/>
</node>
</node>
<node TEXT="Environment Abstractions" ID="ID_197798327" CREATED="1566223532017" MODIFIED="1566380211774">
<icon BUILTIN="button_ok"/>
</node>
<node TEXT="POJO Page Object" ID="ID_1073730665" CREATED="1566213220694" MODIFIED="1566396322198">
<icon BUILTIN="button_ok"/>
<node TEXT="examples.pojo" LOCALIZED_STYLE_REF="default" ID="ID_1374889004" CREATED="1566309105483" MODIFIED="1566396313259">
<icon BUILTIN="button_ok"/>
</node>
</node>
<node TEXT="Page Factory Page Objects" ID="ID_717282" CREATED="1566381536196" MODIFIED="1566396325072">
<icon BUILTIN="button_ok"/>
<node TEXT="Annotations" ID="ID_43297789" CREATED="1566381546906" MODIFIED="1566396330060">
<icon BUILTIN="button_ok"/>
</node>
<node TEXT="Annotations Page Object" ID="ID_484622452" CREATED="1566213227175" MODIFIED="1566396328080">
<icon BUILTIN="button_ok"/>
</node>
</node>
<node TEXT="Component Abstractions" ID="ID_600674258" CREATED="1566381567921" MODIFIED="1566381571748">
<node TEXT="Slow Loadable Component" ID="ID_757780246" CREATED="1566381549584" MODIFIED="1566400875604">
<icon BUILTIN="button_ok"/>
</node>
<node TEXT="pojo" ID="ID_430162569" CREATED="1566396425159" MODIFIED="1566399337278">
<icon BUILTIN="button_ok"/>
</node>
</node>
<node TEXT="Element Abstraction" ID="ID_65018542" CREATED="1566217837588" MODIFIED="1566381384561">
<icon BUILTIN="button_ok"/>
</node>
<node TEXT="base test class" ID="ID_1107892158" CREATED="1566309284000" MODIFIED="1566405051291">
<icon BUILTIN="button_ok"/>
</node>
<node TEXT="Navigation Objects" ID="ID_991361496" CREATED="1566381622349" MODIFIED="1566479535567">
<icon BUILTIN="button_ok"/>
</node>
<node TEXT="Fluent Page Objects" ID="ID_1148984870" CREATED="1566381616027" MODIFIED="1566484990574">
<icon BUILTIN="button_ok"/>
</node>
<node TEXT="WebDriver Support Abstractions" FOLDED="true" ID="ID_783464204" CREATED="1566385642253" MODIFIED="1566487375306">
<icon BUILTIN="button_ok"/>
<node TEXT="scrollintoview" ID="ID_599321778" CREATED="1566385648620" MODIFIED="1566487372674">
<icon BUILTIN="button_ok"/>
</node>
<node TEXT="mouse move" ID="ID_684097078" CREATED="1566487365489" MODIFIED="1566487370686">
<icon BUILTIN="button_ok"/>
</node>
</node>
<node TEXT="Domain Abstractions" ID="ID_1922258489" CREATED="1566381632746" MODIFIED="1566820217961">
<icon BUILTIN="button_ok"/>
<node TEXT="Data Classes" ID="ID_1088348004" CREATED="1566381636817" MODIFIED="1566820131190">
<icon BUILTIN="button_ok"/>
<node TEXT="UserDetails" ID="ID_672786905" CREATED="1566381659250" MODIFIED="1566381676600"/>
</node>
<node TEXT="Interaction Classes" FOLDED="true" ID="ID_537361758" CREATED="1566381644243" MODIFIED="1566820134470">
<icon BUILTIN="button_ok"/>
<node TEXT="User" ID="ID_826477307" CREATED="1566381654660" MODIFIED="1566813487410"/>
</node>
<node TEXT="data abstractions" ID="ID_1255308864" CREATED="1565957785327" MODIFIED="1566820156656">
<icon BUILTIN="button_ok"/>
<node TEXT="random data" ID="ID_1367911538" CREATED="1565957790323" MODIFIED="1565957792529"/>
<node TEXT="random data creation" ID="ID_1351698836" CREATED="1565957799751" MODIFIED="1565957803914"/>
<node TEXT="seeding random data" ID="ID_1094913173" CREATED="1565957805105" MODIFIED="1565957819754"/>
<node TEXT="logging random data" ID="ID_1523528717" CREATED="1565957810911" MODIFIED="1565957813747"/>
</node>
</node>
<node TEXT="structural vs functional page objects" ID="ID_245775758" CREATED="1566484992939" MODIFIED="1566913189398">
<icon BUILTIN="button_ok"/>
</node>
<node TEXT="Assertion Abstractions" ID="ID_998786816" CREATED="1565878977742" MODIFIED="1566913179063">
<icon BUILTIN="button_ok"/>
<node TEXT="Junit 5" ID="ID_1341364154" CREATED="1566899880799" MODIFIED="1566913181879">
<icon BUILTIN="button_ok"/>
</node>
<node TEXT="HamCrest" ID="ID_1192562776" CREATED="1565878982602" MODIFIED="1566913184256">
<icon BUILTIN="button_ok"/>
</node>
<node TEXT="AssertJ" ID="ID_873624729" CREATED="1565878986247" MODIFIED="1566913186968">
<icon BUILTIN="button_ok"/>
</node>
</node>
<node TEXT="Using Coverage of Test code" ID="ID_5083326" CREATED="1566902141610" MODIFIED="1566903704987">
<icon BUILTIN="button_ok"/>
<node TEXT="in intellij need to change configuration of the coverage tab to include test code" ID="ID_449759533" CREATED="1566902150857" MODIFIED="1566903712943">
<icon BUILTIN="button_ok"/>
</node>
<node TEXT="useful to see if any potential risks in the abstraction layers i.e. unused code might not work and might interfere with next person to use the abstraction library" ID="ID_1689877757" CREATED="1566902179793" MODIFIED="1566903715433">
<icon BUILTIN="button_ok"/>
</node>
</node>
</node>
</node>
<node TEXT="Case study based examples for longer exercises" ID="ID_1644293234" CREATED="1566381694216" MODIFIED="1566381702880">
<node TEXT="tests without any abstractions&#xa;to allow refactoring to classes" ID="ID_1217189162" CREATED="1566217260934" MODIFIED="1566381716244">
<node TEXT="Create" ID="ID_1980290252" CREATED="1566217269778" MODIFIED="1566217272074"/>
<node TEXT="Read" ID="ID_1709666151" CREATED="1566217273040" MODIFIED="1566217275426"/>
<node TEXT="Update" ID="ID_1994322400" CREATED="1566217276347" MODIFIED="1566217277811"/>
<node TEXT="Delete" ID="ID_578010498" CREATED="1566217278553" MODIFIED="1566217280196"/>
</node>
<node TEXT="refactoring to page objects from tests" ID="ID_1549086314" CREATED="1566217144405" MODIFIED="1566217151652"/>
<node TEXT="refactor to local high level DSL abstractions" ID="ID_926610554" CREATED="1566217155161" MODIFIED="1566217175143"/>
</node>
<node TEXT="todo" ID="ID_533208806" CREATED="1566381415504" MODIFIED="1566381419061">
<node TEXT="re-name packages in examples to order into presentation order" ID="ID_227620519" CREATED="1566381419555" MODIFIED="1566381458286"/>
<node TEXT="add more exercises" ID="ID_595617723" CREATED="1566309120872" MODIFIED="1566309124970"/>
<node TEXT="add more comments in code explaining concepts" ID="ID_34551238" CREATED="1566382353520" MODIFIED="1566382361374"/>
</node>
<node TEXT="we want lots of exercises" ID="ID_921874703" CREATED="1565881664336" MODIFIED="1565881668838">
<node TEXT="with many examples to refactor" ID="ID_947520878" CREATED="1565882885162" MODIFIED="1565882891601"/>
<node TEXT="refactor abstractions into the &apos;main&apos; directory" ID="ID_544483195" CREATED="1566217647304" MODIFIED="1566217665755"/>
<node TEXT="suggested component abstractions to create" ID="ID_830996931" CREATED="1566217845509" MODIFIED="1566217902817">
<node TEXT="edit input field" ID="ID_1616070246" CREATED="1566217854553" MODIFIED="1566217862002"/>
<node TEXT="create input field" ID="ID_896590762" CREATED="1566217876019" MODIFIED="1566217881960"/>
</node>
</node>
<node TEXT="case studies" ID="ID_111814631" CREATED="1566224532133" MODIFIED="1566224536769">
<node TEXT="possibly as separate projects" ID="ID_1202826354" CREATED="1566382372149" MODIFIED="1566382377351"/>
</node>
</node>
<node TEXT="refactoring concepts" FOLDED="true" POSITION="left" ID="ID_1552653632" CREATED="1566220243396" MODIFIED="1566220247695">
<edge COLOR="#0000ff"/>
<node TEXT="to local method in test" ID="ID_1502091600" CREATED="1566220248729" MODIFIED="1566220253567"/>
<node TEXT="to page object" ID="ID_455858736" CREATED="1566220259844" MODIFIED="1566220263354"/>
<node TEXT="inline refactoring to remove methods from objects" ID="ID_1023612167" CREATED="1566220264006" MODIFIED="1566220271477"/>
</node>
</node>
</map>
