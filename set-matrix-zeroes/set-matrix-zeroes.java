class Solution {
    public void setZeroes(int[][] matrix) {
        
        //traverse and set node the cols and rrow you need to set to zero in a set. then at tehen end set them to zxero
        
        Queue<int[]> queue = new LinkedList<>();
        for(int i =0 ; i < matrix.length ; i++){
            for(int j =0 ; j < matrix[i].length; j++){
                if(matrix[i][j] == 0) { 
                    queue.offer(new int[]{i,j});
                }
            }
        }
        
        HashSet<Integer> rows = new HashSet<>();
        HashSet<Integer> cols = new HashSet<>();
        while(!queue.isEmpty()) {
            
            int [] a =  queue.poll();
            if(rows.add(a[0])) {
                for(int j=0;j<matrix[0].length;j++) {
                    matrix[a[0]][j]=0;
                    // cols.add(j);
                }
                
            }
            if(cols.add(a[1])){
                for(int j=0; j < matrix.length; j++) {
                    matrix[j][a[1]]=0;
                    // rows.add(j);
                }
            }   
        }
        
        
        
        
    }
}