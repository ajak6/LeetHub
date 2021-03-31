class Solution {
    public String minRemoveToMakeValid(String s) {
        
    //approach 1:
        //backtrack and remove 1 and check if it is valid and recurse to make ti valud by removing some braces.
        
        //cout open braes
        // cout closed braces.
        // which ever is omre needs to be removed?
        // you traverse the find if a open is not present for a close one seen then remove it.
        //but if you keep taking opens then how will you remove openones?
        //traverse in reverse and now for all closed ones - balanced onces foud along the wayyou remove the extra opens.
        
        char c[] = s.toCharArray();
        
        int open =0;
        int close=0;
        for (int i =0 ; i < c.length; i++){
            if(c[i]=='(') open++;
            if(c[i]==')'){
                if(open>0){
                    open--;
                } else{
                    c[i]=' ';//junk
                }
            }
        }
        for (int i = c.length-1 ; i>=0 ; i--) {
            if(c[i]==')') close++;
            if(c[i]=='('){
                if(close>0){
                    close--;
                } else{
                    c[i]=' ';//junk
                }
            }
        }
        StringBuilder builder = new  StringBuilder();
        for(char ch:c){
            if(ch==' ')continue;
            builder.append(ch);
        }
        return builder.toString();
    }
}