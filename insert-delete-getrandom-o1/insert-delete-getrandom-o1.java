class RandomizedSet {
// use a set. and there are insert and delete are find but what about getRandom.//
    
    //get Random - generate a random number and traverse the set and return that random element.
    //it will on time.
    //use an array for each value but deleting is time consuming.
    //use a linked list ubut finding the element it can be o1
    ///hasmap with inde3x -> linkedNode
    //hashmap value -> listNode.
    // listNode - > index. 
    // val at the end of list . store the count int
    //     also update the val list
    //     getRandom  => yuo know the size just find hte index in map nad return gvalue from that listNOdde.
    //     Delete - find the valu and its listnode.
    //     delete the listNode but you will have ot update hteindex of each node since this one is gone.
    
    //arraylist. 
    //key val - > OrderedSet can do the job. 
    // getRandom ->
    //you have the arrayList which stores each element. When an number is deleted the you know is index in the array list/ KsdSwap that number iwt last number,.
    //remove the lst nmber from the list.
    /** Initialize your data structure here. */
    List<Integer> list;
    HashMap<Integer,Integer> map;
    HashMap<Integer,Integer> slot;
    int slotN = 0;
    public RandomizedSet() {
        map = new HashMap<>();
        slot = new HashMap<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        
        if(map.containsKey(val)){
            return false;
        }else{
            slot.put(slotN, val);
            map.put(val, slotN);
            slotN++;
            return true;    
        }
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val))return false;
        //if slot and count is same you will not delete the leement
        slotN--;
        // System.out.println("before remove "+ slot + " slotN " + slotN);
        int slotIndex = map.get(val); //remove this index;
        if(slotIndex == slotN){
            //same element as last inserted value then we just need to delete it
            map.remove(val);
            slot.remove(slotN); //slotN is already reduced.
        } else {
            int valAtMaxSlot = slot.get(slotN);
            map.put(valAtMaxSlot, slotIndex);
            slot.put(slotIndex, valAtMaxSlot);
            slot.remove(slotN);
            map.remove(val);
        }
        
        // System.out.println("After remove "+ slot);
        return true;
    }
    Random random = new Random();
    /** Get a random element from the set. */
    public int getRandom() {
        // System.out.println(slot);
        int size = map.size();
        int index = random.nextInt(slotN);
        return slot.get(index);
        // traverse the set and get the random index from the set
        // constant time getRandom()
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */