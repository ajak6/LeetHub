/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray m) {
        //access the element at index i 
        // or you can size of the array.
        
        /*
            Search a number using this k
            case 1: find mid and if the mid is greater than if you compare mid with mid-1 and mid+1 if it is increasing 
            it means then number is probably in the left.
            if it is not found in the left subarray you will also have to try in the right array.
            
        */
        // 1. Find mountain 
        // 2. Search in left and then search in right.
        
        // to search mountain you will cal twice in each loop.]
        int l = 0;
        int r = m.length();
        
        while(l<r){
            int mid = (int)Math.ceil(l + ((r-l)*1.0/2));
            System.out.println("mid "+ mid);
            if(mid>0 && m.get(mid-1) < m.get(mid)){
                l = mid;
            } else {
                r = mid-1;
            }
        }
        System.out.println("Mountain "+ l);
        int mountain = l;
        
        int index = binarySearch(0, mountain,m, target, true);
        
        if( index == -1 ) {
            return binarySearch(mountain+1,  m.length()-1, m , target, false);
        }
        return index;
        
    }
    
    public int binarySearch(int l , int r, MountainArray m, int target, boolean increasing){
        
        while(l<=r){
            int mid = l + (r-l)/2;
            int curr = m.get(mid);
            if(curr == target){
                return mid;
            }else if(curr> target){
                if(increasing)
                    r=mid-1;
                else
                    l=mid+1;
            }else{
                if(increasing)
                    l=mid+1;
                else
                    r=mid-1;
            }
        }
        return -1;
    }
}