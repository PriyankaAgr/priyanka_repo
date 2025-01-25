package org.example.dsa;

public class SubsetMindiff {

    static int countSubsets(int[] v, int i, int S2,
                            int currentSum)
    {
        if (currentSum == S2) {
            return 1;
        }
        if (i >= v.length) {
            return 0;
        }

        if (currentSum + v[i] > S2) {
            return countSubsets(v, i + 1, S2, currentSum);
        }
        else {
            return countSubsets(v, i + 1, S2, currentSum + v[i])
                    + countSubsets(v, i + 1, S2, currentSum);
        }
    }
    static int countSub(int[] vp, int N) {
        int min = Integer.MAX_VALUE;
        int sum = 0; // Calculating total sum
        for (int value : vp)
            sum += value;
        int diff = 0;
        while (true) {
            if (sum - diff < 0 || (sum - diff) % 2 == 1) {
                min = Integer.min(min, countSubsets(vp, 0, (sum - diff) / 2, 0));

            }
            if(min<Integer.MAX_VALUE){
                return min;
            }

            diff++;

        }
        //return min;
    }


    // Driver code
    public static void main(String[] args)
    {
        int N = 4;
        int[] arr = {3,9,7,3};

        System.out.print(countSub(arr, N));
    }
}
