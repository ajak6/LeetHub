class Solution {
    public int isPrefixOfWord(String s, String w) {
        //traverse fron left to right
        // keep matching if it breaks you have to restart from the hnexti ndex here you started searching which increase the complexity
        int word =1;
        boolean startWord = true;
        for (int i =0 ; i < s.length(); i++) {
            if(s.charAt(i)==' ') {
                word++;
                startWord= true;
            }
            
            else if(startWord && s.charAt(i) == w.charAt(0)){
                startWord=false;
                //start matching from i and 
                if(match(s,i, w)){
                    return word;
                }
            }else{
                startWord=false;
            }
        }
        return -1;
    }
    public boolean match(String s, int i, String w){
        int wC=0;
        while(i < s.length() && wC < w.length()){
            if(s.charAt(i)!=w.charAt(wC)) return false;
            wC++;
            i++;
        }
        return true;
    }
}