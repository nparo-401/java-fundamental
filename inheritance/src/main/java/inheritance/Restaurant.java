package inheritance;

import java.util.ArrayList;

public class Restaurant {
  private String name;
  private double stars;
  private String priceCategory;
  private ArrayList<Review> reviews = new ArrayList<>();

  Restaurant(String name, double stars, String priceCategory) {
    this.name = name;
    if (stars > 5) {
      this.stars = 5;
    } else {
      this.stars = stars;
    }
    this.priceCategory = priceCategory;
  }

  public String getName() {
    return this.name;
  }

  public double getStars() {
    return this.stars;
  }

  public String getPriceCategory() {
    return this.priceCategory;
  }

  public void addReview(Review review) {
    this.reviews.add(review);
    review.setRestaurant(this);
    updateStars();
  }

  public ArrayList<Review> getReview() {
    return this.reviews;
  }

  private void updateStars() {
    double current = this.stars;
    for (int i=0; i < getReview().size(); i++) {
      current += getReview().get(i).getStars();
    }
    current /= (getReview().size() + 1);
    current = Math.round(current * 10.0) / 10.0;
    this.stars = current;
  }

  public String reviewToString() {
    StringBuilder review = new StringBuilder();
    for (int i = 0; i< getReview().size(); i++) {
      review.append(getReview().get(i).toReviewString());
    }
    return review.toString();
  }

  public String toString() {
    return String.format(
        "%s has a rating of %.1f stars and is a %s price point",
        getName(), getStars(), getPriceCategory());
  }
}
