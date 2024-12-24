import java.util.*;
import java.util.stream.Collectors;

/**
 * to
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * Example 1: Input: strs = ["eat","tea","tan","ate","nat","bat"] Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * n m o(n*mlogn)
 */
//aet
  //  aet
    //eat  e1a1t1 tea t1e1a1 ate



public class AtlasianTest {

    public static void main(String[] args) {
        String[] arr = {"eat","tea","tan","ate","nat","bat"};
        int n = arr.length;
        List<List<String>> res = groupAnagram(arr,n);
       for(List<String> list : res){
           System.out.print("[");

           list.stream().forEach(r->System.out.print(r+","));
            System.out.print("]");
        }
    }

    private static List<List<String>> groupAnagram(String[] arr, int n) {
        Map<String, List<String>> hm = new HashMap<>();
        int[] freq = new int[26];

        for(int i=0; i<n;i++){
            String str = arr[i];
            StringBuilder sb = new StringBuilder();
            for(char ch : str.toCharArray()){
                freq[ch-'a']++;

            }
            for(int j=0; j<26;j++){
                if(freq[j]>0){
                    sb.append((char)(j+'a')).append(freq[j]);

                }
            }
            hm.computeIfAbsent(sb.toString(), k->new ArrayList<>()).add(str);
            freq = new int[26];
        }


        return hm.values().stream().toList();



    }
}
/*
List<integer> list;
Deque<Integer> pq;
pq -> 3 9 11 12 20 15 7
boolean leftToright=false;
while(!pq.empty()){
List<integer> list;

int size = pq.size();
    for(
int i = 0;
i<size;i++){
int v = pq.poll();
list.add(v);
        if(v.left!=null){
        pq.add(left);
            }
                    if(v.right!=null)
        pq.add(right);
        }
                }
leftTort=false;

if(!leftTort)
    Coolections.reverse(list);
//print list;


        }
        }
         9 20

11 12


print  20 9*/
