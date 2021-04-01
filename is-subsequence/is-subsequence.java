class Solution {
    public boolean isSubsequence(String s, String t) {
        
        //brute force
        //pick the smaller string and find it in bugger string
        // char c in s find it in t once found find the rest in t.sub
        //if all found then return true;
        
        return search(s, 0, t , 0);
        
    }
    
    public boolean search(String s, int i, String t, int j){
        if(i == s.length()) return true;
        char search = s.charAt(i);
        
        for(int x=j; x< t.length(); x++) {
            if(t.charAt(x)==search){
                if(search(s, i+1, t, x+1)){
                    return true;
                }
            }
           
        }
        return false;
    }
}