class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        // cannot use set because if elemenet is duplicate in bot hit should appear multiple times in the reuslt.
        // you count each element in both arrays and htne take the minimum and enumerate that in the result.
        // you keep a count nad the nif found from the second array you keep adding it to result uin tul that count is zero
        //\
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        if(nums1.length> nums2.length){
            int ap[] = nums1;
            nums1=nums2;
            nums2=ap;
        }
        for(int i: nums1){
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
}