package org.example.dsa;

public class CardHand {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        // Count the occurrences of each element .We can take the help of array instead PQ
        int[] count = new int[100000]; // Assuming maximum card value
        for (int card : hand) {
            count[card]++;
        }
        // Process each group
        for (int card : hand) {
            if (count[card] > 0) {
                for (int i = 0; i < groupSize; i++) {
                    if (count[card + i] == 0) {
                        return false; // Missing card in group
                    }
                    count[card + i]--; // Reduce count
                }
            }
        }
        return true;
    }
}