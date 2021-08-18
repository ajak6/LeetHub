class Solution {
    public int longestPalindrome(String s) {
        // all case of characters piossible?
        // we can chose any order for these numbers
        // any combinations
        //p- total char which have a count of 2 or multiopke of 2 and a single char which has a mac odd count and we can make a longest palindrome:
        if(s==null)return 0;
        if(s.isEmpty())return 1;
            
        
        int maxOddLength =0;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c: s.toCharArray()) {   
            map.merge(c, 1, Integer::sum);
        }
        int totallength = maxOddLength;
        for(int val : map.values()){
            if((val&1)==0){
                //event
                totallength+=val;
            }
            //odd values can be picked but o0jnly the even part of those odd values.
            
            if((val & 1 )==1){
                // keep adding the even part of odd count characters
                maxOddLength=1;
                totallength += (val-1);
            }
            
        }
        return totallength + maxOddLength;
    }
}