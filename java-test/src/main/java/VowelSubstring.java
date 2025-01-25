/**
 * Input: s = "leetcode", k = 3
 * Output: 2
 */

public class VowelSubstring {

    public static void main(String[] args) {
        String str = "leetcode";

        int k=3;

        System.out.println(findMaxVowel(str,k));

    }

    public static int findMaxVowel(String s, int k){
        char[] arr = s.toCharArray();
        int st=0,e=0;
        int max=0;
        int ctr=0;
        while(e<=s.length()-k){
            if(isVowel(arr[e++]))
                ctr++;

            if((e-st)==k){
                max = Math.max(max, ctr);
                if(isVowel(s.charAt(st)))
                    ctr--;;
                st++;
            }

        }
        return max;

    }

    static boolean isVowel(char ch){
        if(ch=='a' || ch == 'e' || ch=='i' ||ch=='o' || ch=='u'){
            return true;
        }
        return false;
    }
}
