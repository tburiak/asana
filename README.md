# Playwright Test Suite for Asana

## Introduction

The purpose of this project was to develop an automated test suite using **Java**, **Playwright**, **JUnit**, and **Gradle** to validate key functionalities within the Asana application. The focus was on ensuring a scalable, data-driven approach that minimizes code duplication while providing robust testing for dynamic test cases.

The test cases included verifying the presence of specific tasks and their associated tags within designated columns across two projects: **Cross-functional project plan** and **Work Requests**. Test data was dynamically loaded from a JSON file, enabling flexible updates and improved maintainability.

---

## Implementation Details

### Solution Overview

The solution was built as a modular framework with the following components:

- **Playwright for Browser Automation**:
    - Used to interact with the Asana web application via Chromium.
    - Included login automation and navigation functionality.

- **JUnit for Test Execution**:
    - Managed test lifecycle and dynamic test case generation.
    - Enabled structured assertions for validating tasks and tags.

- **Data-Driven Testing**:
    - Test data was stored in a JSON file and loaded dynamically using **Gson**.
    - This eliminated hardcoding of test inputs, ensuring easy scalability.

- **Gradle for Build and Dependency Management**:
    - Simplified dependency configuration and test execution.

### Key Components

1. **Project Structure**:
    - `src/main/java/org/tbur`: Core utilities, JSON parsing, and Page Object Model (POM).
    - `src/test/java/ui`: Playwright setup and test case implementations.
    - `src/test/resources`: JSON file containing test data.

2. **Utilities**:
    - **BaseTest**: Managed browser initialization, page creation, and teardown.
    - **TestDataLoader**: Parsed JSON data into Java objects for use in test cases.
    - **StringUtils**: Provided a static utility method for string manipulation.

3. **Optimized Task Verification Method**:
    - Efficiently verified tasks and associated tags within specified columns.

4. **Dynamic Test Generation**:
    - Used JUnit’s `DynamicTest` to generate test cases programmatically based on JSON input.

---

## Challenges and Solutions

### Challenges

1. **Test Data Management**:
    - Hardcoding test cases led to difficulties in scaling and maintaining the suite.
    - **Solution**: Implemented a JSON-based data-driven approach for easy updates.

2. **Debugging Failures**:
    - Missing tasks or tags were difficult to debug with generic error messages.
    - **Solution**: Enhanced assertions with detailed, context-specific error messages.

3. **Login Workflow**:
    - Occasional timeout issues during login due to page load delays.
    - **Solution**: Introduced Playwright’s `waitForNavigation` to ensure the page fully loads before proceeding.

---

## Results

### Test Execution

The test suite included six test cases:

1. **Cross-functional project plan**:
    - Verified tasks: `Draft project brief`, `Schedule kickoff meeting`, `Share timeline with teammates`.

2. **Work Requests**:
    - Verified tasks: `Laptop setup for new hire`, `Password not working`, `New keycard for Daniela V`.

### Outcome Summary

| Test Case ID | Description                                                 | Result  |
|--------------|-------------------------------------------------------------|---------|
| TC1          | Verify `Draft project brief` with tags in `To do` column    | Passed  |
| TC2          | Verify `Schedule kickoff meeting` with tags in `To do` column | Passed  |
| TC3          | Verify `Share timeline with teammates` with tags in `To do` column | Passed  |
| TC4          | Verify `Laptop setup for new hire` with tags in `New Requests` column | Passed  |
| TC5          | Verify `Password not working` with tags in `In Progress` column | Passed  |
| TC6          | Verify `New keycard for Daniela V` with tags in `Completed` column | Passed  |

You can find the results in the folder: `build/reports/tests/test/index.html`.

### Issues Noted
- None were observed during the test run.

---

## Recommendations

### Feature Enhancements

1. **Tag Management**:
    - Implement logic to check for missing or extra tags dynamically to improve test precision.

2. **Parallel Test Execution**:
    - Integrate parallel execution for faster test runs on large datasets.

3. **Error Logging**:
    - Capture screenshots and logs upon failure for easier debugging.

### Testing Process Improvements

1. **CI/CD Integration**:
    - Automate test execution via Jenkins or GitHub Actions for continuous feedback.

2. **Expand Test Coverage**:
    - Add more edge cases, such as verifying task updates or error states.

3. **Browser Variability**:
    - Extend testing to multiple browsers (e.g., Firefox, WebKit) to ensure cross-browser compatibility.
