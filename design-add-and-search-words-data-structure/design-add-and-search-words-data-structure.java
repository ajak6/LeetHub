class Trie {
   
    Map<Character, Trie> trieMap = new HashMap<>();
    boolean isWord = false;
    char value;
    public Trie(char c){
        value= c;
    }
    public Trie(){
        new Trie(' ');
    }
    public void addWord(String word){
        Trie currTrie=null;
        Map<Character, Trie>map = trieMap;
        for(char c: word.toCharArray()){
            //for each char find the cprresponding triue
            //if we have a singel character then stil we want to get and it will return a trie
            //so basicallty heroot level trie stores nothing but just pointers to first trie.
            map.putIfAbsent(c, new Trie(c));    
            currTrie = map.get(c);
            map=currTrie.trieMap;
        }
        currTrie.isWord=true;
    }
    
    //in case of . we have to backtrack for every character. It won't work in a loop.
    public boolean search(String word) {
        Trie currTrie= null;
        Map<Character, Trie> map=trieMap;
        char proxy ='a';
        for(char c: word.toCharArray()){
            if(c=='.'){
                //try everything from a to z and keep searching until you hit a true
                
                for(char x = 'a'; x<='z'; x++){
                    c=proxy++;
                    currTrie=map.get(c);
                    if(currTrie==null)return false;
                    map=currTrie.trieMap;    
                }
            }
            
        }
        return currTrie!=null && currTrie.isWord;
    }
    
}
/*
if exact string all you have to do it add int the map
for string which will have . inthem we will need to try string of every char with  lenght and see if end at a
word. For each word will store a boolea nit is workd or not...
*/
//for each char we need a maop of maps each stores a map of char and map

class WordDictionary {
    
    Trie root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie curr = root;
        for(char c: word.toCharArray()) {
            curr.trieMap.putIfAbsent(c, new Trie(c));
            curr=curr.trieMap.get(c);
        }
        curr.isWord=true;
      }
    
    public boolean search(String word) {
        //either you write a method which takes an index which char we are searching for.
        ///so you put a and get its trie and move to next char in the string
        //when cis the last characteryou need to check the flag of that trie
        
        //in the method you send the index to search. starting fr om 0
        //now you chget its trie and chedck for next inddex until hitting a .
        // if . then loop z to z and call search fora, same index
        //     if not . then pull the trie and call search with ,
        return search (word, 0, root);
        
    }
    
    public boolean search(String word, int index, Trie root) {
        if(index==word.length()) return root!=null && root.isWord;
        if(root==null)return false;
        char c  = word.charAt(index);
        if(c=='.'){
            for(char x = 'a'; x<='z'; x++){
                if(root.trieMap.containsKey(x)){
                    if(search(word, index+1, root.trieMap.get(x))){
                        return true;
                    }
                }
            }
        } else {
            return search(word, index+1, root.trieMap.get(c));
        }
        return false;
        
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */