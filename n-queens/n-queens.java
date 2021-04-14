class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        /* choose a row
         /* place a q at each position and call itself with next row
         check all entire column and row for any other queue in the array
         check both diagonals for a queen
         if satifies place and  move to next row calling itelf
         carry current list of list which will have placements 
         internal list can be a char[] or stringBuidler.
         oncce you find that n==0 it means we have oplaced all thequuuen
         we do not have any more queens to place.
         
          char array suuitos ok to run books in up and down and diagonals'
          char array can also be converted to string at the end and 
          reused for next solution.
          we need tempResult for entire board,
          then we also need a char array for currnt row, just extract from the temp reuslt/?????
          */
        List<char[]> tempResult = new ArrayList<>(n);
        for(int i=0; i < n ; i++){
            tempResult.add(new char[n]);
        }
        List<List<String>> result=new ArrayList<>();
        
        int start =0;
        placeQueens(result, 0, tempResult, n);
        return result;
        
    }
    
    public void placeQueens(List<List<String>> result, int row, List<char[]> tempResult, int n){
        
        if(row== n){
            result.add(tempResult.stream().map(thisRow -> new String(thisRow)).collect(Collectors.toList()));
            return;
        }
        char currentRow[] = tempResult.get(row);
        Arrays.fill(currentRow, '.');
        for(int i=0; i < currentRow.length ; i++){
            
            currentRow[i]='Q';
            if(canPlace(currentRow, row, i, tempResult)){
                placeQueens(result, row+1, tempResult, n);
            }
            currentRow[i]='.';
            
        }
    }
    public boolean canPlace(char curr[], int row, int col, List<char[]> currQueens){
        
        //check all rows before this on this column since we are just filling this row there is no need to check entire board because we have not yet filled anything above row.
        for(int i=row-1; i>=0;i--){
            if(currQueens.get(i)[col] == 'Q') return false;
        }
        // first diagonal
        // from row, col -> 3,3 -> 2,4 1,5, 0,6
        //second diagonal
        // from row, col -> 3,3 -> 2,2 1,1 0,0
        // in a loop we can check both values?
        int max  = currQueens.get(0).length;
        for(int i=row-1, k=1 ; i >=0; i--, k++){
            char now [] = currQueens.get(i);
            //get both values in this row for right diagonal and left diagonal
            
            int x = i;
            int y1 = col + k;
            int y2 = col - k;
            if(y1 < max && now[y1]=='Q') return false;
            if(y2 >=0 && now[y2]=='Q') return false;
        }
        return true;
            
    }
}