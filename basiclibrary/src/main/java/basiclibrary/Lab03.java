package basiclibrary;

import java.util.*;

public class Lab03 {
  public static String weatherData(int[][] weatherArr) {
    HashSet<Integer> weatherSet = new HashSet<>();

    for (int[] ints : weatherArr) {
      for (int day : ints) {
        weatherSet.add(day);
      }
    }

    if (weatherSet.isEmpty()) return "0";

    int min = Collections.min(weatherSet);
    int max = Collections.max(weatherSet);
    StringBuilder response = new StringBuilder();
    response.append("High: ").append(max).append("\n");
    response.append("Low: ").append(min).append("\n");

    for (int i = min; i < max; i++) {
      if (!weatherSet.contains(i)) response.append("Never saw temperature: ").append(i).append("\n");
    }

    return response.toString();
  }

  public static String tally(List<String> votes) {
    if (votes.isEmpty()) return "0";

    HashSet<String> votedItems = new HashSet<>();
    votedItems.addAll(votes);

    int numVotes = 0;
    String winner = null;

    for (String item : votedItems) {
      int count = Collections.frequency(votes, item);
      if (numVotes < count) {
        numVotes = count;
        winner = String.format("%s received the most votes!", item);
      } else if (numVotes == count) {
        winner = "Tie for the winner, a re-vote is needed";
      }
    }

    return winner;
  }
}
