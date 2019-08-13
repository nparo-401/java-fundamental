## Lab 06 - Composition and Inheritance, part 1
#### Resources:
* Travis Cox
* Jack Kinne
* Matt Stuhring
* [Rounding](https://stackoverflow.com/questions/8825209/rounding-decimal-points)

#### Files:
* basiclibrary
  * src/main 
    * [Restaurant.java](../inheritance/src/main/java/inheritance/Restaurant.java)
    * [Review.java](../inheritance/src/main/java/inheritance/Review.java)
  * src/test
    * [RestaurantTest.java](../inheritance/src/test/java/inheritance/RestaurantTest.java)
    * [ReviewTest.java](../inheritance/src/test/java/inheritance/ReviewTest.java)

#### Methods:
**Restaurant**
* Variables:
  * `String name`
  * `double stars`
  * `String priceCategory`
  * `ArrayList<Review> reviews`
* Methods:
  * `getName()`
    * returns the name of the restaurant
  * `getStars()`
    * returns the double value of the stars
  * `getPriceCategory`
    * returns the price category of the restaurant
  * `addReview(Review review)`
    * adds a new review to the reviews ArrayList
  * `getReview()`
    * returns an ArrayList<Review> of the reviews
  * `updateStars()`
    * updates the star count as new reviews are added to the review list
  * `reviewToString()`
    * Builds a string with all the elements from the reviews ArrayList using the `toReviewString()` from the Class `Review`
    * Returns the string for the reviews
  * `toString()`
    * Returns a formated string for the restaurant

**Review**
* Variables:
  * `String body`
  * `String author`
  * `double stars`
* Methods:
  * `getBody()`
    * returns the body of the review
  * `getAuthor()`
    * returns the author
  * `getStars()`
    * returns the stars
  * `toReviewString()`
    * returns the review as an organized string
