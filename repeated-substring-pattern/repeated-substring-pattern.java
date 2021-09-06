class Solution {
    public boolean repeatedSubstringPattern(String s) {
        //
        // pattern should have lenght in muktupe of s
        //the length will be a multiple of S length
        // atleast concatanetation so length can only be half or less. We will try for lenght
        for(int i = s.length()/2; i>0;i--){
            
            if(s.length() % i == 0){
                
                //looks possible at this length;
                String subStr = s.substring(0, i);
                int times = s.length()/i;  // 9
                StringBuilder builder = new StringBuilder();
                while(times>0) {
                    builder.append(subStr);
                    times--;
                }
                if(builder.toString().equals(s))return true;
                
            }
            
        }
        return false;
    }
}