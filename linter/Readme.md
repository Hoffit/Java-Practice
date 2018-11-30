# Code Fellows 401 Lab 03

## Linter Exercise

This application can be used to check JavaScript source files syntax validity. Well, at least for missing semicolons.

Any line that is not one of the following will be checked, and if missing a semicolon, an error message detailing the specific line number, will be printed to the console:
- lines with the following characters are not checked:
  - {
  - }
  - if
  - else

You can use this application by passing in the path location of your JavaScript source file, to method App.javaScriptLinter(sourceFile).