class Solution {
    public int calculate(String s) {
        int result=0;
        int runningNum=0;
        int prevNum =0;
        int resultSign=+1;
        char prevSign=' ';
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i < s.length(); i++) {
            //14 + 5 * 6
            // System.out.println (stack);
            char c= s.charAt(i);
            if(c>='0' && c<='9') {
                runningNum=runningNum*10+(c-'0');
            } else if(c=='+' || c=='-') {
                // 3+5
                // 3+5*6+4 -> when at second + you don't push 6 but you evaluate the result and then push the reusult on stack due to '+'.
                // 
                //evaluate the current running sum;
                if (prevSign =='*') {
                    runningNum = prevNum * runningNum;
                    prevNum=0;
                }
                if (prevSign =='/') {
                    runningNum = prevNum / runningNum;
                    prevNum=0;
                }
                //evaluate whole stack and then just push a single number since no point in accumulating everything.
                while(!stack.isEmpty()){
                    runningNum = stack.pop()*runningNum + stack.pop();
                }
                stack.push(runningNum); //[14, +1]
                prevSign = c;
                int signn = c=='+'? 1:-1;
                stack.push(signn);
                runningNum =0;
                
            } else if(c=='*' || c=='/') {
                
                if (prevSign =='*') {
                    prevNum = prevNum * runningNum;
                
                }
                else if (prevSign =='/') {
                    prevNum = prevNum / runningNum;
                
                }else{
                    //still store the runningNum in prev since now we will see another number
                    prevNum=runningNum;
                }
                prevSign = c; // '*'
                // 
                runningNum=0;
            }
            if(i==s.length()-1) {
                //last index evalution
                if (prevSign =='*') {
                    runningNum = prevNum * runningNum;
                    prevNum=0;
                }
                else if (prevSign =='/') {
                    runningNum = prevNum / runningNum;
                    prevNum=0;
                }
                
                    //it was + or -
                //regarless if prev was * we may still have somthing in the stafck to evaluate.
                while(!stack.isEmpty()){
                   runningNum = stack.pop()*runningNum + stack.pop();
                }   
            }
        }
        System.out.println(stack);
        return runningNum;
    }
    
    public int calculate2(String s) {
    
        Stack<Integer> num = new Stack<>();
        // 1 - 3 /5 + 4
        char previousOperator = '+';
        int number =0;
        //3+2*2
        for(int i=0; i < s.length(); i++) {
            // System.out.println(num);
            char c = s.charAt(i);
            // System.out.println("curr "+ c);
            if(c >= '0' && c <= '9'){
                number = number*10 + c-'0';
                
            }
            //onc we see this operator we want to apply previous operator
            //number building is done
            if((!Character.isDigit(c) && c!=' ') || (i==s.length()-1)){
                if(previousOperator=='-') {
                    num.push(-number);
                }
                else if(previousOperator=='+') {
                    num.push(number);
                    
                }
                else if(previousOperator=='*') {
                    // System.out.println("number "+number + " "+ num);
                    int result = num.pop() * number;
                    num.push(result);
                    

                }
                else if(previousOperator=='/') {
                    int result = num.pop()/number;
                    num.push(result);
                    

                }
                    previousOperator = c;
                    number = 0;
                
            }
            
            
        }
        
        int result=0;
        while(!num.isEmpty()){
            result = result+ num.pop();
        }
        return result;
    }
    public int calculate1(String s) {
            //edge cases:
        // when you have - / then +
        // you will exeute / when you hit + but then you also need to execute - 
        // a recursive call or a loop to finish entire low priority stack bases on currentoperator is needed.
        int result=0;
        int number =0;
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operator = new Stack<>();
        char lastOperator= ' ';
        for(int i=0; i < s.length(); i++) {
            // System.out.println(numStack + " " + operator);
            char c = s.charAt(i);
            
            if(c>='0' && c<='9'){
                number = number*10+ c-'0';
            } else if(c == '*' || c=='/' || c == '+' || c=='-') {
                numStack.push(number);            
                execute(numStack, operator, c);
                //then push the current number and sign. You don' thave to execute for the current sighh becauise we need the nexct number
                operator.push(c);
                number =0;
            }
        }
        numStack.push(number); //push the last number
        execute(numStack, operator, '+'); // '+' carries low priority so every thing in the stack will execute/
            
        return numStack.peek();
            
    }
    
    public void execute(Stack<Integer> num, Stack<Character> operator, char curr){
        if(num.size()<2)return;
        // System.out.println("Executing at " + num + " " + operator + "current op "+ curr);
            
        if(operator.peek() == '*' || operator.peek() == '/'){
           int result =apply(num.pop(), num.pop(), operator.pop())  ;
            num.push(result);
        } else if(curr=='+'|| curr=='-') {
            
            int result =apply(num.pop(), num.pop(), operator.pop())  ;
            num.push(result);
        } else {
            return;
        }
        // this helps with the case when current is + and stack has [-.'/'] which requires executing both
        execute(num, operator, curr);
    
    }
    
    public int apply(int n2, int n1, char op){
        if(op=='*') return n1*n2;
        if(op=='/') return n1/n2;
        if(op=='+')return n1+n2;
        return n1-n2;
    }
}