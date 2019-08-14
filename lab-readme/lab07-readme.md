## Lab 07 - Composition and Inheritance, part 2
#### Resources:
* Renee Messick
* Travis Cox
* Jack Kinne
* Matt Stuhring
* Melfi Perez
* Chris Coulon
* [Rounding](https://stackoverflow.com/questions/8825209/rounding-decimal-points)
* [Repeat a Char](https://stackoverflow.com/questions/2255500/can-i-multiply-strings-in-java-to-repeat-sequences)

#### Files:
* inheritance
  * src/main 
    * [Restaurant.java](../inheritance/src/main/java/inheritance/Restaurant.java)
    * [Review.java](../inheritance/src/main/java/inheritance/Review.java)
    * [Reviewable.java](../inheritance/src/main/java/inheritance/Reviewable.java)
    * [Shop.java](../inheritance/src/main/java/inheritance/Shop.java)
    * [Theater.java](../inheritance/src/main/java/inheritance/Theater.java)
  * src/test
    * [RestaurantTest.java](../inheritance/src/test/java/inheritance/RestaurantTest.java)
    * [ReviewTest.java](../inheritance/src/test/java/inheritance/ReviewTest.java)
    * [ShopTest.java](../inheritance/src/test/java/inheritance/ShopTest.java)
    * [TheaterTest.java](../inheritance/src/test/java/inheritance/TheaterTest.java)

#### Methods:
**Reviewable**
* Methods:
  * `addReview(Review review)`
  * `updateStars()`
  * `toReviewString()`
  * `toString()`

**Restaurant**
* Variables:
  * `String name`
  * `double stars`
  * `int priceCategory`
  * `LinkedList<Review> reviews`
* Methods:
  * `getName()`
    * returns the name of the restaurant
  * `getStars()`
    * returns the double value of the stars
  * `getPriceCategory()`
    * returns the price category of the restaurant
  * `getPriceAsChar(int numChars)`
    * returns a new string with a set of characters equal to the number entered for price point
  * `addReview(Review review)`
    * adds a new review to the reviews LinkedList
    * calls the `addRestaurant()` to assign a instance of the current restaurant to the `Review` class
    * calls `updateStars()`
  * `getReviews()`
    * returns an LinkedList<Review> of the reviews
  * `updateStars()`
    * updates the star count as new reviews are added to the review list
  * `toReviewString()`
    * Builds a string with all the elements from the reviews LinkedList using the `toReviewString()` from the Class `Review`
    * Returns the string for the reviews
  * `toString()`
    * Returns a formated string for the restaurant

**Review**
* Variables:
  * `String body`
  * `String author`
  * `double stars`
  * `Restaurant restaurant`
  * `Shop shop`
  * `Theater theater`
  * `String movie`
* Methods:
  * `getBody()`
    * returns the body of the review
  * `getAuthor()`
    * returns the author
  * `getStars()`
    * returns the stars
  * `getMovie()`
    * returns the movie title
  * `setRestaurant(Restaurant restaurant)`
    * assigns an instance of the restaurant to the class variables of the current review
  * `getRestaurant()`
    * returns an instance of the restaurant assigned to the review
  * `setShop(Shop shop)`
    * assigns an instance of the shop to the class variables of the current review
  * `getShop()`
    * returns an instance of the shop assigned to the review
  * `setTheater(Theater theater)`
    * assigns an instance of the theater to the class variables of the current review
  * `getTheater()`
    * returns an instance of the theater assigned to the review
  * `toString()`
    * returns the review as an organized string

**Shop**
* Variables:
  * `String name`
  * `String description`
  * `double stars`
  * `int priceCategory`
  * `LinkedList<Review> reviews`
* Methods:
  * `getName()`
    * returns the name of the shop
  * `getDescription()`
    * returns the description of the shop
  * `getStars()`
    * returns the double value of the stars
  * `getPriceCategory()`
    * returns the price category of the shop
  * `getPriceAsChar(int numChars)`
    * returns a new string with a set of characters equal to the number entered for price point
  * `addReview(Review review)`
    * adds a new review to the reviews LinkedList
    * calls the `addShop()` to assign a instance of the current shop to the `Review` class
    * calls `updateStars()`
  * `getReviews()`
    * returns an LinkedList<Review> of the reviews
  * `updateStars()`
    * updates the star count as new reviews are added to the review list
  * `toReviewString()`
    * Builds a string with all the elements from the reviews LinkedList using the `toReviewString()` from the Class `Review`
    * Returns the string for the reviews
  * `toString()`
    * Returns a formated string for the shop

**Theater**
* Variables:
  * `String name`
  * `double stars`
  * `LinkedList<String> movies = new LinkedList<>()`
  * `LinkedList<Review> reviews = new LinkedList<>()`
* Methods:
  * `getName()`
    * returns the name of the theater
  * `getStars()`
    * returns the double value of the stars
  * `addMovie(String movieTitle)`
    * adds a movie to the movies LinkedList
  * `getMovies()`
    * returns the LinkedList of movies
  * `removeMovie(String movieTitle)`
    * removes a movie from the LinkedList of movies
  * `toMovieString(LinkedList<String> movie)`
    * returns a string will all of the movies from the LinkedList
  * `addReview(Review review)`
    * adds a new review to the reviews LinkedList
    * calls the `addTheater()` to assign a instance of the current theater to the `Review` class
    * calls `updateStars()`
  * `getReviews()`
    * returns an LinkedList<Review> of the reviews
  * `updateStars()`
    * updates the star count as new reviews are added to the review list
  * `toReviewString()`
    * Builds a string with all the elements from the reviews LinkedList using the `toReviewString()` from the Class `Review`
    * Returns the string for the reviews
  * `toString()`
    * Returns a formated string for the theater
