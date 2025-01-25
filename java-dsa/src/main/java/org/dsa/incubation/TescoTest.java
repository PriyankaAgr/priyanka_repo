package org.dsa.incubation;

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

        int[][] shifts = {{8,10}, {10,12}, {14,19}};
        int n = shifts.length;
        int[][] plannedShifts = generatePlannedShifts(shifts, n);
        System.out.println("The planned shifts for a colleague is:");
        Arrays.stream(plannedShifts).forEach(r-> System.out.println("{"+r[0]+ ","+r[1]+"}"));


    }

    private static int[][] generatePlannedShifts(int[][] shifts, int n) {
        List<int[]> list = new ArrayList<>();

        for(int i=0; i<n;i++) {
            if (shifts[i + 1][0] <= shifts[i][1]) {
                list.add(new int[]{shifts[i][0], Math.max(shifts[i][1], shifts[i + 1][1])});
            } else {
                list.add(shifts[i]);

            }
        }

        return list.toArray(new int[list.size()][2]);


    }
}
