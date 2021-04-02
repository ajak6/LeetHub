class Solution {
    public String removeKdigits(String num, int k) {
        //a number is given
        //to remove some digits and create a number smallest possible we need to 
        // remove largest numbers?
        // we just need to arrange the number in increasing order. Any number creating the mountain to decreasing slopw should be removed?
        //but since limit digits can be removed we have to chose wisely. the left most character should go first as simoplke and it will tkae care of creating number which is smallest possible
        //order towards the end of the number can be ignore sa athey will not contrioibute to the numbers vaklues as numc LSB
        /* you start with once and see 4 is increasing happy
        // 3 is decreasing meaning 4 shoul be gnoe.
        now comes 2 and 3 is higher so if we have capacity 3 should be gone.
        now number is 12comes 2 we take it 
        if comes 1 which digit you will remove now if we have to remove just 1? any 2 you remove m*/
        
        Stack<Character> stack = new Stack<Character>();
        
        for(char c: num.toCharArray()){
            if(stack.isEmpty()){
                if( c!='0')
                    stack.push(c);
                continue;
            }
            
            while( !stack.isEmpty() && Character.getNumericValue(stack.peek())> Character.getNumericValue(c)  && k>0){
                k--;
                stack.pop();//remove a higher number and reduce k
            }
            if(stack.isEmpty() && c=='0') 
                continue;
            stack.push(c);
        }
        while(k>0 && !stack.isEmpty()){
            stack.pop();k--;
        }
        char result []= new char[stack.size()];
        
        for(int i=stack.size()-1 ; i >=0; i--){
            result[i]=stack.pop();
        }
        String res = new String(result);
        res=res.isEmpty() ? "0": res; 
        //initial zeros should be fone if present.
        return res;
    }
}