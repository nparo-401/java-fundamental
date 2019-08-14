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
  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public double getStars() {
    return this.stars;
  }

  public int getPriceCategory() {
    return this.priceCategory;
  }

  private String getPriceAsChar(int numChars){
    return new String(new char[numChars]).replace("\0", "$");
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
