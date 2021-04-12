class Solution {
//create a larger array witht extra elementz
    Map<Integer, Integer> map;
    List<Integer> list;
    int totalSum;
    int col=0;
    Random r;
    int prefixSums [];
    public Solution(int[] w) {
        
        //w[i] is the weight
        //probability off i to be puicked should vbe proportiobnal to w[i]
        //create a larger arrray based 
        
        // how will we search . 
        // 
        // map = new HashMap<>();
        map = new HashMap<>();
        totalSum=0;
        // sum=0;
        list=new ArrayList<>();
        prefixSums= new int[w.length];
        for(int i=0; i < w.length; i++) {
            totalSum += w[i];
            prefixSums[i]=totalSum;
            list.add(totalSum);
            map.put(totalSum,i);
        }
        
        r = new Random();
         
    }
    
    public int pickIndex() {
     //generate a int higher than equal to first element in our array and smaller than max elemejt in the array./
        /// random element between list(0) and list.getlast
        // int weight = r.nextInt(sum - list.get(0)) + list.get(0);
       //  int weight = (int) Math.random() * sum;
       //  int index  = Collections.binarySearch(list, weight);
       //  if(index<0){
       //      index=-index-1;
       //  }
       // return index;
        
         double target = this.totalSum * Math.random();

        // run a binary search to find the target zone
        int low = 0, high = this.prefixSums.length;
        while (low < high) {
            // better to avoid the overflow
            int mid = low + (high - low) / 2;
            if (target > this.prefixSums[mid])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
        
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */