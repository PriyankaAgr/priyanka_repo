package org.dsa.incubation;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Stream;

public class Median {

    TreeSet<Integer> minHeap;
    TreeSet<Integer> maxHeap;

    public double[] medianSlidingWindow(int[] nums, int k) {
        Comparator<Integer> comparator = (a, b) -> {
            if (nums[a] != nums[b]) return Integer.compare(nums[a], nums[b]);
            return Integer.compare(a, b);
        };
        maxHeap = new TreeSet<>(comparator.reversed());
        minHeap = new TreeSet<>(comparator);

        double[] result = new double[nums.length - k + 1];
        int ans = 0;
        char[] tasks = {'A','A','A','B','B','B'};

        List<Character> task = new String(tasks).chars() // Convert char array to IntStream
                .distinct() // Get distinct values
                .mapToObj(c -> (char) c).toList(); // Convert back to Character

        for (int i = 0; i < nums.length; i++) {
            if (i >= k) {
                minHeap.remove(i - k);
                maxHeap.remove(i - k);
            }

            // Add new element to the minHeap first
            minHeap.add(i);

            // Move the largest element from minHeap to maxHeap
            maxHeap.add(minHeap.pollFirst());

            // Balance the heaps
            balanceHeaps();

            // If we have processed at least k elements, add the median to result
            if (i >= k - 1) {
                result[ans++] = getMedian(nums, k);
            }
        }

        return result;
    }

    private void balanceHeaps() {
        // Ensure maxHeap does not have more elements than minHeap
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(maxHeap.pollFirst());
        }
    }

    private double getMedian(int[] nums, int k) {
        // If the window size is even, the median is the average of the middle two elements
        if (k % 2 == 0) {
            return ((double) nums[minHeap.first()] + nums[maxHeap.first()]) / 2;
        } else {
            // If the window size is odd, the median is the middle element
            return (double) nums[minHeap.first()];
        }
    }
}