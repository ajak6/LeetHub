class Solution {
    public boolean backspaceCompare(String s, String t) {
        
        Stack<Character> stack = getStack(s);
        Stack<Character> stack2 = getStack(t);
        
        while(!stack.isEmpty() && !stack2.isEmpty()){
            if(stack.pop()!=stack2.pop())return false;
        }
        return stack.isEmpty() && stack2.isEmpty();
    }
    
    public Stack<Character> getStack(String s){
        
        Stack<Character> stack = new Stack<>();
        
        for(char c: s.toCharArray()){
            if(c=='#'){
                if(stack.isEmpty()) continue;
                stack.pop();
            }
            else stack.push(c);
        }
        return stack;
    }
}