class Solution {
    public int compress(char[] chars) {
               StringBuilder builder = new StringBuilder();
        if(chars== null || chars.length == 1)return 1 ;
        char prev = chars[0]; //anything unexpected
        int c = 1;
        int c1i = 0;
        for(int i=1; i <= chars.length ; i++) {
            if(i< chars.length && chars[i] == prev){
                c++;
            } else{
                // builder.append(prev);
                // if(c>1)
                //     builder.append(c);
                chars[c1i++]=prev;
                if(c>1) {
                    for(char strc: (""+c).toCharArray()){
                        chars[c1i++]=strc;    
                    }
                    
                }
                c=1;
                
            }   
            if(i<chars.length) prev = chars[i];
        }
        // for(int i=0;i<builder.length(); i++) {
        //     chars[i] = builder.charAt(i);
        // }
        return c1i;
        // return  builder.length(); 
    }
}