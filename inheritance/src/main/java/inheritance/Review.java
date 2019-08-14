package inheritance;

public class Review {
  private String body;
  private String author;
  private double stars;
  private Restaurant restaurant;
  private Shop shop;
  private Theater theater;
  private String movie;

//  Constructors
  Review(String body, String author, double stars) {
    this.body = body;
    this.author = author;
    this.stars = Math.min(stars, 5.0);
  }

  Review(String body, String author, double stars, Restaurant restaurant) {
    this.body = body;
    this.author = author;
    this.stars = Math.min(stars, 5.0);
    this.restaurant = restaurant;
  }

  Review(String body, String author, double stars, Shop shop) {
    this.body = body;
    this.author = author;
    this.stars = Math.min(stars, 5.0);
    this.shop = shop;
  }

  Review(String body, String author, double stars, Theater theater) {
    this.body = body;
    this.author = author;
    this.stars = Math.min(stars, 5.0);
    this.theater = theater;
  }

  Review(String body, String author, double stars, Theater theater, String movieTitle) {
    this.body = body;
    this.author = author;
    this.stars = Math.min(stars, 5.0);
    this.theater = theater;
    this.movie = movieTitle;
    this.theater.addMovie(movieTitle);
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

  public void setRestaurant(Restaurant restaurant) {
    this.restaurant = restaurant;
  }

  public Restaurant getRestaurant() {
    return this.restaurant;
  }

  public void setShop(Shop shop) {
    this.shop = shop;
  }

  public Shop getShop() {
    return this.shop;
  }

  public void setTheater(Theater theater) {
    this.theater = theater;
  }

  public Theater getTheater() {
    return this.theater;
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
