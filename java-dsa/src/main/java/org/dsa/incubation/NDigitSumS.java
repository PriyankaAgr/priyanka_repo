package org.dsa.incubation;

public class NDigitSumS {
    static int count = 0;

    public static void main(String[] args) {
        solve(2, 2);
    }

    public static int solve(int A, int B) {

        helper(A, B, 0,0, 0);
        return count;
    }

    public static void helper(int N, int s,int sum, int j, int len) {

        if (len > N) return;
        if (sum >= s) {
            if (sum == s && len == N) {
                count++;
                sum = 0;
            }
            return;
        }

        for (int i = 9; i >=0; i--) {

            helper(N, s, sum+i, i, len+1);

        }
    }

}
