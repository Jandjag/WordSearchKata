# Word Search Kata by Janet DeJager

## Instructions for Running Project:
You will using the main method in WordSearchProcessor to execute the test.  The output will be in your console.
- Check out the PillarKata project
- Run WordSearchProcessor as a Java Applicaation.  Your only argument will be the filename of your word search file, including the full path.
- Watch for the output in the console. 


#### Ideas to discuss at pairing session
* Continue to refactor WordSearch.  
  * There is too much duplicated code.  Each of the findXXX methods looks for the word forward and then in reverse.  
  * In both of the findDiagonalXXX methods, there's a loop through the rows and then a loop through columns.  Look for a reusable way to loop through these.   
* Additional unit tests covering many more scenarios.

