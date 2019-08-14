package inheritance;

import java.util.LinkedList;

public class Theater implements Reviewable {
  private String name;
  private double stars = 0.0;
  private LinkedList<String> movies = new LinkedList<>();
  private LinkedList<Review> reviews = new LinkedList<>();

  Theater(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public double getStars() {
    return this.stars;
  }

  public void addMovie(String movieTitle) {
    this.movies.add(movieTitle);
  }

  public LinkedList<String> getMovies() {
    return this.movies;
  }

  public void removeMovie(String movieTitle) {
    this.movies.remove(movieTitle);
  }

  public String toMoviesString(LinkedList<String> movies) {
    StringBuilder movieString = new StringBuilder();
    for (int i = 0; i < movies.size() - 1; i++) {
      movieString.append(movies.get(i)).append(", ");
    }
    if (movies.size() == 0) {
      return "No Movies Available";
    }
    movieString.append(movies.get(movies.size() - 1));
    return movieString.toString();
  }

  public void addReview(Review review) {
    this.reviews.add(review);
    review.setTheater(this);
    updateStars();
  }

  public LinkedList<Review> getReviews() {
    return this.reviews;
  }

  public String toReviewString() {
    StringBuilder review = new StringBuilder();
    for (int i = 0; i< getReviews().size(); i++) {
      review.append(getReviews().get(i).toString());
    }
    return review.toString();
  }

  public void updateStars() {
    double current = 0.0;
    for (int i = 0; i < getReviews().size(); i++) {
      current += getReviews().get(i).getStars();
    }
    current /= (getReviews().size());
    current = Math.round(current * 10.0) / 10.0;
    this.stars = current;
  }

  @Override
  public String toString() {
    if (this.stars == 0.0) {
      return String.format(
          "Name: %s\n" +
          "Movies: %s\n",
          getName(), toMoviesString(getMovies())
      );
    }
    return String.format(
        "Name: %s\n" +
        "Stars: %.1f\n" +
        "Movies: %s\n",
        getName(), getStars(), toMoviesString(getMovies())
    );
  }
}
