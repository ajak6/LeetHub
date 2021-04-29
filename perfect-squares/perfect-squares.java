class Solution {
    public int numSquares(int n) {
        //least number optimization problem
        //greedy pick the largeet to lowest perfect squares
        //lets say we array a list perfect squares.//
        //recursive relation is for n
        // for n  - least for min(n- all perfectquare) + 1
        
        List<Integer> perfect = new ArrayList<>();
        perfect.add(1);
        int i=2;
        int sq = 4;
        while(sq<=n){
            perfect.add(sq);
            i++;
            sq=i*i;
        }
        return minRec(n, perfect);
    }
    Map<Integer,Integer> memo = new HashMap<>();
    public int minRec(int n , List<Integer> perfect) {
        // System.out.println(n);
        if(n==0) return n;
        if(memo.containsKey(n))return memo.get(n);
        int min = n;
        for(int i=perfect.size()-1; i >=0; i--){
            int sq = perfect.get(i);
            // System.out.println("sq " + sq);
            if(sq > n) continue;
            min = Math.min(min, minRec(n-sq, perfect) +1);
        }
        memo.put(n, min);
        return  min;
        
    }
}