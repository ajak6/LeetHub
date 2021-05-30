class Solution {
    public boolean isMatch(String s, String p) {
        
        // * means match any number of characters. 0 to n of different type
        // ? matches a single character.
        
        /*
            if * in p then we can do it 3 ways  
            match no chars.
            match 1 char
            match 1 or more
            
            base condition is when p is finished. 
            if S finishes there may be some *'s in p which need to be handled.
            if p is over and S is over then we are prolly good.
                ? should match with a chars. empty won't match with ?
        */
        
        return isMatch(s, 0, p, 0);
        
        
    }
    Map<String, Boolean> map = new HashMap<>();
    
    public boolean isMatch(String s, int i, String p, int j) {
        
        if (s.length() == i && j == p.length()) return true;
        if(i < s.length() && j == p.length()) return false;
        // System.out.println(s.substring(i) + " " + p.substring(j));
        boolean result = false;
        if(map.containsKey(i+":"+j)) {
            return map.get(i+":"+j);
        }
        if (j < p.length() && p.charAt(j)=='*') {
            // branch is 3 directions
            // only search with a * is there is something left in S
            if( i < s.length() ) {
                result = result || isMatch(s, i+1, p, j);
            } 
            result = result ||  isMatch(s, i+1, p , j+1) || isMatch(s, i , p, j+1);
        } else if (i<s.length() && ((p.charAt(j)=='?') || (p.charAt(j)==s.charAt(i)))){
            // i should be less than s length sine ? needs to match with 1 char atleast.
            result = isMatch(s, i+1, p, j+1);
        } else {
            result = false;
        }
        map.put(i+":"+j, result);
        return result;
    }
}