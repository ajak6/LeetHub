class Solution {
    //case missed 
    //when empty string and pattern is b* -since b can be 0 it should be true
    public boolean isMatch(String s, String p) {
        //p is the regular expression pattern
        //recusrively match one character at a time with all possibility
        //on every * you call the matcher twice
        //* means 0 or more so on a * you have possibility to match 
        //match it with the prev char in the pattern so if curr is * you match
        // the string with curr-1==s.currentChar and you call rec with same* index and one more index to match the next char with same hence increasing the use of * or moving on to the next character
        
        //we needd to the index whichh char tio chec in s and p
        return isMatch(s, 0, p,0);
    }
    //base condition
    //if the last char is * we will keep try to match is something before * and it will match
    //at the end
    //s is finished p only hsa * left
    //s is finished p has some other chars left
    //s is not finished but p is finished
    //s is not finished p is finished
    //s is not finished p is whatever dopes not matter keep going until s is finished
    
    public boolean isMatch(String s, int i, String p, int j) {
        // base case if we reach the end of string.
        //if string and pattern both finished then return true
        if (i>=s.length() && p.length()==j) {
            // System.out.println("return true");
            return true;
        }
        
        // if(i==s.length()) return false;
        if(j==p.length()) return false;
        //if current chars match then recurse with next index
        
        //what if first char is a * can't happen it should be always after a char
        if (j+1 < p.length() && p.charAt(j+1)=='*') {
            //if current chars are equal you rev with taking that char and moving to next index but also keep the same so that we can match the next char in s with the *
            if (i<s.length()  && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.')) {
                return isMatch(s, i+1, p, j+2) || isMatch(s, i+1, p, j) || 
                    isMatch(s, i, p, j+2);
            } else {
                //current chatts are not equal it means we can ignore the current char in p and try to match s with chars after *
                return isMatch (s, i, p, j+2);
            }
        } else if(i < s.length() && (p.charAt(j)=='.' || (s.charAt(i)==p.charAt(j)))) {
            return isMatch (s, i+1, p, j+1);
        } else {
            return false;    
        }
        
        
        //either the current char is (* or should we look ahead for a *)
        //even if the current char does not mathch it will be okay if the next char is *
        // if the next char is * then simply keep the current index in p or jump to i+2
        
        
            
        
         
    }
}