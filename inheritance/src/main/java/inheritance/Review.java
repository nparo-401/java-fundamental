package inheritance;

public class Review {
  private String body;
  private String author;
  private double stars;
  private Restaurant restaurant;

  Review(String body, String author, double stars) {
    this.body = body;
    this.author = author;
    if (stars > 5) {
      this.stars = 5;
    } else {
      this.stars = stars;
    }
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

  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
  }

  public Restaurant getRestaurant() {
    return this.restaurant;
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
