# Intervue.io Selenium Test Automation

This project contains an automated test suite for testing the login functionality of the Intervue.io website using Selenium WebDriver with Cucumber and Java.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Project Structure](#project-structure)
- [Setup Instructions](#setup-instructions)
- [Configuration](#configuration)
- [Test Execution](#test-execution)
- [Test Reports](#test-reports)
- [Screenshot Capture](#screenshot-capture)
- [Troubleshooting](#troubleshooting)
- [Contributing](#contributing)

## Prerequisites

- Java JDK 11 or higher
- Maven 3.6.3 or higher
- Chrome, Firefox, or Edge browser


## Setup Instructions

### 1. Clone the repository

```bash
git clone <repository-url>
cd QA_Intern_Assignment
```

### 2. Install dependencies

```bash
mvn clean install -DskipTests
```

## Configuration

### Browser Configuration

By default, the tests run on Chrome. You can change the browser by using the following system property:

```bash
mvn test -Dbrowser=firefox
```

Supported browsers:
- chrome (default)
- firefox
- edge

### Wait Times Configuration

Wait times can be adjusted in the BaseTest.java and BasePage.java files:

- Implicit wait: Default is 10 seconds
- Page load timeout: Default is 30 seconds
- Explicit waits: Default is 10 seconds

## Test Execution

### Running all tests

```bash
mvn clean test
```

### Running specific tests using tags

```bash
mvn clean test -Dcucumber.filter.tags="@login"
```

### Running tests using TestNG XML

```bash
mvn clean test -DsuiteXmlFile=testng.xml
```

### Running tests from IDE

1. Right-click on the TestRunner.java file
2. Select "Run TestRunner"


## Test Reports

After test execution, reports can be found at:

- HTML Report: `target/cucumber-reports/cucumber-pretty.html`
- JSON Report: `target/cucumber-reports/CucumberTestReport.json`

## Screenshot Capture

Screenshots are automatically captured in the following scenarios:

1. When a login fails but no error message is displayed
2. When any test scenario fails

Screenshots are saved in the `screenshots` directory with a timestamp in the filename:
- Format: `Scenario.jpeg`
- Example: `testCase_ login credentials.jpeg`

## Troubleshooting

### Common Issues and Solutions

1. **WebDriver initialization failed**
   - Ensure you have the correct browser installed
   - Check if WebDriverManager can access the internet to download drivers

2. **Element not found exceptions**
   - Review and update element locators in the page classes
   - Increase wait times if the application is slow

3. **Test timeouts**
   - Increase the timeout values in LoginTestCase.java

4. **Maven build failures**
   - Ensure Maven is correctly installed
   - Check Java version compatibility

### Debugging

Add the following VM options to enable debug mode:

```bash
-Dcucumber.options="--plugin debug"
```

