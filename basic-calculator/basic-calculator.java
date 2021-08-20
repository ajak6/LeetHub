class Solution {
    public int calculate(String s) {
        
        // will the numbers be decimal always? no exponents?
        // normal expresssion
        //
        // read the string until you hit an operator. That is a number.
        // Cases: number, braces and operator.
        // if we split by refex into separate numbers?
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> signStack = new Stack<>();
        int sign = 1;
        int number=0;
        int result=0;
        
        for(int i=0; i < s.length();i++){
            
            char c = s.charAt(i);
            
            if(c>='0' && c<='9') {
                number=number*10 + (c-'0');
                
            } else if(c == '-') {
                //we see a new character so stop the number here
                result = result + sign* number;
                
                number =0;
                sign = -1;
            } else if(c=='+') {
                result = result + sign* number;
                number = 0;
                sign = +1;
            } else if(c=='(') { 
                //save the result
                //save the sign for  this result
                //number will be zero for other calculations
                
                stack.push(result);
                signStack.push(sign);
                result=0;
                number=0;
                sign=1;
            } else if(c==')'){
                result = result + sign * number;
                //opo the sign and add this result to result in the stack
                if(!stack.isEmpty()) {
                    int oldResult = stack.pop();
                    sign= signStack.pop();
                    result = oldResult + sign* result;
                    sign = 1;
                }
                number=0;
                
            }
            
        }
        return result + sign*number;
    }
}