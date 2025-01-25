

class TrieNode {
    TrieNode[] child;
    boolean isEnd;
    int cnt;
    int startWith;
    public TrieNode() {
        this.child = new TrieNode[26];
        this.isEnd = false;
        this.cnt = 0;
        this.startWith = 0;
    }
}
class Trie {
    TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    public void insert(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';
            if(curr.child[index] == null) {
                curr.child[index] = new TrieNode();
            }
            curr = curr.child[index];
            curr.startWith += 1;
        }
        curr.isEnd = true;
        curr.cnt += 1;
        curr.startWith -= 1;
    }
    public int countWordsEqualTo(String word) {
        TrieNode curr = root;
        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';
            if(curr.child[index] == null) {
                return 0;
            }
            curr = curr.child[index];
        }
        return curr.cnt;
    }
    public int countWordsStartingWith(String prefix) {
        // lets find that prefix
        TrieNode curr = root;
        for(int i=0;i<prefix.length();i++) {
            int index = prefix.charAt(i) - 'a';
            if(curr.child[index] == null) return 0;
            curr = curr.child[index];
        }
        return curr.startWith;
    }
    public void erase(String word) {
        TrieNode curr = root;
        //is this word present
        boolean present = true;
        for(int i=0;i<word.length();i++) {
            int index = word.charAt(i) - 'a';
            if(curr.child[index] == null) {
                present = false;
                break;
            }
            curr = curr.child[index];
        }
        if(curr.isEnd == false) {
            present = false;
        }
        curr = root;
        if(present) {
            for(int i=0;i<word.length();i++) {
                int index = word.charAt(i) - 'a';
                if(curr.child[index] == null) return;
                curr = curr.child[index];
                if(curr.startWith > 0) {
                    curr.startWith -= 1;
                }
            }
            if(curr.cnt > 0) {
                curr.cnt -= 1;
                if(curr.cnt == 0){
                    curr.isEnd = false;
                }
            }
        }
    }
}
 
 