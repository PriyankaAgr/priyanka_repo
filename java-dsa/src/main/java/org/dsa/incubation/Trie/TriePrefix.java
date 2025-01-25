package org.dsa.incubation.Trie;

import java.util.HashMap;
import java.util.Map;

public class TriePrefix{
    public static void main(String[] args){

        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("apple");
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.println(trie.countWordsStartingWith("app"));
        trie.erase("apple");
        System.out.println(trie.countWordsEqualTo("apple"));
        System.out.println(trie.countWordsStartingWith("app"));
        trie.erase("apple");
        System.out.println(trie.countWordsStartingWith("app"));


    }
}
class Trie {
    Map<String,Integer> freqMap = new HashMap<>();
    TrieNode root;
    public Trie() {
        root=new TrieNode();


    }

    public void insert(String word) {
        root.insert(word,0);
        freqMap.put(word, freqMap.getOrDefault(word,0)+1);

    }

    public int countWordsEqualTo(String word) {
        int count=0;
        return root.search(word,0);
        //return freqMap.get(word);

    }

    public int countWordsStartingWith(String prefix) {
        int count=0;
        if(root.startsWith(prefix, 0)){
            count = freqMap.entrySet().stream().filter(e->e.getKey().startsWith(prefix)).map(Map.Entry::getValue).reduce(Integer::sum).get();
        }
        return count;

    }

    public void erase(String word) {
        root.erase(word,0);
        freqMap.put(word, freqMap.get(word)-1);

    }
}

class TrieNode{
    TrieNode[] nodes;
    boolean isEnd;
    int ctr;

    TrieNode(){
        nodes = new TrieNode[26];
    }

    void insert(String word, int idx){

        if(idx>=word.length())return;
        int i=word.charAt(idx)-'a';
        if(nodes[i]==null){
            nodes[i]=new TrieNode();
        }
        if(idx==word.length()-1){
            nodes[i].isEnd=true;
            nodes[i].ctr++;
        }
        nodes[i].insert(word,idx+1);
    }

    void erase(String word, int idx){

        if(idx>=word.length())return;
        TrieNode node = nodes[word.charAt(idx)-'a'];
        if(node==null){
            return;
        }
        if(idx==word.length()-1 && node.ctr>0) {
            node.ctr--;
            if (node.ctr == 0) {
                node.isEnd = false;
                // node.deleteNode(word,idx);
            }
            return;
        }
        node.erase(word,idx+1);
    }

    private void deleteNode(String word, int idx) {
        if(idx<0){
            return;
        }
        TrieNode node = nodes[word.charAt(idx)-'a'];

        if(node==null){
            return;
        }

        if(node.ctr>0 || node.nodes.length>0 || node.isEnd==false){
            return;
        }


        node.deleteNode(word,idx-1);

    }

    int search(String word, int idx){
        if(idx>=word.length())return 0;
        TrieNode node = nodes[word.charAt(idx)-'a'];
        if(node==null){
            return 0;
        }
        if(idx==word.length()-1 && node.isEnd){

            return node.ctr;
        }
        return node.search(word,idx+1);
    }
    boolean startsWith(String prefix, int idx){
        if(idx>=prefix.length())return false;
        TrieNode node = nodes[prefix.charAt(idx)-'a'];
        if(node==null){
            return false;
        }
        if(idx==prefix.length()-1) {
            return true;
        }
        return node.startsWith(prefix,idx+1);
    }



}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */