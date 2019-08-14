package inheritance;

public interface Reviewable {
  void addReview(Review review);
  void updateStars();
  String toReviewString();
  String toString();
}
