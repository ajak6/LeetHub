class Solution {
    public List<String> removeInvalidParentheses(String s) {
        /*
        characters move as it so a loop until we see a para
        
        either we count the open and close brackers and now we will know how many para we can remove ?
        all result we will have to back track
        at a position either you move forward with para presnt 
        if we keep a count of open and close brackets
        now at any position we can know whether to include a para or not
        case1 if openused =0 then close cannot be used and can be ignored safetly
        everytime we add a close bracket we reduce the open count but i thin
        case 2 if openused 2 then add a close bracket and also call without a close bracket.
            this can be optimized further to not call without a closebracket if we know we do not have enough close brackets eft at the end
            for e.g. we have 2 close brackets and we see 2 oipen we know there is no point in calling without close bracket at this stage.
            
            how will we check at the end that we created a balanded string. opoen shuld be zero 0
        
        
        brute force on every ( and ) we use the bracket or not and when we reach then ed of string we check whther it has balanced para or not and use a set to store to avoid duplicaets.
        
        
        complexity is 2^n n equal to open and close backets in the string
        
        wha we know how many open and close we have and how many ideally we can have min of both
        
        now for open brackets you can addd open brackets
        if we see a close brackets we have2 choice 
        if there are open brackets then we can close it by including the THE CLOSE BRACKET WE SEE BUT we also proceed with to not add it to may be add another open brak and close both toegether to created another possibleility
        in a string what we know :
        do not:
    
        case when close comes before open: ignore thes brackets -= to make this devciison we need to know that how open brackets are in use. IF a openb is closed then reduce the count of opens/
        
        declaring it as a result:
        At the end we have traversed the string we want to know hwteher this string can be added in the result -
            1. KLenth should same or greater than previous string?
            2. It should have balanced paranthesis.
            lengh we can find out by using the first elemenet in th result list.
            balanced: open braces should be 0.
        */
        List<String>result = new ArrayList<>();
        
        backtrack(s, "", 0, result, 0);
        return result;
    }
    
    public void backtrack(String s , String curr, int i , List<String> result, int open) {
        System.out.println("i "+ i);
       
        StringBuilder builder = new StringBuilder();
        while(i< s.length() && s.charAt(i) != '(' && s.charAt(i) != ')') {
            builder.append(s.charAt(i));i++;
        }
        curr=curr+builder.toString();
         if(i>=s.length()){
             
             System.out.println(curr);
            int len = result.isEmpty()? 0: result.get(0).length();
            if(curr.length() >=len && open==0){
                if(curr.length()> len) result.clear();
                result.add(curr);
            }
            return;
        }
        
        char para = s.charAt(i);
        if(para == '('){
            backtrack(s, curr+para,i+1, result, open+1);
        } else {
            if(open>0){
                backtrack(s, curr+para, i+1, result, open-1);
            }
        }
        while(i >= 0 && i < s.length()-1 && s.charAt(i+1) == para) {
                System.out.println(i);
                i++;
        }
        backtrack(s, curr,i+1, result, open);
        
    }
}