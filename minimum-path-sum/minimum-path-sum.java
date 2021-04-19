class Solution {
    public int minPathSum(int[][] grid) {
        
        // at every stepo you want to move right or left to 
        //keep doing a dfs from every path until you reach end. note the ttal path sum if its smaller than min
        
        
        if(grid==null || grid.length ==0)return 0;
        // on every location you only pull the min amount. 
//         
        // can we do BFS starting from 0,0 and put the min on every index but how ill know wfrom where itis coming 
        
        int dp[][] = new int[grid.length][grid[0].length];
        
        for(int i=0; i < grid.length ; i++){
            
            for(int j =0 ; j < grid[i].length; j++){
                        
                 if (i==0 && j ==0) dp[i][j] = grid[i][j];
                else {
                    dp[i][j] = Math.min(get(i-1,j,dp), get(i,j-1 ,dp)) + grid[i][j]; 
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
            
    }
    public int get(int i , int j , int dp[][]){
        if(i<0 || j < 0)return Integer.MAX_VALUE;
        return dp[i][j];
    }
}