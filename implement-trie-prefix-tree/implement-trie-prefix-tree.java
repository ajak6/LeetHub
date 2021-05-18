class Trie {
    Map<Character, Trie> nodes;
    boolean isWord;
    /** Initialize your data structure here. */
    public Trie() {
        nodes = new HashMap<>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Map<Character, Trie> tempNodes = nodes;
        for(int i =0; i < word.length(); i++) {
            char c = word.charAt(i);
            Trie n = new Trie();
            if(!tempNodes.containsKey(c)){
                tempNodes.put(c,n);
            }
            n=tempNodes.get(c);
            tempNodes = n.nodes;
            if(i==word.length()-1){
                n.isWord=true;
            }
        }
        
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word.isEmpty())return false;
        // System.out.println("Search of "+ word);
        Map<Character, Trie> tempNodes = nodes;
        Trie node = null;
        for(int i=0; i < word.length(); i++) {
            char c = word.charAt(i);
            node = tempNodes.get(c);
            // System.out.println("char "+ c + " node "+ node.nodes);
            if(node == null) return false;
            tempNodes = node.nodes;
        }
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = null;
        Map<Character, Trie> tempTrie = nodes;
        for(int i =0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if(tempTrie.containsKey(c)){
                node = tempTrie.get(c);
                tempTrie = node.nodes;
            } else {
                return false;
            }
        }
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */