class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        //ok so from i 0 to k array is sorted
        // k to n array is sorted decreasing.
        // we need to find the mountain.
        //we can do linear search but it will be slow
        int l =0;
        int h = arr.length-1;
        while(l < h){
            int mid = (int)Math.ceil(l + ((h - l ) * 1.0 )/2);
            if(arr[l] <= arr[mid]){
                if(mid-1>=0 && arr[mid-1]< arr[mid]){
                    l=mid; // this is risky since with 0,1 a(left) == a(mid)    
                }else {
                    h=mid;
                }
                
                
            } else {
                h = mid-1;
            }
            
        }
        return l;
    }
}