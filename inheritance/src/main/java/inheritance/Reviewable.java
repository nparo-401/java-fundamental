package inheritance;

import java.util.LinkedList;

public interface Reviewable {
  String getName();

  double getStars();

  void addReview(Review review);

  LinkedList<Review> getReviews();

  void updateStars();

  String toReviewString();

  String toString();
}
