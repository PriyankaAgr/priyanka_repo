import java.util.ArrayDeque;
import java.util.LinkedHashSet;
import java.util.Set;

class MagicDictionary {

    Trie trie = new Trie();

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {

        for(String str : dictionary){
            trie.add(str);

        }

    }

    public boolean search(String searchWord) {
        return trie.search(searchWord, 1);


    }

    public static void main(String[] args) {
        MagicDictionary dict = new MagicDictionary();
        dict.buildDict(new String[]{"hello", "leetcode"});
        dict.search("leetcoded");
    }
}

class Trie{
    TrieNode node;
    Trie(){
        this.node = new TrieNode();
    }

    void add(String str){
        TrieNode curr =node;
        for(char ch : str.toCharArray()){

            int idx = ch-'a';

            if(curr.child[idx]==null){
                curr.child[idx] = new TrieNode();
            }

            curr=curr.child[idx];


        }
        curr.isEnd=true;

    }

    boolean search(String str, int k){
        TrieNode curr= node;
        for(char ch : str.toCharArray()){
            if(curr.isEnd==true) break;
            int idx = ch-'a';
            if(curr==null) curr=node;
            if(curr.child[idx] == null && k==0) return false;
            else if(curr.child[idx] == null && k>0) k--;
             curr=curr.child[idx];
        }
        if(k>0) return false;

        return true;

    }


}

class TrieNode{
    char ch;
    TrieNode[] child;
    boolean isEnd;

    TrieNode(){
        child = new TrieNode[26];
        isEnd=false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */