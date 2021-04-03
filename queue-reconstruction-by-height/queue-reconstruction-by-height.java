class Solution {
    public int[][] reconstructQueue(int[][] people) {
       
        int result[][] = new int[people.length][2];
        
        
        TreeMap<Integer, PriorityQueue<int[]>> map = new TreeMap<>(Comparator.reverseOrder());
        for(int i=0; i < people.length ; i++) {
            map.computeIfAbsent(people[i][0], x1-> new PriorityQueue<>((x,y)-> x[1]-y[1])).add(people[i]);
        }
        
        // if you have 7 as heighest then just arrange them
            // then pick next h
        LinkedList<int[]> res = new LinkedList<>();
        for(Map.Entry<Integer, PriorityQueue<int[]>> et : map.entrySet()){
            
            PriorityQueue<int[]> personsOfHeightX=et.getValue();
            
            while(!personsOfHeightX.isEmpty()) {
                int p [] = personsOfHeightX.poll();
                res.add(p[1], p);
            }
            
        }
        // int res[][] = new int[people.length][2];
        res.toArray(result);
        return result;
        // insert atthe kth position use array list and then conery it to native array.
        //store everyperons withy same height in a map and prioriyQueue so that they are oryed.
        //since we are storing everyelement based on their height if we arrange highest ones first then 
        //it means that heighest ones are 
        
        
        /* 
//        have a heap sorting elements by ki and then hi
//        you picjk the smallest heigh t with lowest number of people ahead of him
//        for 0th position it always be zero people ahead of him
//        if we always puill elements where people ahead of him are lowest
//        but if its height itselft is very heigh for e.x. 10,0 and others are 5,0, 4,1 ,3,2 
//        so in this case the pepople with lower heights will come first and 10-,0 will be alst.
//        so the actual height also gets some priority, height the height lowest the priority.
       
//        Greedy approach says pick a value and we may need to move it again
//        so somehow when a elements comes we need to find its correct positoin in the arrray 
//        if there is someat this position this guy needs to move to a different opisition but it should 
//        keep satifying the condfition we want so we cannot move them as is.
//        picking an element we only need to see the front elemens already in the queue.
//        keep traversing and if you see something breaking the conditions with the new lemeent present.
//        you remove itcan it hurt all other elements after that element ues but we don't have fix it now.
//        when that element again gets picked we will move others but this guys can still get moved when next element comes  I am not sure if this will ever stop.
//        */
        
//         PriorityQueue<int[]> queue = new PriorityQueue<>((x, y) -> {
//             int r = x[1] - y[1];
//             return r==0? x[0]-y[0]:r;
//         });
        
//         for(int i[]: people) {
//             queue.offer(i);
//         }
//         //if it is a tree we can store how many elements are higher than this elelment which can help us
//         // move this element at its correct locaiton?
//          // but that is what the 1th position signifies?
//         int result [][]  = new int[people.length][2];
//         int i=0;
//         while(!queue.isEmpty()) {
//             int person []=queue.poll();
//             System.out.println("queue "+queue);
//             System.out.println(Arrays.toString(person));
//             int peopleHigherThanMe = person[1];
//             int myHeight =person[0];
//             //loop through the reuslt and find out its positionl
            
//             for(int x =0 ; x <= i ; x++) {
            
//                 if(result[x][0]>myHeight){
//                     if(peopleHigherThanMe == 0) {
//                         //it means we have there are now enough people higher than me and it satifies the requiremenmt to put me at this positino.
//                          //x is my correct position as per the current element in the array
//                         int removeCurrent []= result[x];
//                         for(int y=x;y<i;y++){
//                             queue.offer(result[y]);
//                         }
//                         i=x; // reset the result since all existing results after x are invalidated.
//                         //all elements aafter this needs to be reevaluated/
//                     }
//                     peopleHigherThanMe--;
                    
//                 }
//             }
//             //but if does not satisfy the requiremenet as of now we cannot do anything for e.g.10,1 says I need an elemenet higher than me but as of now we have not placed anyone bECAUSE 7,3 WILL ARRIVE LATE this is not possible. If we have 11,0 then it should be in the result before 10,1 if we have 11,1 as well it means
//             // something higher than 11 and10 which is 12 should have 12,0 and should be in the reuslt anyways.
            
//             result[i]=person;
//         }

//         return result;
        
        
    }
}