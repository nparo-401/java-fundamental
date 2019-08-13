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
  public void testToString() {
    Review review = new Review("This restaurant was good", "Joe Schmoe", 4);

    assertEquals(
        "testToString should return: ",
        "Author: Joe Schmoe\n" +
            "Number of Stars: 4.0\n" +
            "Review: This restaurant was good\n",
        review.toReviewString()
    );
  }
}
