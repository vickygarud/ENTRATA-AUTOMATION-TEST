# Example TestNg and Maven Project

## Description

This is an example of incorporating TestNg into a Maven build.

## Usage

To run script, you can run:
```agsl
test test -DbrowserName=chrome -DbaseUrl=https://www.entrata.com
```

##passing base url
-DbaseUrl=https://www.entrata.com


#custom messages or any string want to use to avoid hard code ,add it in config file
userConfig.properties


## Project Directory Structure🏗️

| Folder/File               | Description                                                                                                            |
|---------------------------| ---------------------------------------------------------------------------------------------------------------------- |
| src/main/java/drivers     | Contains driver-related classes and configurations for interacting with the web browser.                             |
| src/main/java/page_object | Holds page object classes, organizing the application's UI elements and related actions for maintainable test code.   |
| src/test/java/listeners    | Houses TestNG listeners for capturing and handling events during test execution, enhancing test reporting and logging. |
| src/test/java/tests       | Stores test classes containing end-to-end UI tests, utilizing page objects and interacting with the application.      |
