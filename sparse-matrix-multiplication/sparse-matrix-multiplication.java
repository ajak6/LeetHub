class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        //sparse means that its mostly zeros
        //usually 2 mat multiplication will take mat1 * mat2
        
        //matrix multiplication
        //loop for each row in left
        int result [][] = new int[mat1.length][mat2[0].length];
        for(int i=0; i < mat1.length; i++) { //row for left 
            //traverse cols from 0 to length of first they will be become rows for mat2
            int row[]=mat1[i];
            
            for (int j =0 ; j < mat2[0].length; j++) {
                int sum=0;
                for(int co = 0; co < row.length; co++) {                    
                    sum+=mat1[i][co] * mat2[co][j];
                }
                result[i][j]=sum;
            }
        }
        return result;
        
        
    }
}