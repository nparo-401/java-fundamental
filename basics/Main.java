import java.util.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
  public static void main(String[] args) {
//    Pluralize
    int dogCount = 1;
    int catCount = 2;
    int turtleCount = 0;

    System.out.println("I own " + dogCount + " " + pluralize("dog", dogCount) + ".");
    System.out.println("I own " + catCount + " " + pluralize("cat", catCount) + ".");
    System.out.println("I own " + turtleCount + " " + pluralize("turtle", turtleCount) + ".");

//    Flip N Heads
    flipNHeads(1);
    flipNHeads(4);
    flipNHeads(6);

//    Clock
    clock();
//    clock2();
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
    while (inRow != n) {
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
    String flip = pluralize("flip", count);
    String head = pluralize("head", n);
    System.out.printf("It took %d %s to flip %d %s in a row.\n", count, flip, n, head);
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

  public static void clock2() {
    int oldSec = LocalDateTime.now().getSecond();

    while (true) {
      LocalDateTime newTime = LocalDateTime.now();
      int newHours = newTime.getHour();
      int newMin = newTime.getMinute();
      int newSec = newTime.getSecond();

      if (oldSec != newSec) {
        System.out.printf("%02d:%02d:%02d\n", newHours, newMin, newSec);
        oldSec = newSec;
      }
    }
  }
}