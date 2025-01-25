package org.example.dsa;


public class Subsetdiff {
    static int dp[][];

    static int countSubsets(int[] v, int i, int S2,
                            int currentSum)
    {
        if (currentSum == S2) {
            return 1;
        }
        if (i >= v.length) {
            return 0;
        }
        if (dp[i][currentSum] != -1) {
            return dp[i][currentSum];
        }
        if (currentSum + v[i] > S2) {
            return dp[i][currentSum] = countSubsets(v, i + 1, S2, currentSum);
        }
        else {
            return dp[i][currentSum] = countSubsets(v, i + 1, S2, currentSum + v[i])
                    + countSubsets(v, i + 1, S2, currentSum);
        }
    }
    static int countSub(int[] vp, int diff, int N)
    {
        int sum = 0;
        for (int value : vp)
            sum += value;

        if (sum - diff < 0 || (sum - diff) % 2 != 0) {
            return 0;
        }
        dp= new int[N+1][sum+1];
        for(int i = 0; i <N; i++)
        {
            for(int j = 0; j <N; j++)
            {
                dp[i][j] = -1;
            }
        }
        // s2 = (Sum-diff)/2
        return countSubsets(vp, 0, (sum - diff) / 2, 0);
    }


    public static void main(String[] args)
    {
        int N = 5;
        int[] arr = { 1, 2, 3, 1, 2 };
        int diff = 1;


        System.out.print(countSub(arr, diff, N));
    }
}

