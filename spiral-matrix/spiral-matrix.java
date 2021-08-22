class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        // 0,0 - 0,1- 0,2 - readches the end now your row start should increase since you will nefver start from her
            //4 limits start left col right col
            //top row and bottom row
            //start from the first row
            //for row you limits are from left to righ
            //top++
            //from top to bottom now right--
            //from right to left on bottom row, bottom --
            // from bottom to top, left++
            //repeat from left to right top row
        int top=0;
        int bottom = matrix.length-1;
        int left =0;
        int right = matrix[0].length-1;
        List<Integer> list = new ArrayList<>();
        while(left<=right){
            
            for(int i=left; i <= right; i++){
                list.add(matrix[top][i]);
            }
            top++;
            if(top>bottom) break;
            for(int i=top ; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right--;
            if(left>right)break;
            for(int i=right;  i >=left; i--) {
                list.add(matrix[bottom][i]);
            }
            bottom--;
            if(top>bottom) break;
            for(int i=bottom; i >=top;i--) {
                list.add(matrix[i][left]);
            }
            left++;
            
            //left =1, right=1, top=1 bottom =1
            
        }
        return list;
            
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public List<Integer> spiralOrde1r(int[][] matrix) {
        
        // start from 0,0 either we can come up with a element which can explain
        // i,j - > add 1 to j when j reached max add 1 to i when i is reached add -1 to j
        // when ju is zero -1 with i but don't visited already visitedd
        //every time you hit a limit that limit should be reduced by 1 and increased by 1 respectiovely 
        //so next spiral does not revisit already visited elements.
        
        int iMin =0;
        int jMin=0;
        int iMax=matrix.length;
        int jMax = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        int adder = 1;
        // initiall adder to j/ when jmax isreached jMax-- and then sith adder to i
        // // When imax is reached imax-- and then change adder to -1 apply to j
        // int i =iMin;
        //  int j=jMin;
        int iCount =0;
        int jCount =0;

        int dir=0;
        //we have 4 boundaries 
        int top=0;
        int left=0;
        int right= matrix[0].length-1;
        int bottom = matrix.length-1;
        //only print 1 direciton at a time
        while(top<=bottom && left<=right){
            
            if(dir==0){
                //traverse from left to right
                for(int i=left; i <= right; i++){
                    list.add(matrix[top][i]);
                }
                top++;//sinc etop row is done
            }
            else if(dir==1){
                //top to bottom
                //start from top right to bottom right
                for(int i=top; i <=bottom;i++){
                    list.add(matrix[i][right]);
                }
                right--;//right most column is done
            }
            else if(dir==2) {
                //right bottom to left bottom
                for(int i=right;i>=left; i--){
                    list.add(matrix[bottom][i]);
                }
                bottom--;
            }else if(dir==3) {
                //bottom left to top left
                for(int i=bottom; i >=top; i--){
                    list.add(matrix[i][left]);
                }
                left++;
            }
            dir=(dir+1)%4;
        }
        return list;
//         while(result.size()<matrix.length*matrix[0].length){
//             //traverse right from jmin to jmax keeping i at the 0 then 1 then 2
//             // i row++;
//             //j=col++;
//             i=iCount++;
//             j=jCount++;
//             for (; j < jMax;) {
//                 result.add(matrix[i][j++]);
//             }
//             iMin++;
//             jMax--;
//             i++;
//             j--;
//             //traverse from the col to down
//             //i++
//             //j--; come back to last column
            
//             while(i<iMax) {
//                 result.add(matrix[i++][j]);
//             }
//             i = iMax-1; //get i back to last iMax
//             iMax--; // next time we do not have to traverse to last of grid but 1 less
//             j--; //since current column is traverse we need to traverse left from 1 less column than jMax
//             while(j>=jMin) {
//                 result.add(matrix[i][j--]);
//             }
            
//             jMin++;
//             i--;
//             j++;
//             while(i >= iMin) {
//                 result.add(matrix[i--][j]);
//             }
            
//         }
//         return result;
    }
}