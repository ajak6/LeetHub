/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        //we are given n and version start at 1 so something between 1 to n is bad.
        
        //pick mid n/2 and see if it bad if not then search right
        //if yes then limit high to this index and search in left hald
        
        int l =0, r=n;
        while(l<r){
            int mid = l + (r-l)/2;
            if(isBadVersion(mid)){
                r=mid;
            }else{
                l = mid+1;
            }
        }
        return r;
    }
}