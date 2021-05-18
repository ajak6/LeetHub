class TrieNode{
    char val;
    TrieNode[] nodes;
    boolean isWord;
    public TrieNode(){
        nodes = new TrieNode [26];
    }
    public TrieNode getNode(char c){
        return nodes[c-'a'];
    }
    public TrieNode addNode(char c){
        if(!isPresent(c)){
            nodes[c-'a']=new TrieNode();
        }
        return nodes[c - 'a'];
    }
    public boolean isPresent(char c){
        return nodes[c-'a']!=null;
    }
}
class Trie {
    // Map<Character, Trie> nodes;
    TrieNode root;
    ;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(); 
        //let this be the root node which stores the trieNode for first character
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode tempRoot = root;
        for (int i=0; i < word.length(); i++) {
            char c = word.charAt(i);
            tempRoot = tempRoot.addNode(c);
        }
        tempRoot.isWord=true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tempRoot = root;
       for (int i=0; i < word.length(); i++) {
            char c= word.charAt(i);
            if(tempRoot.isPresent(c)){
              tempRoot=tempRoot.getNode(c);  
            } else{
                return false;    
            }
       }
        return tempRoot.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode tempRoot = root;
        for (int i=0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(tempRoot.isPresent(c)){
                tempRoot=tempRoot.getNode(c);
            } else{
                return false;
            }    
        }
        return tempRoot!=null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */