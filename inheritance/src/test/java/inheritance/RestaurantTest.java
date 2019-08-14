package inheritance;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class RestaurantTest {
  private double delta = 0.000001;

  @Test
  public void testGetName() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 1);

    assertEquals(
        "testGetName should return: ",
        "Chipotle",
        testRestaurant.getName()
    );
  }

  @Test
  public void testGetStars() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 1);

    assertEquals(
        "testGetName should return: ",
        0.0,
        testRestaurant.getStars(),
        delta
    );
  }

  @Test
  public void testGetPriceCategory() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 1);

    assertEquals(
        "testGetName should return: ",
        1,
        testRestaurant.getPriceCategory()
    );
  }

  @Test
  public void testGetReview_Empty() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 1);

    assertEquals(
        "testGetReview_Empty should return: ",
      new ArrayList<>(),
        testRestaurant.getReviews()
    );
  }

  @Test
  public void testGetReview_NotEmpty() {
    ArrayList<Review> testReview = new ArrayList<>();
    Restaurant testRestaurant = new Restaurant("Chipotle", 1);
    Review review = new Review("This restaurant was good", "Joe Schmoe", 4, testRestaurant);

    testRestaurant.addReview(review);
    testReview.add(review);

    assertEquals(
        "testGetReview_NotEmpty should return: ",
        testReview,
        testRestaurant.getReviews()
    );
  }

  @Test
  public void testToString() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 1);

    assertEquals(
        "testToString should return: ",
        "Chipotle is a $ price point",
        testRestaurant.toString()
    );
  }

  @Test
  public void testAddReview_AddOneReview() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 1);
    Review review = new Review("This restaurant was good", "Joe Schmoe", 4, testRestaurant);
    testRestaurant.addReview(review);

    assertEquals(
        "testAddReview_AddOneReview should return: ",
        "Author: Joe Schmoe\n" +
            "Number of Stars: 4.0\n" +
            "Review: This restaurant was good\n",
        testRestaurant.toReviewString()
    );
  }

  @Test
  public void testAddReview_AddMultipleReview() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 1);
    Review review = new Review("This restaurant was good", "Joe Schmoe", 4, testRestaurant);
    Review review1 = new Review("This restaurant was bad", "Jane Schmoe", 1, testRestaurant);
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
        testRestaurant.toReviewString()
    );
  }

  @Test
  public void testUpdateStars_AddOneReview() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 1);
    Review review = new Review("This restaurant was good", "Joe Schmoe", 4, testRestaurant);
    testRestaurant.addReview(review);

    assertEquals(
        "testUpdateStars_AddOneReview should return: ",
        4.0,
        testRestaurant.getStars(),
        delta
    );
  }

  @Test
  public void testUpdateStars_AddMultipleReview() {
    Restaurant testRestaurant = new Restaurant("Chipotle", 1);
    Review review = new Review("This restaurant was good", "Joe Schmoe", 4, testRestaurant);
    Review review1 = new Review("This restaurant was bad", "Jane Schmoe", 1, testRestaurant);
    testRestaurant.addReview(review);
    testRestaurant.addReview(review1);

    assertEquals(
        "testUpdateStars_AddMultipleReview should return: ",
        2.5,
        testRestaurant.getStars(),
        delta
    );
  }
}
