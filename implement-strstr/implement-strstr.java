class Solution {
    public int strStr(String haystack, String needle) {
        
        //find the index of needle in haystack string
        //possible string matching questino
        //brute force start iwth every char and try to match with needle
        //start looking if needle char keeps matching if not reset index
// of needle and keep traversing haystack.
        // it is possible that we have to go back to previous index + 1 in haystack else we may loose for cases like aaab matching with aab
        //complexity will be H*N
        int h=0;
        if(haystack.isEmpty() && needle.isEmpty()) return 0;
        if(needle.isEmpty()) return 0;
        while(h  < haystack.length()) {
            
            if(needle.charAt(0)==haystack.charAt(h)){
                if(tryMatch(haystack, needle, h)){
                    return h;
                }
            }
            h++;
        }
        return -1;
    }
    
    public boolean tryMatch(String haystack, String needle, int i){
        
        //if first char and last char match then there is point in matching
        // or you match from start and end to do it faster as well
        //h(i+n) == n(n) and (n.length()+i< h.length() and h(i+n.length()-n) == n(n.length()-n)
        int nStart = 0;
        int nEnd = needle.length()-1;
        while(nStart <= nEnd) {
            if(((haystack.length() <= i+nEnd) || !(haystack.charAt(i+nStart) == needle.charAt(nStart) && haystack.charAt(i + nEnd)== needle.charAt(nEnd)))){
                return false;
            } 
            nStart++;
            nEnd--;
        }
        return true;
    }
}