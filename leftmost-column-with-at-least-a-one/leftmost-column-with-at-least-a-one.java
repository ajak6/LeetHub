/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix bm) {
        
        //left most column with a 1
        // brute force run every collum and find a 1,
        
            // call get(row, col) - > vaklue of a row and col.
            //sorted rows.
            // dimensions can return the min and max.
        // sorted so binary search in first row.in next if foiund note that number
        //     in next row only go a fginary search for 1 
        
        List<Integer> size  = bm.dimensions();
        int lmax = size.get(0);
        int rmax = size.get(1);
        
        int miCol = rmax + 1;
        int rnew =rmax-1;
        
        for(int i=0; i < lmax; i++) {
            // rnew =foundAt;
            //in row i we will do a binary search for zero. to find th first inde of 1. 
            int l =0;    
            while(l<rnew){
                int mid = l + (rnew-l)/2;
                int valMid = bm.get(i, mid);
                
                if(valMid==1) {
                    rnew=mid;
                } else{
                    l=mid+1;
                }
            }
            if(bm.get(i, rnew) == 1) {
                miCol = rnew;
            }
        }
        return miCol == rmax+1 ? -1 : miCol;
                
    }
}