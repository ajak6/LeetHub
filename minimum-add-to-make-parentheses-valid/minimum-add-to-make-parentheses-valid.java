class Solution {
    public int minAddToMakeValid(String s) {
        //onyl para
        // can we move para in teh strting )( does it ean we can rearrrange?
        int open=0;
        int close=0;
        //traverse count open
        // reduce if close ifs found and open is present
        //else count invalid closed
        //at the end open + close
        for(int i=0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c=='(') open++;
            if(c==')'){
                if(open>0)open--;
                else close++;
            }
        }
        return open+close;
        
//         //minimum moves optimization problem.
//         //so that entire string become valid.
//         //())- if you find invalid indexes from left you know 1 invalid index is present add 1 corresponding to thaht
//         //"()))((" -> 
//         int open = 0;
//         char c[] = s.toCharArray();
//         int invalid =0;
//         for(char ch: c){
            
//             if(ch == '(' ) {
//                 open++;
//             } else { 
//                 if(open==0){
//                     invalid++;
//                 }else{
//                     open--;
//                 }
//             }
//         }
//         int close =0;
//         for(int i=c.length-1; i>=0; i--) {
            
            
//             if(c[i] == ')' ) {
//                 close++;
//             } else { 
//                 if(close==0){
//                     invalid++;
//                 }else{
//                     close--;
//                 }
//             }
//         }

//         return invalid;
        
    }
}