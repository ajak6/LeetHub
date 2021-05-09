class Solution {
    public int findKthPositive(int[] arr, int k) {
        // index to track missing number in the array
        // first element -k will be that. 
        // storing every nuberin set and loop from 1 to n and count missing number when found the kthmissing retunr
        // if we find out in which interval the missing number is
        // when looking at the nuber in the array we will know hte 
        //k=5 and 2nd index is 5 then ;
        // on 0 we should have 1 i correspods to i+1
        // if if not then a[i]-(i+1) number of missong positives before this
        // if k is higher k-=a[i]-(i+1)
        // else search for k i-1 and i
        //we can do binary search as well
        //if a[mid]-(mid+1) is higher than k then search left.
        //2,3,4,7,11 -> 4-3=1 is missing in left then 7-4=3 missing.
        //11-5=6 so its missing before 11.
        // 11 to 7 = 5 missing
        // 5-3 = 2 missing positives...  11-(5- a[i-1]-(i-1+1)))
        //1 2 3 4
        // 
        if(k<=arr[0]-1){
            return k;
        }
        int l=0;
        int r=arr.length-1;
        while (l<=r) {
            int mid=l+(r-l)/2;
            if(arr[mid]-(mid+1) >=k) {
                r = mid-1;
            } else{
                l = mid+1;
            }
        }
        // use r for calculating 
        // k -= arr[r]-(r+1);
        k -= arr[r]-(r+1);
        return arr[r]+k;
        
            
    
    }
    
    public int findKthPositive2(int[] arr, int k) {
        //increasin series
        //all positive.
        //sorted increasing.//
        
        // no duplicates
        //kth postive which is missing
        // so you move from i-=0
        //traverse the keep reduving when you don't find something which is i+1
        //when k becomes zero i is the missing number
        //2 5 6 - starts at 2 but it should start from 1 so find until keep increasing until you find a counter equal to arr[i] and see how many are missing.
       
//         int ans =0;
//         HashSet<Integer> setr = new HashSet<>();
        
//         for(int i : arr){
//             setr.add(i);
//         }
//         int i=1;
//         for(i =1; k>0;i++){
            
//             if(!setr.contains(i)){
//                 k--;
//             }
//             if(k==0)break;
//         }
//         return i;
        
        // since they are sirted how will you use this infomraiont.
        int count = 1;
        for(int i=0; i < arr.length; i++) {
            
            while (count < arr[i] && k > 0) {
               count++;
                //diff is the total missing numbers
                k--;
            }
            if(k==0) return count;
        }
        
        while(k>1){
            count++;
            k--;
        }
            
        return count;
            
    }
}