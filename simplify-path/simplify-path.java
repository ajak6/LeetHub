class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        
        String [] s = path.split("/");
        //"." ".." ""
        for(int i=0; i < s.length ; i++){
            
            if(!stack.isEmpty() && s[i].equals("..")){
                stack.poll();
            }
            if(!(s[i].equals(".") || s[i].equals("..") || s[i].equals(""))){
                stack.push(s[i]);
            }
               
        }
        StringBuilder builder = new StringBuilder();
        // empty result in that case only return "/"
        // in case of alll num ers we will have to return something.
        while(!stack.isEmpty()){
            builder.append("/"+ stack.pollLast());
        }
        
        return builder.length()==0? "/": builder.toString();
    }
}