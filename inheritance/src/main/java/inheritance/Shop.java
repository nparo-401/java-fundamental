package inheritance;

import java.util.LinkedList;

public class Shop implements Reviewable {
  private String name;
  private String description;
  private double stars = 0.0;
  private int priceCategory;
  private LinkedList<Review> reviews = new LinkedList<>();

// Constructor
  Shop(String name, String description, int priceCategory) {
    this.name = name;
    this.description = description;
    this.priceCategory = Math.min(priceCategory, 4);
  }

//  Methods
  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return this.description;
  }

  public double getStars() {
    return this.stars;
  }

  public int getPriceCategory() {
    return this.priceCategory;
  }

  public String getPriceAsChar(int numChars){
    return new String(new char[numChars]).replace("\0", "$");
  }

  public void addReview(Review review) {
    this.reviews.add(review);
    review.setShop(this);
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
    if (this.stars != 0.0) {
      return String.format(
          "Name: %s\n" +
          "Description: %s\n" +
          "Price Category: %s\n" +
          "Stars: %.1f\n",
          getName(), getDescription(), getPriceAsChar(getPriceCategory()), getStars()
      );
    }
    return String.format(
        "Name: %s\n" +
        "Description: %s\n" +
        "Price Category: %s\n",
        getName(), getDescription(), getPriceAsChar(getPriceCategory())
    );
  }
}
