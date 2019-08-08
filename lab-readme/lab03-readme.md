## Lab 03 - Maps, File I/O, and Testing
#### Resources:
* Jack Kinne
* Travis Cox
* Brandon Hurrington
* [HashSet](https://www.baeldung.com/java-hashset)
* [Collections.frequency](https://www.geeksforgeeks.org/java-util-collections-frequency-java-examples/)
* [Scanner](https://docs.oracle.com/javase/tutorial/essential/io/scanning.html)
* [Char at end of line](https://javarevisited.blogspot.com/2016/02/how-to-get-first-and-last-character-of-String-in-java-example.html)
* [String Contains](https://javarevisited.blogspot.com/2016/10/how-to-check-if-string-contains-another-substring-in-java-indexof-example.html)


#### Files:
* basiclibrary
  * src/main 
    * [Lab03.java](../basiclibrary/src/main/java/basiclibrary/Lab03.java)
  * src/test
    * [Lab03Test.java](../basiclibrary/src/test/java/basiclibrary/Lab03Test.java)
* linter
  * src/main
    * [App.java](../linter/src/main/java/linter/App.java)
  * src/test
    * [AppTest.java](../linter/src/test/java/linter/AppTest.java)

#### Methods:
**Basic Library**
* weatherData(int[][] weatherArr)
  * takes in an array of integer arrays
  * Assigns all values to a HashSet and eliminates all duplicate values
  * Assigns the min and max values using `Collections.min` and `Collections.max`
  * Begins building the response string with `StringBuilder`
  * uses a for loop to iterate from the min to 1 less than the max value
    * if the iterated value is not contained within the HashSet add it to the response string
  * return the response string
* tally(List<String> votes)
  * takes in a string List of votes
  * Assigns all unique values to a HashSet
  * Initialize `numVotes = 0` and a response string
  * Use an extended for loop on the HashSet to get total number of votes for each
    * Assign a count variable using `Collections.frequency`
    * If `numVotes < count`
      * reassign numVotes to count
      * set response string with the item in the lead
    * If `numVotes == count`
      * set response string to the tie response
  * return the response string

**Linter**
* linterMessage(String path)
  * takes in a string with the name of the file for the path
  * Initializes a Scanner
  * Opens a try, catch, finally block
    * TRY:
      * scans through the file being read while it has a next line
      * at each line builds the response by calling `response += errorChecker(line, lineNumber)` - this builds the final error message if an error is found or an empty string if not
      * increments the lineNumber to show the correct line
    * CATCH:
      * catches the file not found exception error and prints a response
    * FINALLY:
      * closes the file being read
* errorChecker(String line, int lineNumber)
  * takes in the line and the lineNumber and checks for errors
  * determines the last character of the line
  * checks if that line does not contain `if` or `else`, is not a `{` or `}`, and not an empty line
    * checks if last is not a semicolon
      * appends to the response if not a semicolon
  