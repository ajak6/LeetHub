class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(k==0)return 0;
        int l=0,r=0,max=0;
        int c[] = new int[128];
        while(r< s.length()) {
            
            char atr = s.charAt(r);
            if(++c[atr]==1) {
                k--; // we found a unioque char that is included in the sub
                if(k<0){
                    //we have included more than allowed chars.
                    //we will remove some chars to keep the window valid.
                    
                    while(l < r){
                        char atl = s.charAt(l++);
                        if(--c[atl]==0){
                            k++;
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