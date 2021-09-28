class Solution {
    public String minWindow(String s, String t) {
        //all substring should have a small window
        // you want ocheck all charas are overe for a t in the string and try to compress if possible.
            // xsliding window-> cover
            // keep moving r and removechars from t if present
            // once all are covered start moving l until nothing in the target is present
            // r-l will be the length., also movel one more to remove the first char and see if r can add it with smaler lenth?
            // check every substring of length t until s
            // total substring of a string:6 + 5+ 4 + 3 + 2 +1 n  * n+1/2
            
            //so if 2 a's are present both should be there
            //
        int [] count  = new int[256];
        for(char c:t.toCharArray()){
            count[c-'A']++;
        }
        int totalneeded = t.length();
        int l=0; int r=0;
        int minLen = s.length();
        String res = s;
        boolean validFound = false;
            
        while(r<s.length()){
            char rChar = s.charAt(r++);
            // if(count[rChar-'A'] > 0) {
                count[rChar-'A']--; //always reduce
            // }   
            
            if(allFound(count)) {
                validFound=true;
                String res1 = s.substring(l,r); //atleast
                if(res.length() >res1.length())res=res1;
                // System.out.println("Found "+ res);
                //try compressing the string until the string is still found.
                while (l<=r){ 
                    char lChar = s.charAt(l);
                    count[lChar-'A']++;
                // all useless ones will only go back to zero not more
                // only intersting ones will go positive, if it goes positive then stop
                // there can more than required target chars as well which is fine
                // increase l to just one more than first char and let r search for that
                    l++;
                    if(count[lChar-'A']>0) {
                        break;
                    } else if(res.length() >  r-l){
                        
                        res = s.substring(l, r);
                        // System.out.println("Found inner "+ res);
                        
                    }
                        
                    
                }
            }
        }
        
        return validFound? res:"";
    }
    
    public boolean allFound(int c []){
        for(int d: c)
        {
            if(d>0)return false;
        }    
        return true;
    }
}


