class Solution {
    public int findKthPositive(int[] arr, int k) {
        //increasin series
        //all positive.
        //sorted increasing.//
        
        // no duplicates
        //kth postive which is missing
        // so you move from i-=0
        //traverse the keep reduving when you don't find something which is i+1
        //when k becomes zero i is the missing number
        //2 5 6 - starts at 2 but it should start from 1 so find until keep increasing until you find a counter equal to arr[i] and see how many are missing.
       
        int ans =0;
        HashSet<Integer> setr = new HashSet<>();
        
        for(int i : arr){
            setr.add(i);
        }
        int i=1;
        for(i =1; k>0;i++){
            
            if(!setr.contains(i)){
                k--;
            }
            if(k==0)break;
        }
        return i;
    }
}