class Solution {
    public int maxArea(int[] height) {
       // Brute force for every number start form the end and try to find the max bnumber and keep calculating the area using hthe min height
       // among 2 people.
        int max =0;
//         for (int i=0; i < height.length ; i++) {    
//             for(int j=height.length-1; j>i; j--) {
//                max= Math.max(max, (j-i) * Math.min(height[i], height[j]));
//             }
            
//         }
//         return max;
        
        // l and r
        int l=0;
        int r= height.length-1;
        while(l<r){
            
            //cal area
            //when both are equal this becomes a problem.
            
            max = Math.max(max, (r-l)*Math.min(height[l], height[r]));
            if(height[l]>height[r]){
                r--;
            }    else{
                l++;
            }
        }       
        return max;
    }
    
}
//lets start from left = mid
//right mid+1
//whoever is smaller moves
//instead of incremental - lets do a binary search in left part to find a number but this is 









































































//not in increasing order so won't work.
// public int maxArea2(int[] height) {
//         //[1,8,6,2,5,4,8,3,7]
//         //[1,8,19,7,14,9,8]
//         int left = 0;
//         int right = height.length-1;
//         int max = 0;
//         while(left<right) {
//             int area = (right - left) * (Math.min(height[left], height[right]));
//             max=Math.max(max,area);
//             if(height[left]<height[right]) {
//                 left++;
//             }else {
//                 right--;
//             }
//         }
//         return max;
//     }
