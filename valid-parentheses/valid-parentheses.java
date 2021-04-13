class Solution {
    public boolean isValid(String s) {
     //any other characters? yes
        if(s.isEmpty()) return true;
        char openCur = '{'  ;
        char openSq = '['  ;
        char openPara = '(';
        char closedCur = '}'  ;
        char closedSq = ']'  ;
        char closedPara = ')';
        Stack<Character> stack = new Stack<>();
        for (int i=0; i < s.length(); i++) {    
            char curr = s.charAt(i);
            //if it is not a bracket then pass here
            if(Character.isDigit(curr) || Character.isAlphabetic(curr)) continue;
            if (curr == openCur) {
                stack.push(closedCur);
            } else if(curr == openSq ){
                stack.push(closedSq);
            } else if(curr == openPara){
                stack.push(closedPara);
            } else {
                if(stack.isEmpty()) return false;
                boolean check = stack.pop()==curr;
                if(!check) return false;
            }
        }
        
        return stack.isEmpty();
        
    }
}