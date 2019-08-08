package basiclibrary;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class Lab03Test {
  @Test
  public void testWeatherData_FullMonth() {
    int[][] weeklyMonthTemperatures = {
        {66, 64, 58, 65, 71, 57, 60},
        {57, 65, 65, 70, 72, 65, 51},
        {55, 54, 60, 53, 59, 57, 61},
        {65, 56, 55, 52, 55, 62, 57}
    };

    assertEquals(
        "FullMonth : produced data is not outputted correctly",
        "High: 72\n" +
            "Low: 51\n" +
            "Never saw temperature: 63\n" +
            "Never saw temperature: 67\n" +
            "Never saw temperature: 68\n" +
            "Never saw temperature: 69\n",
        Lab03.weatherData(weeklyMonthTemperatures));
  }

  @Test
  public void testWeatherData_EmptyMonth() {
    int[][] weeklyMonthTemperatures = {{}, {}, {}, {}};

    assertEquals(
        "EmptyMonth : should return '0'",
        "0",
        Lab03.weatherData(weeklyMonthTemperatures)
    );
  }

  @Test
  public void testWeatherData_OneEmptyWeek() {
    int[][] weeklyMonthTemperatures = {
        {},
        {57, 65, 65, 70, 72, 65, 51},
        {55, 54, 60, 53, 59, 57, 61},
        {65, 56, 55, 52, 55, 62, 57}
    };

    assertEquals(
        "OneEmptyWeek : incorrect values",
        "High: 72\n" +
            "Low: 51\n" +
            "Never saw temperature: 58\n" +
            "Never saw temperature: 63\n" +
            "Never saw temperature: 64\n" +
            "Never saw temperature: 66\n" +
            "Never saw temperature: 67\n" +
            "Never saw temperature: 68\n" +
            "Never saw temperature: 69\n" +
            "Never saw temperature: 71\n",
        Lab03.weatherData(weeklyMonthTemperatures)
    );
  }

  @Test
  public void testTally_OneWinner() {
    List<String> votes = new ArrayList<>();
    votes.add("Bush");
    votes.add("Bush");
    votes.add("Bush");
    votes.add("Shrub");
    votes.add("Hedge");
    votes.add("Shrub");
    votes.add("Bush");
    votes.add("Hedge");
    votes.add("Bush");

    assertEquals(
        "OneWinner should return 'Bush'",
        "Bush received the most votes!",
        Lab03.tally(votes)
    );
  }

  @Test
  public void testTally_NoVotes() {
    List<String> votes = new ArrayList<>();

    assertEquals(
        "testTally should return 'Bush'",
        "0",
        Lab03.tally(votes)
    );
  }

  @Test
  public void testTally_TieForWinner() {
    List<String> votes = new ArrayList<>();
    votes.add("Bush");
    votes.add("Bush");
    votes.add("Bush");
    votes.add("Shrub");
    votes.add("Shrub");
    votes.add("Shrub");
    votes.add("Bush");
    votes.add("Hedge");
    votes.add("Shrub");

    assertEquals(
        "TieForWinner should return 'Bush'",
        "Tie for the winner, a re-vote is needed",
        Lab03.tally(votes)
    );
  }
}