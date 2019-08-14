package inheritance;

public class Review {
  private String body;
  private String author;
  private double stars;
  private Reviewable reviewable;
  private String movie;

//  Constructors
  Review(String body, String author, double stars) {
    this.body = body;
    this.author = author;
    this.stars = Math.min(stars, 5.0);
  }

  Review(String body, String author, double stars, Reviewable reviewable) {
    this(body, author, stars);
    this.reviewable = reviewable;
  }

  Review(String body, String author, double stars, Reviewable reviewable, String movieTitle) {
    this(body, author, stars, reviewable);
    this.movie = movieTitle;
    ((Theater)this.reviewable).addMovie(movieTitle);
  }

//  Methods
  public String getBody() {
    return this.body;
  }

  public String getAuthor() {
    return this.author;
  }

  public double getStars() {
    return this.stars;
  }

  public String getMovie() {
    return this.movie;
  }

  void setReviewable(Reviewable reviewable) {
    this.reviewable = reviewable;
  }

  public Reviewable getReviewable() {
    return this.reviewable;
  }

  public String toString() {
    if (this.movie != null) {
      return String.format(
          "Author: %s\n" +
          "Number of Stars: %.1f\n" +
          "Movie Title: %s\n" +
          "Review: %s\n",
          getAuthor(), getStars(), getMovie(), getBody()
      );
    }
    return String.format(
        "Author: %s\n" +
        "Number of Stars: %.1f\n" +
        "Review: %s\n",
        getAuthor(), getStars(), getBody()
    );
  }
}
