class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //if we can sort
        Arrays.sort(nums);
        //select 1 and then search of a 2 sum in left over since we do not want duplicates.
            Set<List<Integer>> list = new HashSet<>();
        for(int i =0; i < nums.length ; i++){
            
            int first = nums[i];
            find2Sum(nums, i+1, first, list);
        }
        return new ArrayList<>(list);
    }
    public void find2Sum(int nums[], int s, int target, Set<List<Integer>> list) { 
        int l = s;
        int r = nums.length-1;
        
        //you need all posibility
        while(l<r) {
            if(target+nums[l]+nums[r]==0){
                List<Integer> ll = new ArrayList<>();
                ll.add(target); ll.add(nums[l]);ll.add(nums[r]);
                list.add(ll);
                l++;r--;
            }else if(target+nums[l]+nums[r]<0){
                l++;
            }else{
                r--;
            }
        }
        
        
    }
    
    public List<List<Integer>> threeSum1(int[] nums) {
        //backtrack and try all possible options
        //select 1 and then find 2 sum 
        //We will also find
        // we need the numbers which makes it easy
        
        //you also want to know that select index are not same
        //when selecting a number select a you need to track its index.
        List<List<Integer>> result = new ArrayList<>();
        if(nums==null || nums.length <3)return result;
        HashMap<Integer, List<Integer>> twosum = new HashMap<>();
        
        // another thing we will needd to take care is if we have selected an index we don't end up selected it again
        //deduping the solution
        for(int i=0; i < nums.length ; i++) {
            twosum.computeIfAbsent(nums[i], x-> new ArrayList<>()).add(i);  //  i is needed to know if we are not selecting the same guy.
                                    //what if ther eware duplicates so we will need list of indexes   
        }
        HashMap<String, List<Integer>> set = new HashMap<>();
        for(Map.Entry<Integer,List<Integer>> entry: twosum.entrySet()){
            
            int x=entry.getKey();
            List<Integer> i=entry.getValue();
            List<List<Integer>> values = twosum(nums, -x, twosum, i.get(0));
            //dudupe using string.
            // if(values==null) continue;
            //something ins the set which we can equate
            for(List<Integer> val : values){
                val.add(x);
                Collections.sort(val);
                set.putIfAbsent(val.toString(), val);
            }
            
        }
        return new ArrayList<>(set.values());
    }
    
        // brute force:
        // select a numer find find 0 - this number
        //  try to find this numer in the array as a 2 sum problem
        //  conditions all indexes must be different.
        //  how to avoid duplicates? wither use a set and avoid ?
        
        public List<List<Integer>> twosum(int nums[], int target, Map<Integer, List<Integer>> twosum, int avoidIndex){
         List<List<Integer>> result = new ArrayList<>();
            for (int i =0 ; i < nums.length ; i++) { 
                if(avoidIndex == i) continue;
                int find = target - nums[i];
                //for 000 how will you handle?
                //
                if(twosum.containsKey(find)){
                    List<Integer> indexes = twosum.get(find);
                    for(int index: indexes) {
                        if(index==i) continue;
                        if(index==avoidIndex) continue;
                        //it can give you that sum, you can pick all the indexes. no you don't want to duplicates.
                        List<Integer> list = new ArrayList<>();    
                        
                        list.add(nums[index]);
                        list.add(nums[i]);
                        result.add(list);
                        break;
                    }
                }
                
            }
            return result;
            
            
        }
        
        
        
    
}