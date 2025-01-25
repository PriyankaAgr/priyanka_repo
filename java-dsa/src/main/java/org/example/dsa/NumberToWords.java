package org.example.dsa;

public class NumberToWords {


    private static final String[] TWENTY = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"};

    private static final String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    private static final String[] THOUSANDS = {"", "Thousand"};

    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        String subAns =  helper(num);
        return subAns.trim();
    }

    private String helper(int num) {
        if (num < 20) {
            return TWENTY[num] + " ";
        } else if (num < 100) {
            return TENS[num / 10] + " " + helper(num % 10);
        } else if (num < 1000) {
            return TWENTY[num / 100] + " Hundred " + helper(num % 100);
        } else {
            for (int i = 1; i < THOUSANDS.length; i++) {
                if (num < Math.pow(1000, i + 1)) {
                    return helper(num / (int)Math.pow(1000, i)) + THOUSANDS[i] + " " + helper(num % (int)Math.pow(1000, i));
                }
            }
        }
        return "";
    }
}