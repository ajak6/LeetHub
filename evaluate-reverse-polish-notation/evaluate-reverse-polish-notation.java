class Solution {
    public int evalRPN(String[] tokens) {
        
        //10*6+5 -> 
        // GO FROM LAST
        // IF YOU SEE OPERATOR PULL ELELMENTS FROM THE STACK AND CALCULATE
        // 
        // 2 + 1* 3 -> 2 1 3*+  will work popping out elements
        //["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
        // ((10 * (6 /(9+3 * -11)) + 17) + 5)
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> operator = new Stack<>();
        
        for(int i=0; i < tokens.length ; i++){
            // System.out.println(numStack);
            if( isNumeric(tokens[i])){
                numStack.push(Integer.parseInt(tokens[i]));
            }else{
                if (operator(tokens[i])){
                    int num1=numStack.pop();
                    int num2 = numStack.pop();
                    int val =apply(num2, tokens[i], num1);
                    numStack.push(val);
                }
            }
        }
        return numStack.peek();
    } 
    public  boolean isNumeric(String str) { 
      try {  
        Integer.parseInt(str);
        return true;
      } catch(NumberFormatException e){  
        return false;  
      }  
    }
    
    public int apply(int n, String operator, int n1){
        char op=operator.charAt(0);
        if(op=='+'){
            return Integer.sum(n,n1);
        }else if(op=='-'){
            return Integer.sum(n, -n1);
        }else if(op=='/'){
            return n / n1;
        }else{
            return n*n1;
        }
    }
    
    public boolean operator(String s){
                                      
        if(s.length()>1) return false;
        char c= s.charAt(0);
        return c=='+' || c=='-'||c=='/'||c=='*';
    }
}