class Solution {
    //edge case: if we are always looking for different characters than it is possible we will never hit and a single char string will never be counted
    // substring all the time may not be useful. We may be able to pass start and end index to compare.
    Map<String, Integer> map = new HashMap<>();
    public int longestPalindromeSubseqq(String s) {
     
        if(s.isEmpty()) return 0;
        if(s.length()==1) return 1; 
        if(map.containsKey(s)) return map.get(s);
        // System.out.println(s);
        //reccursively check if we have same char and then recurse for the leftover string
        int maxLength = 0;
        int l =0;
        for(; l < s.length(); l++){
            
            for(int r=s.length()-1; r>l;r--){
                
                if(s.charAt(l)==s.charAt(r)) {
                    maxLength = Math.max(maxLength, 2+ longestPalindromeSubseqq(s.substring(l+1, r)));    
                }
                
                
            }
        }
        maxLength = maxLength ==0?1:maxLength;
        
        map.put(s,maxLength);
        return maxLength;
    }
    public void print(int dp[][]){
        
        for(int a[]: dp){
            System.out.println(Arrays.toString(a));
        }
    }
    public int longestPalindromeSubseq(String s){
        
        int dp[][] = new int[s.length()][s.length()];
        if(s==null)return 0;
        if(s.length()==0 || s.length()==1)return s.length();
        //same diagonal traversal is required
        for(int len =0; len <s.length(); len++){
            // print(dp);
            // System.out.println("------");
            for(int row =0, col=0; col+len< s.length() && row<s.length(); col++, row++){
                if(col+len==row){
                    dp[row][col]=1;
                } else if(s.charAt(row)==s.charAt(col+len)) {                    
                    dp[row][col+len]= 2;
                    if(row+1 < dp.length && col+len-1>=0 && row+1 <= col+len){
                        dp[row][col+len]+=dp[row+1][col+len-1];
                    }
                } else{
                    dp[row][col+len]=Math.max(dp[row][col+len-1], dp[row+1][col+len]);
                }
            }
        }
        
        return dp[0][s.length()-1];
        
        
    }
}