import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
  public static void main(String[] args) {
//    Pluralize
    int dogCount = 1;
    int catCount = 2;
    int turtleCount = 0;

    System.out.printf("I own %d %s.\n", dogCount, pluralize("dog", dogCount));
    System.out.printf("I own %d %s.\n", catCount, pluralize("cat", catCount));
    System.out.printf("I own %d %s.\n", turtleCount, pluralize("turtle", turtleCount));

//    Flip N Heads
    flipNHeads(1);
    flipNHeads(4);
    flipNHeads(-6);

//    Clock
    clock();
  }

  public static String pluralize(String toPlural, int count) {
    if (count == 1) {
      return toPlural;
    }
    return toPlural + "s";
  }

  public static void flipNHeads(int n) {
    int count = 0;
    int inRow = 0;
    while (inRow < n) {
      double randFlip = Math.random();
      if (randFlip < 0.5) {
        inRow = 0;
        System.out.println("tails");
      } else {
        inRow++;
        System.out.println("heads");
      }
      count++;
    }
    System.out.printf("It took %d %s to flip %d %s in a row.\n", count, pluralize("flip", count), n, pluralize("head", n));
  }

  public static void clock() {
    int delay = 0;
    int interval = 1000;
    Timer timer = new Timer();
    String pattern = "HH:mm:ss";

    TimerTask task = new TimerTask() {
      public void run() {
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern)));
      }
    };
    timer.scheduleAtFixedRate(task, delay, interval);
  }
}
