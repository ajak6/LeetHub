class TrieNode {
    TrieNode children [];
    boolean isWord;
    char val;
    public TrieNode(){
        val=' ';
        children = new TrieNode[26];
    }
}

class Trie {
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    // abcd
    public void insert(String word) {
        TrieNode node = root;
        for(int i =0; i < word.length();i++) {
            char c = word.charAt(i);
            if(node.children[c-'a'] == null){
                node.children[c-'a']= new TrieNode();
            } 
            node = node.children[c-'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            
            node=node.children[c-'a'];
            if(node==null)return false;
        }
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
            TrieNode node =root;
        for (char c: prefix.toCharArray()) {
            if(node==null)return false;
            node=node.children[c-'a'];
        }
        return node!=null;
        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */