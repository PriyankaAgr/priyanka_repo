import java.util.Arrays;

public class LongestAirthmatic {
    public static void main(String[] args){
        int arr[] = new int[]{18, 26, 18, 24, 24, 20, 22};
        Arrays.sort(arr);
        int res = 0;
//        for(int i =0;i<arr.length;i++){
//            for(int j =i+1;j < arr.length;j++){
//                int diff = arr[j] - arr[i];
//                res = Math.max(res , 2 + airthmaticSolve(i,diff,arr));
//            }
//        }
        res = solveByTabulation(arr);
        System.out.println(res);
    }
    public static int airthmaticSolve(int i , int diff,int arr[]){
        if(i < 0)
            return 0;
        int ans = 0;
        for(int  k = i -1;k >=0;k--){
            if(arr[i] - arr[k] == diff){
                ans = Math.max(ans , 1 + airthmaticSolve(k, diff,arr));
            }
        }
        return ans;
    }

    public static int solveByTabulation(int arr[]){
        int[][] dp = new int[1001][1001];
        //Arrays.fill(dp,1);
        int res = 0;
        for(int i =1;i<arr.length;i++){
            for(int  j = 0;j<i;j++){
                int diff = arr[i] - arr[j];

                dp[i][diff]=dp[j][diff]+1;
                res = Math.max(res,dp[i][diff]);
            }
        }
        return res+1;
    }
}