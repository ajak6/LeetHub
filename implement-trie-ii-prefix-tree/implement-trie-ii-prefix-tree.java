class TrieNode {
    int freq;
    TrieNode nodes[];
    boolean isWord;
    int wordCount;
    public TrieNode() {
        nodes = new TrieNode[26];
        freq=0;
    }
    
    public TrieNode getNode(char c){
        if(isPresent(c)) {
          return  nodes[c-'a'];
        }
        return null;
    }
    public TrieNode addNode(char c){
        if(!isPresent(c)){
            nodes[c-'a'] = new TrieNode();
        }
        nodes[c-'a'].freq++;
        return nodes[c-'a'];
    }
    
    public boolean isPresent(char c) {
        return nodes[c-'a'] != null;
    }
     
    public int eraseChar(char c) {
        if (isPresent(c)) {
            if(--nodes[c-'a'].freq==0){
                nodes[c-'a']=null;
            }
        }
        return -1;
    }
    public int eraseWord() {
            // eraseChar(c);
        return wordCount--;
        // return -1;
    }
    
    public void setWord(){
        isWord=true;
        wordCount++;
    }
}

class Trie {
    TrieNode root;
    public Trie() {
        root=new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode temp = root;
        for(char c: word.toCharArray()) {
            if(!temp.isPresent(c)){
                temp=temp.addNode(c);
            } else{
                temp=temp.addNode(c);
            }
        }
        temp.setWord();
    }
    
    public int countWordsEqualTo(String word) {
        TrieNode temp = root;
        for(char c: word.toCharArray()) {
            temp = temp.getNode(c);
            if(temp==null)return 0;
        }
        return temp.wordCount;
    }
    
    public int countWordsStartingWith(String prefix) {
          TrieNode temp = root;
        for(char c: prefix.toCharArray()){
            temp=temp.getNode(c);
            if(temp==null)return 0;
        } 
        return temp.freq;
    }
    
    public void erase(String word) {
        TrieNode temp = root;
        for(char c: word.toCharArray()) {
            temp=temp.getNode(c);
            temp.freq--;
            // temp.eraseChar(c);  
        }
        temp.eraseWord();  
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