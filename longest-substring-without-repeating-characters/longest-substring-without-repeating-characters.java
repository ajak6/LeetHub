class Solution {
    public int lengthOfLongestSubstring(String s) {
     //what if we store the count in a bit and check if the count is already 1 at that location then what?
        //use 2 pointers
        // l and r, keep increasing r and keep a count of chars
        //after each increase we check if there is any character who has a count > 2
        //if yes then 
        //brute force create all substring and check the value of each substring from the largest string first. 
        
        int l =0;
        int r=0;
        if(s==null) return 0;
        if(s.length() < 2) return s.length();
        char c[] = new char[256];
        int max = 0;
        while (r<s.length()) {
            char at = s.charAt(r);
            
            if(++c[at] >1) {
                //string length until now is what we see max without repeating characters.
                max = Math.max(max, r-l);
                
                //increment l to make this count back to leess than 1.
                while(l<r){
                    char atl = s.charAt(l);
                    c[atl]--;
                    l++;
                    if(c[at]<2)break; // if the char whose count just increased is back to less than 2 we are good to break now.
                }
            } else {
                max = Math.max(max, r-l+1);
            }
            r++;
        }
        
        //another case when we never enter
        return max;
    }
}