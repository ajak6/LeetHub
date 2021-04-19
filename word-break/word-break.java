class Solution {
    public boolean wordBreak1(String s, List<String> wordDict) {
        if(s.isBlank())return true;
        //word dict
        //you have dict in hashset
        //recursively you create a substruing if it is fgoun in the wordDict you recurse wth the left move string and see if recurison returns true
        //base condition is hwne you are end wupw ith an empty string.
        // System.out.println(s);
        if(map.containsKey(s)) return map.get(s);
        HashSet<String> set = new HashSet<>(wordDict);
        for(int i=1; i < s.length()+1; i++){
            
            if(set.contains(s.substring(0, i)) && wordBreak(s.substring(i), wordDict)){
                map.put(s, true);
                return true;
            }
            
        }
       map.put(s, false);
       return false;
    }
    HashMap<String, Boolean> map = new HashMap<>();
    // on every call you need to find that a string can be normalized or not if we store the string result that should be enough
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean dp [] = new boolean[s.length()];
        // dp[0]=true; // 0 to 0 is true for blank string // what is blank should also be present in the dict to be valuie
        //still we will consider this is as a base case if the first  input isblank then return is as is.
        
        
        
        // dp[i] represent whether 0,i can be broken into valid words
        for(int i=0;i < s.length(); i++){
            
            for(int j =0; j <=i; j++) {
                
                String sub = s.substring(j, i +1); //check every char from 0 to i whether that string is present ort not
                //if present the nthe dp befrore j shopuild betrue
                
                if(set.contains(sub) && (j==0 ||dp[j-1]) ) {
                    dp[i]=true;
                }
                
            }
        }
        return dp[dp.length-1];
    }
    
    
    //can we do bottom up if we want to results we will not know which is the complete cain of words that are broken to find that it is true.
    
    //every string can only be brokjen when the previous indedx is valid and can be brokenm in top valid stirng.
    // so you check a character
        
        // dp[i][j] means characters starting at i and ending at j are valid when  
    
    
}