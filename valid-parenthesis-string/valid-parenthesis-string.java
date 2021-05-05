class Solution {
    // any number of starts are possible
    // when hit a * either we try all posible ways to understand that * like a regular experession
    // 
    public boolean checkValidString(String s) {
        // return recCheck(s, 0, 0, 0);
        //on every brace we have
        //
        // at a * what decision can you make
        // either you have more opens which mean you can still make it as oipen close or ignore.
        // traverse and find out a ubused open bracket
        //we want to know if there is a start to its right it yes then you replace that * with )
        // go from right to left and identify inde of close bracjets
        // Simly having a * anywhere in the right is not rnought for e.g. (*)())- i think it is enough
        // so traverse from left to right push the inde of * in the stack
        //keep counting opens and reduce closed.
        //at if we find a etra close and there is a * in the stack we can opo it assuming this * will be converted to (
        // but how wdo we handle ( brackets.
        // for extra open brackets we need to know whether ther eis a * in the right so a stack with index should be good?
        // but I also need to prevent reusing * for both ( and ). track its index in a hashset
        //if we store index of * 
        //when traversing left to right if we find any index higher than current we remove that * from the treeset/
        //does it matter which one do I use.
        //(*))(()**)
        HashSet<Integer> used = new HashSet<>();
        TreeSet<Integer> starIndex = new TreeSet<>();
        int openStar =0;
        int open=0;
        for(int i=0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='*'){
                openStar++;
                starIndex.add(i);
            } else if(c=='('){
                open++;
            } else {
                if(open>0)open--;
                else if(starIndex.lower(i)!=null) {
                    starIndex.remove(starIndex.lower(i));
                    // close--;//since the close has found a matching * in the left somewhere
                }
                else return false;
            }
        }
        // System.out.println(starIndex);
        int close =0;
        for(int i=s.length()-1; i >=0; i--) {
            char c=s.charAt(i);
            if(c=='*') {

                // starIndex.add(i);
            } else if(c==')') {
                close++;
            } else {
                if(close>0)close--;
                else if(starIndex.higher(i)!=null) {
                    // close--;
                    open--;
                    System.out.println("using "+ starIndex.higher(i) + " for close");
                    starIndex.remove(starIndex.higher(i));
                }
                else return false;
            }
        }
        
        //at the end I thnk open and close should be 0
        return true;
    }
    
    
    /*
        Very slow complexity is only every * we are at most tryin 3 branches which is O(3^n) 
    */
    public boolean recCheck(String s, int i, int open, int close) {
        if(open<0)return false;
        if(open>s.length()/2)return false;
        
        if(i==s.length() && open==0)return true;
        if(i==s.length())return false;
        boolean result =false;
        if(s.charAt(i)=='*') {
            if(open>0){
                //then consider adding a closed by reducing open
                result=recCheck(s, i+1, open-1, close);
            }
            return result || recCheck(s, i+1, open+1,close) || 
            recCheck(s, i+1, open, close);
            
        }
        if(s.charAt(i)=='('){
            return recCheck(s, i+1, open+1, close);
        }
        else{
            return recCheck(s, i+1, open-1, close);
        }
        
        
    }
    
    public boolean checkValidString3(String s) {
        //count open and close and then
        // at a start we may need to create 2 selections either make it ) ( or not use it
        //this will create 3 branches since only 1 start will be present it will take 3n time.
        
        //count without *  if valid then good
        //then use star when it appears. If it appears and we know we are short of ( or close then just count it as  validate the string
        int open=0;
        int close =0;
        // (*))
        for(int i=0; i < s.length(); i++){
            
            if(s.charAt(i)=='('){
                open++;
            }else if(s.charAt(i)==')'){
                if(open>0) open--;
                else{
                    close++;
                }
                
            }
        }
        //when you envcounter * consider it as a (
        boolean countOpen = close>0;
         open=0;
        for(int i=0; i < s.length(); i++){
            if(s.charAt(i)=='*') {
                if(countOpen) open++;
                else{
                    if(open>0)open--;
                    else
                        return false;
                }
            } if(s.charAt(i)=='('){
                open++;
            } else if(s.charAt(i)==')'){
                if(open>0) open--;
                else{
                    return false;
                }
                
            }
        }
        return open==0;
        
        
    }
}