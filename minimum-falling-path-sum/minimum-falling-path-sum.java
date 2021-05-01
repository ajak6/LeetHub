class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int dp[][] = new int [matrix.length][matrix[0].length];
        int globalMin=Integer.MAX_VALUE;
        for(int i =0 ; i < matrix.length; i++) {
            
            for(int j=0; j < matrix[i].length;j++) {
                int min = Integer.MAX_VALUE;
                if(i==0) {
                    dp[i][j]=matrix[i][j];
                    if(i==matrix.length-1){
                        //last row if its only a single row
                        globalMin=Math.min(globalMin, dp[i][j]);
                    }  
                    continue;
                }
                if(j-1>=0){
                  min = Math.min(min, dp[i-1][j-1]+matrix[i][j]);
                } 
                if(j+1< matrix[0].length) {
                    min = Math.min(min, dp[i-1][j+1]+matrix[i][j]);
                }
                min = Math.min(min, dp[i-1][j]+matrix[i][j]);
                dp[i][j]= min;
                if(i==matrix.length-1){
                    //last row
                    globalMin=Math.min(globalMin, dp[i][j]);
                }   
            }
            
            
        }
        for(int a[]: dp){
            System.out.println(Arrays.toString(a));
        }
        return globalMin;
        
    }
}