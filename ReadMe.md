<h3>Welcome to my project!</h3>

This is Java+Maven framework project, which was created using Page Object model.
For the test execution was used https://www.saucedemo.com/ page.

During test execution was used following methods: Test, Before Method, Before Class, AfterClass.
Also was used Data Provider.

<h5>Here are all 5 test scenarios:</h5>

<h6>First test</h6>
1. Open page 'https://www.saucedemo.com/'
2. Sign in as standard_user (make a separate method or before class)
3. Log how many items are showing
4. Close browser

<h6>Second test</h6>
1. Open page 'https://www.saucedemo.com/'
2. Sign in as standard_user (make a separate method or before class)
3. In field Name (A to Z), select Price low to high
4. Log a screenshot
5. Close browser

<h6>Third test</h6>
1. Open page 'https://www.saucedemo.com/'
2. Sign in as standard_user (make a separate method or before class)
3. Log each item title
4. Close browser

<h6>Fourth test</h6>
1. Open page 'https://www.saucedemo.com/'
2. Sign in as standard_user (make a separate method or before class)
3. Open any product
4. Add to cart the product
5. Open cart and proceed to checkout
6. Enter the necessary information*
7. Finish the order
8. Validate that the order was sent
9. Log a screenshot
10. Close browser
    *Test runs with different data set (Firstname, Lastname and Zip code)

<h6>Fifth test</h6>
1. Open page 'https://www.saucedemo.com/'
2. Sign in as standard_user (make a separate method or before class)
3. Add any product to cart
4. Open that product
5. Remove the product
6. Open the cart
7. Validate that the cart is empty
8. Log a screenshot
9. Close browser

<h3>Maven</h3>

<h6>What is Maven?</h6>

Maven is build tool that is implemented in Java. 
It gives opportunity to execute tests using Maven terminal command line tool.

<h5>Maven command line tool</h5>

<h6>How to check Maven version?</h6>

Use the following Maven command from the command line:
- mvn -version
It will show up the version of Maven you are running.

<h6>How to run Maven project?</h6>

Use the following Maven command from the command line:
- mvn test
It will run all the unit tests found in the project.

<h6>How to run one specific test class?</h6>

Use the following Maven command from the command line:
- mvn test -Dtest=”TestClassName”
It will run some specific test class in the project.

<h6>How to run one specific test in class?</h6>

Use the following Maven command from the command line:
- mvn test -Dtest="TestClassName.testMethod"
It will run some specific test in the project class.

<h6>How to run all ‘Regression tests'?</h6>

Use the following Maven command from the command line:
- mvn test -Dgroups=Regression
It will run all regression tests found in the project.

<h6>How to exclude tests from execution?</h6>

3 ways how to exclude tests from execution:
1. By entering following command in Maven command line tool: mvn install -DskipTests.
It will run simple build without any tests.
2. By adding configuration:
\<configuration>
   \<skipTests>true\</skipTests>
\</configuration>,
in Maven Surefire Plugin.
3. By using maven.test.skip property. Example:
\<properties>
   \<maven.test.skip>true</maven.test.skip>
\</properties>
It can be used with Surefire, Failsafe and the Compiler Plugin.




