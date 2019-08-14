package inheritance;

import org.junit.Test;
import static org.junit.Assert.*;

public class ShopTest {
  private double delta = 0.000001;

  @Test
  public void testGetName() {
    Shop shop = new Shop("Hammer", "Place of Time", 2);

    assertEquals(
        "testGetName should return: ",
        "Hammer",
        shop.getName()
    );
  }

  @Test
  public void testGetDescription() {
    Shop shop = new Shop("Hammer", "Place of Time", 2);

    assertEquals(
        "testGetDescription should return: ",
        "Place of Time",
        shop.getDescription()
    );
  }

  @Test
  public void testGetStars() {
    Shop shop = new Shop("Hammer", "Place of Time", 2);

    assertEquals(
        "testGetStars should return: ",
        0.0,
        shop.getStars(),
        delta
    );
  }

  @Test
  public void testGetPriceCategory_AsInt() {
    Shop shop = new Shop("Hammer", "Place of Time", 2);

    assertEquals(
        "testGetPriceCategory_AsInt should return: ",
        2,
        shop.getPriceCategory()
    );
  }

  @Test
  public void testGetPriceAsChar() {
    Shop shop = new Shop("Hammer", "Place of Time", 2);

    assertEquals(
        "testGetPriceCategory_AsInt should return: ",
        "$$",
        shop.getPriceAsChar(shop.getPriceCategory())
    );
  }

  @Test
  public void testGetReview() {
    Shop shop = new Shop("Hammer", "Place of Time", 2);
    Review review = new Review("Delicious", "Joe Schmoe", 4, shop);
    shop.addReview(review);

    assertEquals(
        "testGetReview should return: ",
        "[Author: Joe Schmoe\n" +
            "Number of Stars: 4.0\n" +
            "Review: Delicious\n" +
            "]",
        shop.getReviews().toString()
    );
  }

  @Test
  public void testToReviewString_OneReview() {
    Shop shop = new Shop("Hammer", "Place of Time", 2);
    Review review = new Review("Delicious", "Joe Schmoe", 4, shop);
    shop.addReview(review);

    assertEquals(
        "testToReviewString_OneReview should return: ",
        "Author: Joe Schmoe\n" +
            "Number of Stars: 4.0\n" +
            "Review: Delicious\n",
        shop.toReviewString()
    );
  }

  @Test
  public void testToReviewString_MultipleReviews() {
    Shop shop = new Shop("Hammer", "Place of Time", 2);
    Review review = new Review("Great stuff inside", "Joe Schmoe", 4, shop);
    Review review1 = new Review("Terrible service", "Jane Schmoe", 1, shop);
    shop.addReview(review);
    shop.addReview(review1);

    assertEquals(
        "testToReviewString_OneReview should return: ",
        "Author: Joe Schmoe\n" +
            "Number of Stars: 4.0\n" +
            "Review: Great stuff inside\n" +
            "Author: Jane Schmoe\n" +
            "Number of Stars: 1.0\n" +
            "Review: Terrible service\n",
        shop.toReviewString()
    );
  }

  @Test
  public void testToString() {
    Shop shop = new Shop("Hammer", "Place of Time", 2);

    assertEquals(
        "testToString should return: ",
        "Name: Hammer\n" +
            "Description: Place of Time\n" +
            "Price Category: $$\n",
        shop.toString()
    );
  }

  @Test
  public void testToString_WithStars() {
    Shop shop = new Shop("Hammer", "Place of Time", 2);
    Review review = new Review("Awesome shop!", "Joe Schmoe", 4, shop);
    shop.addReview(review);

    assertEquals(
        "testToString_WithStars should return: ",
        "Name: Hammer\n" +
            "Description: Place of Time\n" +
            "Price Category: $$\n" +
            "Stars: 4.0\n",
        shop.toString()
    );
  }
}