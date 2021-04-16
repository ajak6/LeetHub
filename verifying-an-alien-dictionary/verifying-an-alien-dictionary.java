class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        
        //what is length is shorter/ - this case will only hit whe3n rest iof te string is same as thjat of other string
        //the first different character you encounter you wnat will determine if the order is correct or not according todictionary.
        
        //one you ware bgood just break abnd move to next index whic iwll be ciompare tio next index.
        
        Map<Character, Integer> map = new HashMap<>();
        //we can store the index of each char and retrieve with o1 when comparing.
        for(int i =0 ; i< order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        
        System.out.println(map);
        for(int i =0 ; i < words.length-1; i++){
            
            String word1=words[i];
            String word2=words[i+1];
            if(!compare(word1, word2, map)){
                return false;
            }
            
        }
        return true;
    }
  
    public boolean compare(String word1, String word2, Map<Character,Integer> map) {
        
        int i=0, j =0;
        while(i<word1.length() && j < word2.length()){
            
            char a = word1.charAt(i++);
            char b = word2.charAt(j++);
            //first character which is smaller ensures we are sorted
            if(map.get(a) < map.get(b))return true;
            //wrong order
            else if (map.get(a) > map.get(b)) return false;
            
        }
        // vblank case 
        // handle as a special case?
        // if(j==word2.length() && i != word1.length()) return false; //wont work for abcd abe
        // it means we are not able 
        if(j != word2.length() && i == word1.length()) return true; // abc abcd
        if(j == word2.length() && i == word1.length()) return true; // abc abc
        return false;
    }
}