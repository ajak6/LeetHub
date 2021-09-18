class Solution {
    public int calculate(String s) {
        //edge case: witghout worry abojut paranthesis this case will fail -(3+(4+5))
        //
        // traverse and look at each character
        // continue if blank
        // if number continue to create the number
        // () and (-) will be there
        // evaluate whats in () first
        // since this is only + and - we can ignore ( and continue to check the sign and number fir now)
        //once you have a number add it to a sum value and start create a new number
        //store the sign of the numebr if you hit - and then just use it to add ot substract
        int result = 0;
        int sign = 1;
        int runningNumber = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i < s.length(); i++) {
            //12+(-1)
            char c = s.charAt(i);
            if(c>='0' && c <= '9'){
                runningNumber=runningNumber*10+ (c-'0');
            } else if(c=='+'||c=='-') {
                //running number is done
                result += (runningNumber)*sign;
                runningNumber=0;
                sign = c=='-' ? -1:1;
            }
            if(c=='('){
                //we need to recurse and get the remaining result
                stack.push(result);
                stack.push(sign);
                runningNumber =0;
                result=0;
                sign = 1;
                    
            }
            if(c==')'){
                //this recursive call has ended and should return the result whatever it has to caller
                
                // result*sign+runningNUmber = in case of (-1)  this will fail. we will loose the sign since result will be 0;
                // 4+(-5) => 4 to stack, +1 to stack=> then you hit -1 sign, result =0, sign=-1, hit 5 runningNumber is 5, then hig ) 0+-1*5=result =-5, old result=4+(old sign)* (result) = 4 +1*-5 = -1
                result = result + sign*runningNumber; 
                int oldSign = stack.pop();
                int oldResult = stack.pop();
                result = oldResult + result * oldSign;
                runningNumber=0;
                
            }
            if(i==s.length()-1){
                //last char
                result += (runningNumber)*sign;
            }
        }
        // At the end if we hit a ' ' or ')' then we can't really 
        // the running number is lingering without any value.
        return result;
    }
    
    public int calculate1(String s) {
        
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