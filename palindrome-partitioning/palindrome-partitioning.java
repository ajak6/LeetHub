class Solution {
    public List<List<String>> partition(String s) {
        // /if we can find out whether the substring we are considering can be made palindrome
        // then
        //1. if the number is palindrome
        //2. can the rest of the string be palindrome
        // dynamic programming, start filling it with true for single char string
        // Dynamic programming can help in finding out which substring is palindrome we can select 
        //
        
        //try sbvstriung paritions not pick the numbers and find hte palindrome.
        
        // try all partitions creating substrings.
        List<List<String>> result = new ArrayList<>();
        substring(s, 0, s.length()-1, result, new LinkedList<>());
        return result;
    }
    
    public void substring(String s , int start , int end, List<List<String>> result, LinkedList<String> current){
        
        if(start==s.length()){
            result.add(new ArrayList<>(current));
            return;
        }
        
        for(int i = end; i>=start; i--) {
            if(isPalindrome(s, start, i)) {
                current.add(s.substring(start, i+1));
                substring(s, i+1, end, result, current);//find out other substrings
                current.removeLast();        
            }
        }
        
    
        
    }
    public boolean isPalindrome(String s, int start, int end){
        
        while(start<end){
            if(s.charAt(start)!=s.charAt(end))return false;
            start++; end--;
        }
        return true;
    }
}