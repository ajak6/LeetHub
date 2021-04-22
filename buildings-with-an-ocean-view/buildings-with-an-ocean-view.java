class Solution {
    public int[] findBuildings(int[] heights) {
        // so bascially we have to find alll mountains in an array?
        //start from the end and keep counting the indexes if they are highesr than index 
        
        // [4,2,3,1] - 0, 2, 3
        // [5,4,3,2] = 0,1,2,3
        // 
        // [5,1,2,6] - 3 
        //common patten is we will only be able to find the 
//         start from the end. add the last index.
//             keep track of max height you hav see and go to the left 
//             if you see a heigh higher than max seen than it cannot have ocean view.
//                 keep adding elements to the right since we need s
        int max = heights[heights.length-1];
        int result [] = new int[heights.length];
        int resIndex = result.length-1;
        result[resIndex--]= heights.length-1;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(heights.length-1);
        for(int i=heights.length-2; i >=0; i--) {
            if(heights[i]>max){
                max=heights[i];
                result[resIndex--]=i;
                list.addFirst(i);
            }
            
        }
        int actual [] = new int[list.size()];
        int x=0;
        for(int i: list){
            actual[x++]=i;
        }
        return actual;
    }
}

//tes cases:
