class Solution {
    public boolean judgeCircle(String moves) {
        //up should be equal to down 
        // l shoudl be equal to R
        int ucount=0;
        int lcount=0;
        
        for(int i=0; i < moves.length();i++){
            
            char c = moves.charAt(i);
            if(c=='U') ucount++;
            if(c=='L') lcount++;
            if(c=='R') lcount--;
            if(c=='D') ucount--;
                
        }
        
        return  ucount==0 &&lcount==0;
    }
}