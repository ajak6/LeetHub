class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        
        //2 distinct charactes
        // k chars are duplicate.keep counting using right if you encounter a >1 decrement k
        //keep counting on r
        //if you hit char with >1 and k==0: its time to start moving l and see when
        // when you reduce the a count which was higher than 1 you increment k
        // once you have k>1 you can move onl.\\
        
        int k =2, l=0, r= 0, max=0;
        int c[] = new int[128];
        while (r< s.length()) {
            
            char atr = s.charAt(r);
        
            if(++c[atr]==1){
                k--;
                //it means we have added another unique character/
                //reduce the string until we reduce the count of some character back to 0
                if(k<0) {
                    while(l<r){
                        char atl = s.charAt(l++);
                        if(--c[atl]==0){
                            //stop it now
                            k++;
                            max =Math.max(max, r-l+1);
                            break;
                        }
                    }
                }        
            } 
            
            max = Math.max(max, r-l+1);
            r++;
            
            
        }
        
        return max;
        
    }
}