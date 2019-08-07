package basiclibrary;

import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTest {
    @Test
    public void testRoll() {
        int numRolls = 4;
        assertEquals("array length is " + numRolls, numRolls, Library.roll(numRolls).length);
    }

    @Test
    public void testRoll_ExpectedFail() {
        int numRolls = 4;
        assertNotEquals("array length is the same, should be different", numRolls, Library.roll(5).length);
    }

    @Test
    public void testRoll_EdgeCase() {
        int numRolls = 0;
        assertEquals("array length is not zero", numRolls, Library.roll(numRolls).length);
    }

    @Test
    public void testContainsDuplicate() {
        int[] testArr = new int[]{1,2,3,4,4,5};
        assertTrue("array contains duplicates", Library.containsDuplicates(testArr));
    }

    @Test
    public void testContainsDuplicate_ExpectedFail() {
        int[] testArr = new int[]{1,2,3,4,5};
        assertFalse("array does not contain duplicates", Library.containsDuplicates(testArr));
    }

    @Test
    public void testContainsDuplicate_EdgeCase() {
        int[] testArr = new int[]{};
        assertFalse("array is empty, should return false", Library.containsDuplicates(testArr));
    }

    @Test
    public void testCalculateAverages() {
        double expectedAverage = 2.0;
        int[] testArr = new int[]{1,2,3};
        assertTrue("average should be 2.0", Library.calculateAverages(testArr) == expectedAverage);
    }

    @Test
    public void testCalculateAverages_ExpectedFail() {
        double expectedAverage = 2.2;
        int[] testArr = new int[]{1,2,3,4};
        assertFalse("average should not match", Library.calculateAverages(testArr) == expectedAverage);
    }

    @Test
    public void testCalculateAverages_EdgeCase() {
        double expectedAverage = 0.0;
        int[] testArr = new int[]{};
        assertTrue("average should be 0.0", Library.calculateAverages(testArr) == expectedAverage);
    }

    @Test
    public void testArrayOfArrays() {
        int[][] testArr = new int[][]{
            {66, 64, 58, 65, 71, 57, 60}, // 63.0
            {57, 65, 65, 70, 72, 65, 51}, // 63.5714285714
            {55, 54, 60, 53, 59, 57, 61}, // 57.0
            {65, 56, 55, 52, 55, 62, 57} // 57.4285714286
        };
        assertTrue("lowest average is arr at index 2", Library.arrayOfArrays(testArr).equals(testArr[2]));
    }

    @Test
    public void testArrayOfArrays_ExpectedFail() {
        int[][] testArr = new int[][]{
            {66, 64, 58, 65, 71, 57, 60}, // 63.0
            {57, 65, 65, 70, 72, 65, 51}, // 63.5714285714
            {55, 54, 60, 53, 59, 57, 61}, // 57.0
            {65, 56, 55, 52, 55, 62, 57} // 57.4285714286
        };
        assertFalse("lowest average is arr at index 2", Library.arrayOfArrays(testArr).equals(testArr[1]));
    }

    @Test
    public void testArrayOfArrays_EdgeCase() {
        int[][] testArr = new int[][]{{},{}};
        assertTrue("lowest average is arr at index 0", Library.arrayOfArrays(testArr).equals(testArr[0]));
    }

    @Test
    public void testArrayOfArrays_EdgeCase2() {
        int[][] testArr = new int[][]{{}};
        assertTrue("lowest average arr is an empty array", Library.arrayOfArrays(testArr).equals(testArr[0]));
    }

    @Test
    public void testArrayOfArrays_EdgeCase3() {
        int[][] testArr = new int[][]{};
        assertArrayEquals(
            "lowest average arr is an empty array",
            new int[]{},
            Library.arrayOfArrays(testArr)
        );
    }

    @Test
    public void testArrayOfArrays_EdgeCase4() {
        int[][] testArr = new int[][]{{},{1,2,3}};
        assertTrue("lowest average arr is an empty array", Library.arrayOfArrays(testArr).equals(testArr[0]));
    }
}
