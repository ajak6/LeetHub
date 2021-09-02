class Solution {
    //case missed : if you sort and count you will miss the case with duplicates
    // 0, 1, 1, 2, 3 -> you need to count 0 , 1, 2, 3 - simple fix ignore duplicates and don't reset count
    //dp
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i=0; i < nums.length;i++) {
            set.add(nums[i]);
        }
        int max = 1;
        for(int i=0; i < nums.length; i++) {
            if(!set.contains(nums[i]-1)){//this means this is the largest we are seeing
                int count =1;
                int search = nums[i]+1;
                while (set.contains(search)){
                    count++;
                    search=search+1;
                }
                max=Math.max(max, count);
            } 
        }
        return max;
    }
    
    /*
    Set<Integer> num_set = new HashSet<Integer>();
        for (int num : nums) {
            num_set.add(num);
        }

        int longestStreak = 0;

        for (int num : num_set) {
            if (!num_set.contains(num-1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (num_set.contains(currentNum+1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
        */
    
    public int longestConsecutive3(int[] nums) { 
        HashMap<Integer,Integer> set = new HashMap<>();
        int max=0;
        int min=Integer.MAX_VALUE;
        for(int i: nums){
            set.put(i, 1);
            max=Math.max(i,max);
            min=Math.min(i,min);
        }
        int max1=0;
        for(int i = min; i <= max ; i++) {
            if(!set.containsKey(i)) continue;
            if(set.containsKey(i-1)) {
                set.put(i, set.get(i-1)+1);
            }
            max1 = Math.max(max1, set.get(i));
        }
        return max1;
    }
    
    //n logn algorithm
    public int longestConsecutive4(int[] nums) {
        //for each number pick the number 1 lower and get its lenth and add 1 to it
        //that lower number will loop to find a number lower than it and recures for that number,
        // always go in small direction?
        //sort the array and traverse counting the consevutive sequence
        //check n and n-1 have a diff of 1 then start counting 2= and keep checking
        //if dtops reset count =1 and continue;
        if(nums==null || nums.length==0)return 0;
        Arrays.sort(nums); 
        int count =1;
        int max =0;
        // System.out.println(Arrays.toString(nums));
        for(int i=1; i < nums.length;i++){
            
            if(nums[i-1]+1 == nums[i]){
                count++;
            } else if(nums[i-1]==nums[i]) continue;
            else{
                max=Math.max(max, count);
                count=1;
            }
        }
        max = Math.max(max, count);
        return max;
    }
}