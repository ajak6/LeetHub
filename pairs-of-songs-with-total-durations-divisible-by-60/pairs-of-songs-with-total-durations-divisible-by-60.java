class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        // two sum problem but here it will be adivison operator.
        // pair of songs. -> 
        // every song has a duration.
            // find pairs in the array whoes sum is divisble by 60
        // brute forece pick song add it other and check which are icisible by 50
        
        // what if we normalize every song duration by taking % by 60 and then just run two sum which gives 60?
        //     //360 + 180
        //     // 255 = 15 , 165
        
        // normazlie every time and sort
       
//         but in the answer we want number iof unuioquihe pairs if we nornmnalize it we will not get the pairs.
//             because we will end up with dupliocates?
//             may be we can differenetial wityh indexes
        
//             we want unique pairs so it can be based on indexes/>>>>>.... no it is based on values. so store their previous values as well
//             when you find keep the pair and do a set o find unuique count.
                
//                 using of swet to avoid duplicates?
//                 not just value but index is uniquely differentiating. so you will store and their indexes. 
                
            
            // you store the uibndex of each value but they them self can make the sm as well right?
            //     yeah so 
            //     60,60,60
            //     0, 0,1,2
            //     if we normalize we will not be able to din tou that these are 0 or actual 60s what if we store 
            //         all other pairs 
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0 ; i < time.length; i++) {
            // map.merge(time[i]%60, 1, Integer::sum);
            time[i]=time[i]%60;
        }
        int count=0;
        for(int i=0; i < time.length ; i++) {
            
            for(int j = i+1; j< time.length ; j++){
                if(time[i]+time[j]==0 || time[i]+time[j]==60){
                    count++;
                }
            }
        }
        return count;
        
        
        
        
        
    }
}