package inheritance;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReviewTest {
  private double delta = 0.000001;

  @Test
  public void testGetBody() {
    Review review = new Review("This restaurant was good", "Joe Schmoe", 4);

    assertEquals(
        "testGetBody should return: ",
        "This restaurant was good",
        review.getBody()
    );
  }

  @Test
  public void testGetAuthor() {
    Review review = new Review("This restaurant was good", "Joe Schmoe", 4);

    assertEquals(
        "testGetAuthor should return: ",
        "Joe Schmoe",
        review.getAuthor()
    );
  }

  @Test
  public void testGetStars() {
    Review review = new Review("This restaurant was good", "Joe Schmoe", 4);

    assertEquals(
        "testGetStars should return: ",
        4.0,
        review.getStars(),
        delta
    );
  }

  @Test
  public void testGetMovie() {
    Theater theater = new Theater("Grand Hammer");
    Review review = new Review("Good movie!", "Joe Schmoe", 4, theater, "Hebrew Hammer");

    assertEquals(
        "testGetMovie should return: ",
        "Hebrew Hammer",
        review.getMovie()
    );
  }

  @Test
  public void testGetRestaurant() {
    Restaurant restaurant = new Restaurant("Chipotle", 1);
    Review review = new Review("Bleh", "Joe Schmoe", 2, restaurant);
    restaurant.addReview(review);

    assertEquals(
        "testGetRestaurant should return: ",
        "Chipotle has a rating of 2.0 stars and is a $ price point",
        review.getRestaurant().toString()
    );
  }

  @Test
  public void testGetShop() {
    Shop shop = new Shop("Hammer", "Place of Time", 2);
    Review review = new Review("Awesome!", "Joe Schmoe", 3, shop);
    shop.addReview(review);

    assertEquals(
        "testGetShop should return: ",
        "Name: Hammer\n" +
            "Description: Place of Time\n" +
            "Price Category: $$\n" +
            "Stars: 3.0\n",
        review.getShop().toString()
    );
  }

  @Test
  public void testGetTheater() {
    Theater theater = new Theater("Grand Hammer");
    Review review = new Review("Awesome!", "Joe Schmoe", 3, theater, "Hammer Time");
    theater.addReview(review);

    assertEquals(
        "testGetShop should return: ",
        "Name: Grand Hammer\n" +
            "Stars: 3.0\n" +
            "Movies: Hammer Time\n",
        review.getTheater().toString()
    );
  }

  @Test
  public void testToString() {
    Review review = new Review("This restaurant was good", "Joe Schmoe", 4);

    assertEquals(
        "testToString should return: ",
        "Author: Joe Schmoe\n" +
            "Number of Stars: 4.0\n" +
            "Review: This restaurant was good\n",
        review.toString()
    );
  }

  @Test
  public void testToString_WithMovie() {
    Theater theater = new Theater("Grand Hammer");
    Review review = new Review("Good movie!", "Joe Schmoe", 4, theater, "Hebrew Hammer");

    assertEquals(
        "testToString_WithMovie should return: ",
        "Author: Joe Schmoe\n" +
            "Number of Stars: 4.0\n" +
            "Movie Title: Hebrew Hammer\n" +
            "Review: Good movie!\n",
        review.toString()
    );
  }
}
