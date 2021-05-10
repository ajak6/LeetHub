class Solution {
    //cases missed with stack implementation
    //what if the initial string is invalid and later string is valid
    //when always poping a open brace when close isfound will lead to zero answer (() -> when matching is found simply poping is not good.
    // getting the length will be hardb with -1 index in the stack
    public int longestValidParentheses(String s) {
        
    int result = s.length();
  
    
    // subproblem
    // start from 0 to i and end check sub but this will n3 string
    // 
    // keep putting in the index on thes tack
    // If the top is value opening brach then pop and record length
    // 
    // you keep counting the length of valid sub until you hit a non matching brace //you record the current length and move to next index until you again hit a open bracket
    // and keep the maxCount in a separate variable.
            
       TreeSet<Integer> q = new TreeSet<>();
        int open=0;
        
        for(int i =0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c=='(') {
               open++; 
            }else {
                if(open>0)open--;
                else{
                    q.add(i);
                }
            }
        }
        int close=0;
        
        for(int i =s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            if (c==')') {
               close++; 
            } else {
                if(close>0)close--;
                else {
                    //invalid index.
                    q.add(i);
                }
            }
        }
        
        //case we need to handle:
        /**
            when entire string in valid then queue wil be empty
            when there is a single index 0 in the queue you still need the last char as the  length 
            to be added in the string so that you can clculate the total length.
            cleaner way is to add index 0 in the start of the queue
            and at the nend pof conuting push the lenght in the queue for calculating tne entire string is valid or the suffix is valid.
            
        */
        q.add(s.length());
        System.out.println(q);
        int left =-1;
        int max =0;
        for(int i:q) {
            int right = i;
            int len = right - left - 1;
            max = Math.max(max, len);
            left = right;
        }
        return max;
    }
}