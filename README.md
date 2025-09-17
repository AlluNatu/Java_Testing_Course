# CT60A4160 Ohjelmistotestauksen periaatteet

This is repository for my course I completed in LUT University while doing my Bachelors Degree in Software Engineering.

This is for my course I did (LUT University) CT60A4160 Ohjelmistotestauksen periaatteet (Principles of Software Testing). Which is worth 3 ECTS.

## Learning objectives

After completing the course, I am able to:

    1. explain the key concepts and principles of software testing
    2. perform software testing at unit, integration, and system levels
    3. use basic tools for testing and automate testing tasks
    4. work as a tester in a testing team.

## Course content

    - Software testing techniques
    - Levels
    - Automation
    - Tools
    - Working as a tester in a testing team.

## Grading

I got graded with a grade 5, from my Universitys grading scale 1-5.


# Assignment descriptions

## Week 1
BMI Calculator  
The task is to create a functional Body Mass Index (BMI) calculator based on the provided unit tests. The program should behave as described by the unit tests. The unit tests use JUnit, with more information available at [JUnit User Guide](https://junit.org/junit5/docs/current/user-guide/). In-depth knowledge of JUnit is not required for this task. You can find more detailed information about BMI, including the formula and categories, for example, in the Wikipedia article.

It is possible to earn 0, 1, or 2 points depending on the scope of the implementation.

The unit tests required for the task are available in the `.zip` file below.

**1 point**

Implement the functions based on the tests in the `TestCalc1.java` file. Please note that the BMI calculator rounds the result to **one decimal place** when calculating the BMI.

**2 points**

Extend the program based on the tests in the `Testcalc2p.java` file.

## Week 2

**Your Unit Tests**

In this task, you will create your own simple unit tests for the pre-implemented `Animal` class (note: do not modify the code inside the `Animal` class itself). The class code is available for download via the link at the bottom of this page. Implement the unit tests based on the descriptions below and follow the instructions as closely as possible to ensure the Codegrade tests pass successfully. In addition to the descriptions, follow these rules in your tests:

- The name of the variable for the expected value in the test must be `expected`.
- The name of the variable for the actual value in the test must be `actual`.
- Each test should utilize JUnit's `assertEquals` method. However, JUnit also provides many other assertions, which can be found, for example, in the JUnit 5 user guide.
- Ensure that the variables are passed to the assertion method in the correct order.
- If the test does not pass in Codegrade, pay special attention to the structure of the test. Small structural changes can impact whether the test passes.

You can earn 0, 1, or 2 points depending on the scope of your implementation.

**1 Point**

First, test the correct functionality of the getters in the `Animal` class with simple tests. Create the tests `testAnimalGetAge` and `testAnimalGetName`, which are meant to verify whether the class getters return the corresponding values as expected. In these tests, use JUnit's `assertEquals` method.

Next, test the `shout` method of the `Animal` class, which should return the animal's characteristic shout when called. Create a test `testAnimalShout` and again use the `assertEquals` method to ensure the correctness of the returned value.

**2 Points**

What if an unrealistic or impossible age is given when creating the animal? Create a test `testAnimalInvalidAge`, which tests the behavior of the class when the animal is assigned an unrealistic age.

When creating an animal, the default assumption is that each animal must have a name. Create a test `testAnimalInvalidName`, which ensures that the animal has a name, regardless of whether a proper name was given when creating the animal.

## Week 3

**Unit Testing for the Online Store**

In this task, the goal is to create unit tests for a program simulating an online store. The unit tests will be run in Codegrade using the provided sample implementation (downloadable from the link at the bottom of the page), and your tests must pass with this implementation. Additionally, the tests will be run against a faulty implementation deliberately embedded with errors. For each test that passes with the "correct" implementation but fails with the faulty one, you will earn a point in Codegrade. The aim is to identify errors in the code through your tests. There are plenty of errors embedded, so you should be able to achieve the maximum score.

**Relevant Files:**
- `Cart.java`
- `CartItem.java`
- `Item.java`
- `Store.java`
- `User.java`

These files are located in the project root under `src/main/java/com/example/...` and contain the source code for the program on which you need to base your unit tests. Additionally, you can test the program’s functionality by running it via the `App.java` class if desired.

You can create unit tests directly in the Codegrade editor or alternatively place your tests in the `AppTest.java` file found in the `src/test/java/com/example` directory of the sample project and run them via Maven (though this may require some environment configuration).

**Note:** Aim to create high-quality tests. Test different methods and their behavior in clearly distinct scenarios. A high-quality test does not just test the same thing with slightly different inputs, but tests different methods and edge cases separately. Tests that check the same method with correct and incorrect inputs separately are acceptable. Remember, the goal is to identify errors in the faulty implementation. If tests are too similar and check the same thing repeatedly, points may be deducted from the final score.

**Tips for the Task:**

- Although you cannot directly see what errors have been introduced, a good approach is to read the comments preceding each method, which describe the intended functionality. Errors are likely to violate these method specifications.
- Use more than just `assertEquals` in your tests. For example, look into `assertTrue` / `assertFalse`, `assertThrows` / `assertDoesNotThrow`.
- Avoid testing getters and setters. The errors are more likely to be found in methods that contribute more to the program’s functionality.

## Week 4

**Library Program Code Coverage Testing**

Code coverage measures how well the created tests cover the source code. It can be evaluated using various criteria, such as:

- **Function / Method Coverage:** Measures the percentage of methods/functions executed.
- **Statement Coverage:** Measures the percentage of executed statements in the code.
- **Branch Coverage:** Measures the percentage of possible branches in the source code covered by tests, such as different branches in `if` statements.

**Task:**
Create tests using JUnit for the attached library program and aim to achieve the highest possible code coverage. The program includes `Book` and `Library` classes that are part of the functionality. As in task 3-2, the files can be found at `src/main/java/com/example`. You can also test the program's functionality via the `App.java` class.

Tests can be implemented directly in the Codegrade editor or as part of the provided project. However, it is recommended to run the tests through Codegrade to ensure the code coverage of your tests. If you submit the assignment as a separate file, name it `AppTest.java` and do not include package declarations at the time of submission.

**Codegrade Code Coverage Example:**
1. Overall coverage of tests. Scoring is based on this value.
2. Coverage achieved for each class.
3. Individual method coverage for each class. Methods that are not tested will be marked with ⛒.

**Scoring Criteria:**

- **0 Points:** Total coverage of the implemented tests is < 70%.
- **1 Point:** Total coverage is >= 70%.
- **2 Points:** Total coverage is >= 99%.

Achieving complete code coverage can be challenging, but it is reasonably attainable for this task.

## Week 5

**Creating Test Stubs**

In this task, you need to create test stubs for the attached program. Similar to tasks from weeks 1-2, the goal is to get the already implemented unit tests to pass. All modifications should be made in the `DatabaseStub` class.

**Program Structure:**

- **AppTest:** Contains pre-written tests that will not pass without your test stubs. You will earn points in Codegrade for each test that passes.
- **StudentRegister:** The `DatabaseStub` class is used through the `StudentRegister` class. This class should not be modified.
- **DatabaseStub:** This is the class you are responsible for implementing. The implementation of the test stubs is up to you, and the goal is to make sure the unit tests pass successfully.

**Submission Instructions:**

- Submit only the modified `DatabaseStub` class to Codegrade.
- Do not include any package declarations in the submission.

**Scoring:**

- **0 Points:** If the implemented `DatabaseStub` does not make any of the tests pass.
- **1 Point:** If the implemented `DatabaseStub` makes some of the tests pass.
- **2 Points:** If the implemented `DatabaseStub` makes all of the tests pass.

**Approach to Implementing the Test Stubs:**

1. **Understand the Tests:** Start by reviewing the `AppTest` class to understand what tests are in place and what functionality is expected from `DatabaseStub`.

2. **Implement Stubs:** Implement the `DatabaseStub` class methods so that they return appropriate values or behavior that allows the existing tests to pass. Test stubs generally provide controlled responses to method calls and are often used to simulate the behavior of real components.

3. **Test Thoroughly:** Ensure that your stubs cover all the necessary scenarios required by the unit tests. If a test fails, review the test case and adjust the stub implementation as needed.

By following these steps, you can ensure that the `DatabaseStub` class is correctly implemented and that the tests in `AppTest` pass successfully.

## Week 6

**Bug Detection and Fixing**

Your task is to find and fix bugs in the attached program. In Task 5-3, bugs were found using black-box testing. In this task, you can also search for bugs by running the program through the `App.java` class and verifying the program’s functionality with different inputs, but you can also find errors directly in the code by inspecting the program code.

Focus on the most critical bugs during testing and fixing. Depending on interpretation, there may be more bugs, but Codegrade checks whether the clearest and most unambiguous errors have been fixed. Codegrade also provides hints for different bugs as follows:

**Codegrade Bug Hints**

There are a total of 6 bugs, and to achieve full points, you need to fix 5 of these bugs. You can use the hints provided by Codegrade to locate the bugs, but all bugs can be found by running the program. All code changes should be made to the methods in the `Calculator` class.

Fix the bugs by modifying the internal logic of the methods, but do not change the method signatures. For example, if a method is specified to return a `float`, it should also return a `float` value in the fixed version.

As in previous tasks, the submission can be made directly in the Codegrade editor or as a separate file. If you submit a separate file, ensure that it does not include package declarations and only submit the `Calculator.java` file.

**Program Function Description**

When implemented correctly, the attached program calculates the average of the whole numbers (grades) entered by the user. The user can input grades ranging from 4 to 10 and end the input by entering 0 as the next grade. Only valid grades are added to the list of grades. After inputting the grades, the program calculates the average of the grades in float format and returns it to the user. An example run could be as follows (the calculated average on the last line):

This program calculates the average of school grades (4-10). Input number, press enter. Zero (0) ends the input.
1: 
5
2: 
7
3: 
0
6.0
