class Solution {
    public int findMinArrowShots(int[][] points) {
       //first intuition is we need to find the diameter  which overlap with others.
        /*
        if an arrow is shot at x where more than 1 diameter is overlapping it will burst more ballongs hence 
        we will requirs less arrows.
        Case 1 when  i diameter overlaps with more than 1 ballongs for e.g.
        either its entire diameter is overlapped.
        or both of its ends are overlapped now we donot need to burst this ballon from both end.
        
        for each merged interval we will need an arrow somewhere where it will shoot everyballong.
        where the arrow should be shot is not the question which is simplifies the problem a little bit.
        just merge the intervals for each merged interval you need 1 arrove?
        
        if you do a running sum and find one ballong ends here if ytou hit arrow here 
        //you will burst all the balloings till now and running SUm should be zeero
        now there are not open ballongs to be burst. so you start fresh
        ignore all the ones which are still ending because you will see thir -1 later on. but it is weird 
        since Ui have already bursted some baloons whoes end will come later in the line sweep I want top
        avoid using those ends again and declare than these are a done deal.
        
        bscially we a */
        
        Arrays.sort(points, (x,y) ->  Integer.compare(x[0],y[0]));
        // Arrays.sort(points, Comparator.comparing(Integer::compare));
        PriorityQueue<int[]> endingBaloons = new PriorityQueue<>((b1, b2) -> b1[1]- b2[1]);
        int arrow=0;
        for(int i=0;i<points.length; i++){
            
            int [] baloon = points[i];
            // System.out.println("String ");
            if(!endingBaloons.isEmpty()){
                
                int endingBaloon[]  = endingBaloons.peek();
                System.out.println("String " + Arrays.toString(endingBaloon));
                if (endingBaloon[1] < baloon[0]) {
                    arrow++;
                    endingBaloons = new PriorityQueue<>((b1, b2) -> b1[1]- b2[1]);
                }
                
                
            }
            endingBaloons.offer(baloon);
        }
        if(!endingBaloons.isEmpty()){
            arrow++; // last set of baloons will never be counted so counting them here
        }
        return arrow;
        
        
        }
}