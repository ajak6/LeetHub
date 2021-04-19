class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         // n logn you do by hashtable and heap
//         //create the frequency map
//         //oput in the minheaop
//         //pop minHeap when size grow higher than k rto remove the least frequeny elelenmtn/
        
//         //to do this in linear time without sorting. 
        
        
//          // n is the array size
        
//         // most frequency elements so we need to count the frequency of each element but not sort them else it will take nlogn time.
//         //  
            
//     }
    
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = getFrequencies(nums);
        LinkedList<Integer>[] buckets = bucketSort(frequencies, nums.length);
        
        int[] ans = new int[k];
        int i = 0;
        
        for (LinkedList<Integer> bucket: buckets) {
            if (bucket == null) continue;
            
            for (int num: bucket) {
                ans[i++] = num;
                if (i == k) return ans;
            }
        }
        
        return ans;        
    }
    
    private Map<Integer, Integer> getFrequencies (int[] nums) {
        Map<Integer, Integer> frequencies = new HashMap<>();
        
        for (int num: nums) {
            frequencies.compute(num, (k, x) -> x != null ? x + 1 : 1);
        }
        
        return frequencies;
    }
    
    private LinkedList<Integer>[] bucketSort(Map<Integer, Integer> frequencies, int max) {
        LinkedList<Integer>[] buckets = new LinkedList[max];
        
        for (Map.Entry<Integer, Integer> entry: frequencies.entrySet()) {
            int num = entry.getKey();
            int frequency = entry.getValue();
            int index = max - frequency;
            
            if (buckets[index] == null) buckets[index] = new LinkedList<>();
            buckets[index].addFirst(num);
        }
        
        return buckets;
    }
}