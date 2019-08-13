package inheritance;

public class Review {
  private String body;
  private String author;
  private double stars;

  Review(String body, String author, double stars) {
    this.body = body;
    this.author = author;
    this.stars = stars;
  }

  public String getBody() {
    return this.body;
  }

  public String getAuthor() {
    return this.author;
  }

  public double getStars() {
    return this.stars;
  }

  public String toReviewString() {
    return String.format(
        "Author: %s\n" +
        "Number of Stars: %.1f\n" +
        "Review: %s\n",
        getAuthor(), getStars(), getBody()
    );
  }
}
