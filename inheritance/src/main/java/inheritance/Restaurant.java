package inheritance;

import java.util.LinkedList;

public class Restaurant implements Reviewable {
  private String name;
  private double stars = 0.0;
  private int priceCategory;
  private LinkedList<Review> reviews = new LinkedList<>();

//  Constructor
  Restaurant(String name, int priceCategory) {
    this.name = name;
    this.priceCategory = Math.min(priceCategory, 4);
  }

//  Methods
  public String getName() {
    return this.name;
  }

  public double getStars() {
    return this.stars;
  }

  public int getPriceCategory() {
    return this.priceCategory;
  }

  private String getPriceAsChar(int numChars){
    return new String(new char[numChars]).replace("\0", "$");
  }

  public void addReview(Review review) {
    this.reviews.add(review);
    review.setRestaurant(this);
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

  public String toString() {
    if (this.stars == 0.0) {
      return String.format(
          "%s is a %s price point",
          getName(), getPriceAsChar(getPriceCategory())
      );
    }
    return String.format(
        "%s has a rating of %.1f stars and is a %s price point",
        getName(), getStars(), getPriceAsChar(getPriceCategory())
    );
  }
}
