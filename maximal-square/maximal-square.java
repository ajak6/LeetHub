class Solution {
    public int maximalSquare(char[][] matrix) {
        
        
        /*
        find the min of all
        create a dp where im,j eenotes a square ending at i,j
        f i,j==0 then 0
        if i,j 1 min )i-1,j-1, i-1,j,i,j-1
        
        */
        
        int dp[][] = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i=0;i< matrix.length; i++){
            dp[i][0]= matrix[i][0]=='1'?1:0;
            max = Math.max(max, dp[i][0]);
        }
        for(int i=0;i< matrix[0].length; i++){
            dp[0][i]= matrix[0][i] == '1' ? 1 : 0;
            max = Math.max(max, dp[0][i]);
        }
        
        for(int i=1;i < matrix.length ;i++) {    
            for(int j =1; j < matrix[i].length; j++) {
                if(matrix[i][j]=='1'){
                    dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    max = Math.max(max, dp[i][j] * dp[i][j]);
                }
            }
        }
        return max;
    }
}