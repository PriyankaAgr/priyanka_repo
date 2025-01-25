package org.example.dsa;


/**
 *
 Input: height = [1,8,6,2,5,4,8,3,7]
 Output: 49

 Input: height = [1,1]
 Output: 1


 */
public class JavaIntrvw {

    public static void main(String[] args) {
        int[] ht = {1,8,6,12,5,4,8,13,7};
        int n = ht.length;
        System.out.println(findMaxWater(ht,n));

    }

    private static int findMaxWater(int[] ht, int n) {

        int max = 0;

        int hl=0;
        int hr=0;
        int i=0,j=n-1;
        while(i<j){
            if(ht[i]>=hl){
                hl=ht[i];
            }
            if(ht[j]>hr){
                hr=ht[j];
            }
            max=Math.max(max,Math.min(hl,hr)*j-i+1);
            i++;j--;

        }
        return max;
    }


}
