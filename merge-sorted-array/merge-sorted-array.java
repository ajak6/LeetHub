class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        //ideally no extrac space
        // [1,2,7,0,0,0] and [2,5,6]
        // start from the end
        int last = nums1.length-1;
        int i=m-1, j =n-1;
        for(; i>=0 && j>=0; last--){
            if(nums1[i]>nums2[j]) {
                nums1[last]=nums1[i--];
            }else{
                nums1[last]=nums2[j--];
            }
        }
        while(j>=0){
            nums1[last--]=nums2[j--];
        }
    }
}