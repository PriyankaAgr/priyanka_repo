package org.example.dsa;


public class DuplicateEachOccToZero {
    public static void main(String[] args) {
        int[] input = {1, 0, 2, 0, 0, 4, 5, 0};
        //count no of zeros
        int countZero =0;
        for(int num: input){
            if(num==0){
                countZero++;
            }
        }

        for (int i = 0; i < input.length; i++) {
            if (input[i] == 0) {
                for (int j = input.length - 2; j > i; j--) {
                    input[j + 1] = input[j];
                }
                input[i + 1] = 0;
                i++;
            }
        }
        for (int i : input) {
            System.out.println(i);
        }
    }
}