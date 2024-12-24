import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array arr of size N and an integer K.
 * The task is to find the pair of integers such that their sum is maximum and but less than K
 * Examples:
 * Input : arr = {30, 20, 50} , K = 70
 * Output : 30, 20
 * 30 + 20 = 50, which is the maximum possible sum which is less than K
 *
 * Input : arr = {5, 20, 110, 100, 10}, K = 85
 * Output : 20, 10
 * 5 10 20 100 110
 */

public class CodingTest {

    public static void main(String[] args) {
        int[] arr = {30, 20, 50};
        int K=70;
        int n = arr.length;
        Arrays.sort(arr);
        findPairSum(arr,K,n);
        String s1 = "John";
        String s2 = new String ("John");
        HashMap<String, Integer> map = new HashMap<>();
        map.put(s1,20);
        map.put(s2,30);
        System.out.println(map.size());
    }

    private static void findPairSum(int[] arr, int k, int n) {
        int max = -1;
        int[] res = new int[2];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum = arr[i]+arr[j];
                if(sum<k && sum>max){
                    max = Math.max(max, sum);
                    res[0]=arr[i];
                    res[1]=arr[j];

                }
            }
        }
        System.out.println("{"+ res[0]+","+res[1]+"}");


    }

}
