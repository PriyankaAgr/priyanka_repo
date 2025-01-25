package org.dsa.incubation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER n
     *  3. INTEGER k
     */

    public static String highestValuePalindrome(String s, int n, int k) {
        // Write your code here

        char[] num = s.toCharArray();
        boolean[] changed = new boolean[n];

        int left = 0, right = n - 1;
        while (left < right) {
            if (num[left] != num[right]) {
                char maxChar = (char) Math.max(num[left], num[right]);
                num[left] = maxChar;
                num[right] = maxChar;
                changed[left] = true;
                k--;
            }
            left++;
            right--;
        }

        // If we used more changes than allowed, return -1
        if (k < 0) {
            return "-1";
        }

        left = 0;
        right = n - 1;
        while (left <= right && k > 0) {
            if (left == right) {
                if (num[left] != '9' && k > 0) {
                    num[left] = '9';
                    k--;
                }
            } else {
                if (num[left] != '9') {
                    if (changed[left] && k >= 1) {
                        num[left] = '9';
                        num[right] = '9';
                        k--;
                    } else if (!changed[left] && k >= 2) {
                        num[left] = '9';
                        num[right] = '9';
                        k -= 2;
                    }
                }
            }
            left++;
            right--;
        }

        return new String(num);
    }


}

public class HighestValuePalindrome {
    public static void main(String[] args) throws IOException {
        String s = "";
        int n=12321;
        int k=1;

        String result = Result.highestValuePalindrome(s,n, k);

    }
}
