class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        //questions
        // costs will be positive
        // cost needs to be minimized
        // 
        //we only need to travel on the datys given it may be more covered but not required and can be ignored for optimization
        /*
        subprblem : minimum cost to travel on day[0] 
        on day yopu reach by either buying a pass yesterdas 
        buy a 7 day pass 7 days ago and reach to this day?>
        buy a 30 day pass 30- or less days ago and reach this day 
        take minimum of these
        from the current day what is minimym cost in last 30 days and take that + 30dayp[ass
        from current in last 7 day what is the minimym cost and take a its cost + 7 days pass
        from the current in lyesterday what is the cost take that +1 day pass to travel today.
        
        even though we are given to travel on certain days if we keep the cost to travel every consecutive days 
        it may not be a problem just keep adding the same cost for the ast day you travelled.
        problem becomes a little easier to compute
        */
        int maxdays = Arrays.stream(days).max().getAsInt();
        int [] dp= new int [maxdays+1];
        
        HashSet<Integer> traveldays = new HashSet<>();
        Arrays.stream(days).forEach(x-> traveldays.add(x));
        
        /*
        minCost = min(dp[i-1]+cost[0], dp[i-7]+cost[1], dp[i-30] + cost[2])
        minCostToReachToday = min(minCostInLast7days + costOf7DayPas, minCostInLast1Day+1DayPass, minCostInLast30Day+30dayPass)
        
        */
        
        // Arrays.fill(dp, Integer.MAX_VALUE);
        // dp indicates cost to travel on day i inside the dp
        dp[0]=0;
        for(int i=1;i<dp.length; i++) {
            int minCost = Integer.MAX_VALUE;
            if(traveldays.contains(i)){
                //should travel on this day from somewhere
                //if this is the first day then whati think the days where you cover other days should return 0
                int costToReachYesterday = (i-1<0?0:dp[i-1]) + costs[0];
                int costTo7day = (i-7 < 0 ? 0 :dp[i-7]) + costs[1];
                int costTo30day = (i-30 < 0 ? 0:dp[i-30]) + costs[2];
                
                dp[i]=Math.min(costToReachYesterday, Math.min(costTo30day, costTo7day));
            } else {
                dp[i]=dp[i-1];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[maxdays];
        
    }
}