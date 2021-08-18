class Solution {
    public List<String> generateParenthesis(int n) {
        //count the open paranthesis and you add a closed one corresponding to open ones.  
//         we do DFS starting from open bracket and reduce the count
//             // everytime check the current open count if it 0 then we cannot close and we have created a combination store it.
//             else call it with another open and reduce the count but 
                
//                 when to call with close: to decide that we nned
//                 how many are still open so take anothe r variable for counting how many are currently open or how many close can use 
        List<String> result = new ArrayList<>();   
        dfs(result, n, n, 0,"");
        // dfs1(result, n,0, "");
        return result;
    }
    
    public void dfs(List<String> result,int max, int openAllowed, int closedAllowed, String current){
       if(current.length() == 2*max){
           result.add(current);
       } 
        
        if(openAllowed>0) {
            dfs(result, max, openAllowed-1, closedAllowed+1, current+'(');
        }
        if(closedAllowed>0){
            dfs(result, max, openAllowed, closedAllowed-1, current+')');
        }
            
        
    }
}