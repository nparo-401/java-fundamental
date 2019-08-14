## Lab 07 - Composition and Inheritance, part 2
#### Resources:
* Renee Messick
* Travis Cox
* Jack Kinne
* Matt Stuhring
* [Rounding](https://stackoverflow.com/questions/8825209/rounding-decimal-points)

#### Files:
* inheritance
  * src/main 
    * [Restaurant.java](../inheritance/src/main/java/inheritance/Restaurant.java)
    * [Review.java](../inheritance/src/main/java/inheritance/Review.java)
    * [Store.java](../inheritance/src/main/java/inheritance/Store.java)
    * [Theater.java](../inheritance/src/main/java/inheritance/Theater.java)
  * src/test
    * [RestaurantTest.java](../inheritance/src/test/java/inheritance/RestaurantTest.java)
    * [ReviewTest.java](../inheritance/src/test/java/inheritance/ReviewTest.java)
    * [StoreTest.java](../inheritance/src/test/java/inheritance/StoreTest.java)
    * [TheaterTest.java](../inheritance/src/test/java/inheritance/StoreTest.java)

#### Methods:
**Restaurant**
* Variables:
  * `String name`
  * `double stars`
  * `String priceCategory`
  * `LinkedList<Review> reviews`
* Methods:
  * `getName()`
    * returns the name of the restaurant
  * `getStars()`
    * returns the double value of the stars
  * `getPriceCategory`
    * returns the price category of the restaurant
  * `addReview(Review review)`
    * adds a new review to the reviews LinkedList
    * calls the `addRestaurant()` to assign a instance of the current restaurant to the `Review` class
    * calls `updateStars()`
  * `getReview()`
    * returns an LinkedList<Review> of the reviews
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
  * `Restaurant restaurant`
* Methods:
  * `getBody()`
    * returns the body of the review
  * `getAuthor()`
    * returns the author
  * `getStars()`
    * returns the stars
  * `setRestaurant(Restaurant restaurant)`
    * assigns an instance of the restaurant to the class variables of the current review
  * `getRestaurant()`
    * returns an instance of the restaurant assigned to the review
  * `toString()`
    * returns the review as an organized string

**Store**
* Variables:
* Methods:

**Theater**
* Variables:
* Methods:
