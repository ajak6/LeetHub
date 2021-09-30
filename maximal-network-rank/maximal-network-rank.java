class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        //missed edge cases:
        //just picking the 2 max ranks: we don't know they are connected or not so can't consider reducing 1 edge or not
        //Then picked top 2 ranks and saw they were connected or not wrong in case there are 3 with same ranks
        //used priorityqueue to fetch the top 1 and then loop over all other ranks to see wwhich ne gives us max rank0 > this is wrong when there are top 1 freqency is same second freqecy so which
        //top 1 we chose determines the result. If we chose the top 1 as something which is connected to second one we will reduce 1 but we could have selected the third one which had the same frequyency
        // but not connected to top 1 or second one to get max rank.
        // if no edges then adj.get(i) returns null better handle such cases before
        if(roads==null || roads.length==0) return 0;
        int count[] = new int[n];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i=0;i < roads.length ;i++){
            count[roads[i][0]]++;
            count[roads[i][1]]++;
            map.computeIfAbsent(roads[i][0], c0-> new HashSet<>()).add(roads[i][1]);
            map.computeIfAbsent(roads[i][1], c0-> new HashSet<>()).add(roads[i][0]);
        }
        int max=0;
        // If there are multiple wiht same frequiency how will chose the top one.
        for(int i=0; i < count.length ; i++){
            if(count[i]==0) continue;
            for(int j=i+1; j < count.length ;j++){
                int rank = count[i]+count[j];
                if(map.get(i)!=null && map.get(i).contains(j)){
                    rank--;
                }
                max=Math.max(rank,max);
            }
                
        }
        
        return max;
        
    }
}