class Solution {
    public boolean validPalindrome(String s) {
        // remove each character and check if it is polidrome.
        // abca - b or c can be removed.
        //keep removing a char and check
        
        int [] count = new int[26];
        int l = 0;
        int r = s.length()-1;
        int full = s.length();
        while(l<r){
            if(s.charAt(l) == s.charAt(r)) {
                l++;r--;
            }else{
                return isPalindrome(s.substring(0,l)+ s.substring(l+1, full)) || isPalindrome(s.substring(0,r) + s.substring(r+1, full));
            }
            
        }
        return true;
    }
    
    public boolean isPalindrome(String s1){
        System.out.println(s1);
        int l =0;
        int r = s1.length()-1;
        while(l<r){
            
            if(s1.charAt(l) != s1.charAt(r))return false;
            l++;r--;
        }
        return true;
        
        
    }
}