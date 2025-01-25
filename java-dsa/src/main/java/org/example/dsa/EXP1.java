package org.example.dsa;

/**Given towers in an array of size n, find the count of visible towers to the left and right of each tower.
 * A tower x is visible from tower y if all the intermediate towers between x and y are strictly less in height
 * than x. Given a example : towers[n] = 1 5 6 3 1 8 8 15   → From tower 2 (i.e. of height 6), 5, 3, 8, 15 are
 * visible so answer for 6 will be 4 (count).
towers[n] = 5 3 1 6 2 10 12 13 → 5 - 3, 6, 10, 12, 13 | 3- 5, 1,6, 10, 12,13 | 1 - 3,5, 6,10,12,13

public class EXP1 {
    public static void main(String[] args){
        int[] tower = {1, 5, 6, 3, 1, 8, 8, 15 };
        int n= tower.length;
        int[] dp = new int[tower.length];
        for(int i=n-1;i>=0;i--){
            dp[i]=Math.max(dp[i],tower[i]);


        }
    }
    **/
class ObjComp

    {
        int var = 20;

        public static void main(String [] args )

        {

            int result = 0;

            ObjComp oc = new ObjComp();
            oc.var=20;

            Object o = new ObjComp();

            if (o == oc)

                result = 1;

            if (o != oc)

                result = result + 10;

            if (o.equals(oc) )

                result = result + 100;

            if (oc.equals(o) )

                result = result + 1000;

            System.out.println("result = " + result);

        }

    }
