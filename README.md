# rb-test-project
**A project to test the Rainbird App. Built in Java with Springboot.**

## Setup
- Open the project via Maven.
- Update the application.yaml file in src/test/resources/ with your rainbird username and password. **DO NOT COMMIT THIS UPDATED FILE**
- Run the CucumberRunner class with JUnit to execute the tests

## Additional Configuration
In order to run this project, the machine requires Chrome to be installed. Additionally it requires the correct version of chromium that matches the installed version of Chrome.
A version of chromium is provided in src/test/resources/drivers. Provided version is 91, alternative versions can be found at https://sites.google.com/a/chromium.org/chromedriver/downloads and should replace the provided file if required.
