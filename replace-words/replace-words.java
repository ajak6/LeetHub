class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // disctionay has the root words
        // sentency may contain the successor words
        // if not found leave it as is
        // for each word in a sentence we need to know which root word matches it,
        // even if it matches multiple we want the shortest one fels like greedy whichever matches first just pic that
        // brute force pick each word in sentency the ntry all roots and see the min lenght which matched.
        // sort the root words by length and first mathcing works
        // add each root word in the dic to trie
        // fr each word in the sentence try to see if it matches any word as we trverse. if the prefix exists
        // we need to get the word from that  node this will and we can modify the list as is with the new workd
        // Questions : all small characters?
        // cabn the root word have space like a root prefix
        Trie trie = new Trie();
        for(String root : dictionary) {
            trie.addword(root);
        }
        String words [] = sentence.split(" ");
        for(int i =0 ; i < words.length ; i++){
            String word = words[i];
            String root = trie.searchPrefix(word);
            if(root!=null){
                words[i]=root;
            }
        }
        StringBuilder builder = new StringBuilder();
        for(int i =0 ; i < words.length ; i++){
            builder.append(words[i]);
            if(i<words.length-1)
                builder.append(" ");
        }
        return builder.toString();
        
        
    }
    
    class Trie{
        TrieNode root;
        
        public Trie(){
            root = new TrieNode();
        }
        public void addword(String s) {
            TrieNode node = root;
            for(char c: s.toCharArray()) {   
                
                if(node.chars[c-'a'] == null){
                    node.chars[c-'a'] = new TrieNode();
                }
                node=node.chars[c-'a'];
            }
            node.isWord=true;
            node.word=s;
        }
        
        public String searchPrefix(String s){
            TrieNode node =root;
            for(char c: s.toCharArray()) {
                node = node.chars[c-'a'];
                if(node==null)return null;
                if(node.isWord){
                    return node.word;
                }
            }
            return null;
            
            
        }
    }
    
    class TrieNode {
        TrieNode [] chars;
        boolean isWord;
        String word;
        public TrieNode(){
            chars = new TrieNode[26];
        }
    }
}