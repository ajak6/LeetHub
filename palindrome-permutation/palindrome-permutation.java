class Solution {
    public boolean canPermutePalindrome(String s) {
        int count [] = new int[26];
        
        for(int i =0 ; i < s.length(); i++) {
            
            count[s.charAt(i) -'a'] ++;
            count[s.charAt(i) -'a']%=2;
        }
        int sum=0;
        for(int i=0;i< count.length; i++){
         sum+=count[i];
        }
        return sum==0 || sum == 1;
        
        
            
    }
}