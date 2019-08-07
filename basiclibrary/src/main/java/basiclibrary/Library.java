package basiclibrary;

public class Library {
    public static int[] roll(int n) {
        int[] rolls = new int[n];

        for (int i = 0; i < rolls.length; i++){
            int ranRoll = (int)Math.ceil(Math.random() * 6);
            rolls[i] = ranRoll;
        }

        return rolls;
    }

    public static boolean containsDuplicates(int[] arr) {
        if (arr.length == 0) return false;

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return true;
                }
            }
        }

        return false;
    }

    public static double calculateAverages(int[] arr) {
        if (arr.length == 0) return 0.0;

        double average = 0.0;
        for (int num : arr) {
            average += num;
        }

        return average / arr.length;
    }

    public static int[] arrayOfArrays(int[][] arr) {
        if (arr.length == 0) return new int[]{};

        double lowestAvg = calculateAverages(arr[0]);
        int index = 0;
        int count = 0;

        for (int i = count + 1; i < arr.length; i++) {
            double lowestAvgCheck = calculateAverages(arr[i]);
            if (lowestAvgCheck < lowestAvg) {
                lowestAvg = lowestAvgCheck;
                index = i;
            }
        }

        return arr[index];
    }
}
