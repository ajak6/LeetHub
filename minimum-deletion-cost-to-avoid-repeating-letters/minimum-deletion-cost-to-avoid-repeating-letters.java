class Solution {
    public int minCost(String s, int[] cost) {
        
        //min cost either greedy
        //pick something which wil not affect the answer wbut give the min cost.
        //or dynamic programming.
        // count of same chars
        //basciaaly you traverse the string and find the chars if same remove it and add its cost.
        
        //find when 2 chars are same 
        //start adding their costs in the result
        // keep tracjk fo mnax cost you say for these oncsecutive charactsers
        //reduce the max cost which means we are not deleting the max cost charactes
        int totalCost = 0;
        
        for(int i=1 ; i < s.length() ;){
            
            if(s.charAt(i-1)==s.charAt(i)){
                //you need to know the cost of i-1 and now onlty add cost of i
                //
                char dup = s.charAt(i-1);
                int maxCost = 0;
                int deleteCost = 0;
                int j =i-1;
                for(;j < s.length() && s.charAt(j)==dup; j++) {   
                    deleteCost+=cost[j];
                    maxCost =Math.max(cost[j], maxCost);   
                }
                deleteCost -=maxCost;  //we won't delete the max cost character
                i=j;
                totalCost+=deleteCost;
            } else {
                i++;
            }
            
        }
        return totalCost;
        
        
    }
}