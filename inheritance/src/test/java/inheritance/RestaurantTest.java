package inheritance;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RestaurantTest {
  double delta = 0.000001;

  @Test
  public void testGetName() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 2, "$");

    assertEquals(
        "testGetName should return: ",
        "Chipotle",
        testRestaurant.getName()
    );
  }

  @Test
  public void testGetStars() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 2, "$");

    assertEquals(
        "testGetName should return: ",
        2.0,
        testRestaurant.getStars(),
        delta
    );
  }

  @Test
  public void testGetPriceCategory() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 2, "$");

    assertEquals(
        "testGetName should return: ",
        "$",
        testRestaurant.getPriceCategory()
    );
  }

  @Test
  public void testGetReview_Empty() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 2, "$");

    assertEquals(
        "testGetReview_Empty should return: ",
      new ArrayList<>(),
        testRestaurant.getReview()
    );
  }

  @Test
  public void testGetReview_NotEmpty() {
    ArrayList<Review> testReview = new ArrayList<>();
    Restaurant testRestaurant = new Restaurant("Chipotle", 2, "$");
    Review review = new Review("This restaurant was good", "Joe Schmoe", 4);

    testRestaurant.addReview(review);
    testReview.add(review);

    assertEquals(
        "testGetReview_NotEmpty should return: ",
        testReview,
        testRestaurant.getReview()
    );
  }

  @Test
  public void testToString() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 2, "$");

    assertEquals(
        "testToString should return: ",
        "Chipotle has a rating of 2.0 stars and is a $ price point",
        testRestaurant.toString()
    );
  }

  @Test
  public void testAddReview_AddOneReview() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 2, "$");
    Review review = new Review("This restaurant was good", "Joe Schmoe", 4);
    testRestaurant.addReview(review);

    assertEquals(
        "testAddReview_AddOneReview should return: ",
        "Author: Joe Schmoe\n" +
            "Number of Stars: 4.0\n" +
            "Review: This restaurant was good\n",
        testRestaurant.reviewToString()
    );
  }

  @Test
  public void testAddReview_AddMultipleReview() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 2, "$");
    Review review = new Review("This restaurant was good", "Joe Schmoe", 4);
    Review review1 = new Review("This restaurant was bad", "Jane Schmoe", 1);
    testRestaurant.addReview(review);
    testRestaurant.addReview(review1);

    assertEquals(
        "testAddReview_AddMultipleReview should return: ",
        "Author: Joe Schmoe\n" +
            "Number of Stars: 4.0\n" +
            "Review: This restaurant was good\n" +
            "Author: Jane Schmoe\n" +
            "Number of Stars: 1.0\n" +
            "Review: This restaurant was bad\n",
        testRestaurant.reviewToString()
    );
  }

  @Test
  public void testUpdateStars_AddOneReview() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 2, "$");
    Review review = new Review("This restaurant was good", "Joe Schmoe", 4);
    testRestaurant.addReview(review);

    assertEquals(
        "testUpdateStars_AddOneReview should return: ",
        3.0,
        testRestaurant.getStars(),
        delta
    );
  }

  @Test
  public void testUpdateStars_AddMultipleReview() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 2, "$");
    Review review = new Review("This restaurant was good", "Joe Schmoe", 4);
    Review review1 = new Review("This restaurant was bad", "Jane Schmoe", 1);
    testRestaurant.addReview(review);
    testRestaurant.addReview(review1);

    assertEquals(
        "testUpdateStars_AddMultipleReview should return: ",
        2.7,
        testRestaurant.getStars(),
        delta
    );
  }
}
