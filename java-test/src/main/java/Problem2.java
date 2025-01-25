import java.util.ArrayList;
import java.util.List;

/**
 * Input: words = ["abcd","dcba","lls","s","sssll"]
 * Output: [[0,1],[1,0],[3,2],[2,4]]
 * Explanation:
 * The palindromes are ["dcbaabcd","abcddcba","slls","llssssll"]
 */

public class Problem2 {

    public static void main(String[] args) {
    String[] words = {"abcd","dcba","lls","s","sssll"};
    List<int[]> list = new ArrayList<>();
    int n = words.length;
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            String s1 = words[i]+words[j];
            String s2 = words[j]+words[i];
            if(isPalin(s1)){
                list.add(new int[]{i,j});
            }
            if(isPalin(s2)){
                list.add(new int[]{j,i});

            }


        }

    }
    list.forEach(l->System.out.println("["+l[0]+","+l[1]+"]"));

    }

    static boolean isPalin(String str){
        if(str.equals(new StringBuilder(str).reverse().toString()))
            return true;
        else return false;
    }



}
