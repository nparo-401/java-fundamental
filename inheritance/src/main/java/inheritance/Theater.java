package inheritance;

import java.util.LinkedList;

public class Theater implements Reviewable {
  private String name;
  private double stars = 0.0;
  private LinkedList<String> movies = new LinkedList<>();
  private LinkedList<Review> reviews = new LinkedList<>();

//  Constructor
  Theater(String name) {
    this.name = name;
  }

//  Methods
  @Override
  public String getName() {
    return this.name;
  }

  @Override
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

  @Override
  public void addReview(Review review) {
    this.reviews.add(review);
    review.setReviewable(this);
    updateStars();
  }

  @Override
  public LinkedList<Review> getReviews() {
    return this.reviews;
  }

  @Override
  public String toReviewString() {
    LinkedList<Review> reviews = getReviews();
    StringBuilder review = new StringBuilder();
    for (Review value : reviews) {
      review.append(value.toString());
    }
    return review.toString();
  }

  @Override
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
