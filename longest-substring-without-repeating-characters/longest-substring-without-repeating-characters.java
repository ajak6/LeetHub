class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        if(s==null|| s.length()==0)return 0;
        int max_len =0; // st
        int l =0;
        int r =0;
        /* two pointer approach. starting with r and keep track of every char count,
        * if seen again count the cyrrenbt length r-l
        *move l to r and increase r to count for next char
        */
        int counts [] = new int[128];
        while(r < s.length()){
            char currChar = s.charAt(r);
            counts[currChar-' ']++;
            if(counts[currChar-' '] > 1){
                //found a duplicarte chat
                //find the curr length
                max_len = Math.max(r-l, max_len);
                //move l so that all values of counts are 1
                //pwwleg
                while(counts[currChar-' ']>1){
                    counts[s.charAt(l)-' ']--;
                    l++;
                }
            }
            r++;
            
        }
        return Math.max(r-l, max_len);
    }
}