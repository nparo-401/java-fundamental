package inheritance;

import org.junit.Test;

import static org.junit.Assert.*;

public class TheaterTest {
  private double delta = 0.000001;

  @Test
  public void testGetName() {
    Theater theater = new Theater("Grand Hammer");

    assertEquals(
        "testGetName should return: ",
        "Grand Hammer",
        theater.getName()
    );
  }

  @Test
  public void testGetStars() {
    Theater theater = new Theater("Grand Hammer");
    Review review = new Review("This movie was good", "Joe Schmoe", 3.5, theater);
    theater.addReview(review);

    assertEquals(
        "testGetStars should return: ",
        3.5,
        theater.getStars(),
        delta
    );
  }

  @Test
  public void testGetMovies() {
    Theater theater = new Theater("Grand Hammer");
    theater.addMovie("Hebrew Hammer");

    assertEquals(
        "testGetMovies should return: ",
        "[Hebrew Hammer]",
        theater.getMovies().toString()
    );
  }

  @Test
  public void testRemoveMovie() {
    Theater theater = new Theater("Grand Hammer");
    theater.addMovie("Hebrew Hammer");
    theater.addMovie("Hebrew Mallet");
    theater.removeMovie("Hebrew Mallet");

    assertEquals(
        "testRemoveMovie should return: ",
        "Hebrew Hammer",
        theater.toMoviesString(theater.getMovies())
    );
  }

  @Test
  public void testToMovieString() {
    Theater theater = new Theater("Grand Hammer");
    theater.addMovie("Hebrew Hammer");

    assertEquals(
        "testToMovieString should return: ",
        "Hebrew Hammer",
        theater.toMoviesString(theater.getMovies())
    );
  }

  @Test
  public void testGetReviews() {
    Theater theater = new Theater("Grand Hammer");
    Review review = new Review("This was a good movie", "Joe Schmoe", 3, theater);
    theater.addReview(review);

    assertEquals(
        "testGetReviews should return: ",
        "[Author: Joe Schmoe\n" +
            "Number of Stars: 3.0\n" +
            "Review: This was a good movie\n" +
            "]",
        theater.getReviews().toString()
    );
  }

  @Test
  public void testToReviewString_OneReview() {
    Theater theater = new Theater("Grand Hammer");
    Review review = new Review("This was a good movie", "Joe Schmoe", 3, theater);
    theater.addReview(review);

    assertEquals(
        "testGetReviews_OneReview should return: ",
        "Author: Joe Schmoe\n" +
            "Number of Stars: 3.0\n" +
            "Review: This was a good movie\n",
        theater.toReviewString()
    );
  }

  @Test
  public void testToReviewString_MultipleReview() {
    Theater theater = new Theater("Grand Hammer");
    Review review = new Review("This was a good movie", "Joe Schmoe", 3, theater);
    Review review1 = new Review("This movie sucked", "Jane Schmoe", 1, theater);
    theater.addReview(review);
    theater.addReview(review1);

    assertEquals(
        "testToReviewString_MultipleReviews should return: ",
        "Author: Joe Schmoe\n" +
            "Number of Stars: 3.0\n" +
            "Review: This was a good movie\n" +
            "Author: Jane Schmoe\n" +
            "Number of Stars: 1.0\n" +
            "Review: This movie sucked\n",
        theater.toReviewString()
    );
  }

  @Test
  public void testToString_NoMovieNoStars() {
    Theater theater = new Theater("Grand Hammer");

    assertEquals(
        "testToString should return: ",
        "Name: Grand Hammer\n" +
            "Movies: No Movies Available\n",
        theater.toString()
    );
  }

  @Test
  public void testToString_OneMovieNoStars() {
    Theater theater = new Theater("Grand Hammer");
    theater.addMovie("Hebrew Hammer");

    assertEquals(
        "testToString should return: ",
        "Name: Grand Hammer\n" +
            "Movies: Hebrew Hammer\n",
        theater.toString()
    );
  }

  @Test
  public void testToString_OneMovieAndStars() {
    Theater theater = new Theater("Grand Hammer");
    theater.addMovie("Hebrew Hammer");
    Review review = new Review("This movie was awesome", "Joe Schmoe", 4, theater);
    theater.addReview(review);

    assertEquals(
        "testToString should return: ",
        "Name: Grand Hammer\n" +
            "Stars: 4.0\n" +
            "Movies: Hebrew Hammer\n",
        theater.toString()
    );
  }
}