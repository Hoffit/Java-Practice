# Code Fellows 401 Lab 04

## Bitmap part 1

The Bitmap library supports transforms of bitmap image files.

It is a Java command line application. It takes 3 arguments:
1. The path and file of an image to transform.
2. The path and file name to write transformed image. The path must exist, but the file will be created if it does not exist. If it does exist, it will be overwritten.
3. The type of transform to perform.

The runable application is located in .\JavaPractice\bitmap-transformer\out\production\classes\

Example:
A) java App resources/Randomize_Test.bmp resources/Randomize_Output.bmp randomize
B) java App resources/Black_And_White_Test.bmp resources/Output.bmp black_and_white

The following transforms are supported:
1. black_and_white
2. flip_horizontal
3. flip_vertical
4. randomize

It's a Java app. It can be run on any machine with Java version 8 or later.

Note on testing; the tests are designed to work on four provided image files located in the resources directory with this application. However, they will work on any bmp file of size 124x124.

For actual use of the app, the input image to be transformed must be of type bitmap (.bmp).
