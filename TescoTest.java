import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Tesco has around 3200 stores and more than 10% of the stores have around 800 colleagues each.
 *
 * In a store, a colleague can work for multiple departments. Here are shifts of a colleague in various departments:
 *
 * In Bakery department: From 8 to 10
 * In Checkout department: From 10 to 12
 * In Diary department: From 14 to 19
 *
 * Given the above split of shifts,
 * provide an API/method to return the different shifts of a colleague for the day after merging contiguous shifts.
 * This will be exposed to the colleague in different UI and help them plan their day accordingly.
 * has context menu
 */
public class TescoTest {
    public static void main(String[] args) {
//14 to 19, 8 to 10, 10 to 12
        //8 to 10, 9 to 12, 11 to 15
        //
        int[][] shifts = {{8,10}, {9,12}, {11,15}};
        int n = shifts.length;
        int[][] plannedShifts = generatePlannedShifts(shifts, n);
        System.out.println("The planned shifts for a colleague is:");
        Arrays.stream(plannedShifts).forEach(r-> System.out.println("{"+r[0]+ ","+r[1]+"}"));


    }

    private static int[][] generatePlannedShifts(int[][] shifts, int n) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(shifts, (a,b)-> a[0]-b[0]);
        list.add(shifts[0]);
        for(int i=1; i<n;i++) {
            int[] firstShift = list.getLast();

            if (shifts[i][0] <= firstShift[1]) {
               // list.add(new int[]{shifts[i][0], });
                firstShift[1]= Math.max(firstShift[1], shifts[i][1]);
            } else {
                list.add(shifts[i]);

            }
        }

        return list.toArray(new int[list.size()][2]);
    }


    public void TestGenerateShifts(){

        int[][] shifts = {{8,10}, {9,12}, {11,15}};
        int n = shifts.length;

        int[][]  resShift = generatePlannedShifts(shifts, n);
        int[][] expected = {{8,15}};
        Assert.assertArrayEquals(expected,resShift);



    }

    public void TestGenerateShifts_NegativeTest(){

        int[][] shifts = {{-8,10}, {9,-12}, {11,15}};
        int n = shifts.length;

        int[][]  resShift = generatePlannedShifts(shifts, n);
        int[][] expected = {{-12,15}, {11,15}};
        //Assert.assertArrayEquals(expected,resShift);
       // Assert.assertTrue();



    }
}
