class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // cannot use set because if elemenet is duplicate in bot hit should appear multiple times in the reuslt.
        // you count each element in both arrays and htne take the minimum and enumerate that in the result.
        // you keep a count nad the nif found from the second array you keep adding it to result uin tul that count is zero
        //
        HashMap<Integer, Integer> map = new HashMap<>();
        if(nums1.length> nums2.length){
            int ap[] = nums1;
            nums1=nums2;
            nums2=ap;
        }
        for(int i: nums1) {
            map.merge(i, 1, Integer::sum);
        }
        List<Integer> list = new ArrayList<>();
        
        for(int i : nums2){
            if(map.containsKey(i) && map.get(i)>0) {
                list.add(i);
                map.put(i, map.get(i)-1);
            }
        }
        
        int result [] = new int[list.size()];
        int o=0;
        for(int i : list){
            result[o++]=i;
        }
        return result;
    }
    /*
        Above solution has problemns because we have to think about we need extra space nad updates to map. 
        in a way we are traversing both arrays completely.
        you take small array put it in themap O(m) time
        now you take larger array and traverse entire large continously checking map for each element. if it is large it is found to have more elements than num1 which will never gp in result array.
        if we take anoter hash ma to store count you will traverse larger array
        o(m) +O(n) time is required
        
    */
    // public int[] intersect1(int nums1[], int nums2[]) {
        //if we sort the array then we can stop traversering larger array oncve we hit larger than mxa of smaller array.
        // for that we will have to srt the larger array. n log n . if the arrays are already sorted then it will be faster.you traverse the larfer array.
//             traverse the smaller array. 
        // note the amx frro//m smaller array when you traverse and stop when reaching the max in larger array. 
            
    // }
}