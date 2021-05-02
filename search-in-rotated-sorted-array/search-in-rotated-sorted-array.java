class Solution {
    public int search(int[] nums, int target) {
        
        //we can still use BS if the array is rotated. Is means there are 2 sorted arrays clubbed together.
        
        //i just needt o mkae a smart decision where our target migh lie in this rptated array
        //cases missed
        //[4,5,6,7,8,1,2,3] 8
        //[4,5,6,7,0,1,2] 0
//simpler approach find the rotaion point and the nsearhc in both ararys
        this.target = target;
        int l=0;
        int r=nums.length-1;
        if(nums[l]>nums[r]){
            
            while ( l < r) {
            //fidn out where the rotation point it
            
                int mid = l + (r-l)/2;
                if(nums[mid] > nums[l]){
                    l=mid;
                } else {
                    r=mid;  
                }
            }
        } else{
            return search(nums, 0, nums.length-1);    
        }
        
        // l wil;l be the highest element in the array after whioch the array is rotated
        System.out.println(l);
        
        int x = search(nums,0,l);
        if(x>=0){
            return x;
        }
    
        return search(nums, l+1, nums.length-1);
        
    }
    int target;
    public int search(int nums[], int i, int j){
        while(i<=j){
            int mid = i + (j-i)/2;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]< target){
                i=mid+1;
            }else {
                j=mid-1;
            }
        }
        return -1;
    }
}