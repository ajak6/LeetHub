class LRUCache {

    ListNode runninghead;
    ListNode head; // points to oldest element
    ListNode tail; // tracks the recent element all inserts will happend after tail next
    HashMap<Integer, ListNode> cache;
    int size;
    
    public void printList(){
        runninghead=head;
        int i = size;
        System.out.println("Current size "+ cache.size());
//         while(runninghead!=null && i >=-2){
//             System.out.print(runninghead.val + " -> ");
//             runninghead=runninghead.next;
//             i--;
            
//         }
        System.out.println();
    }
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        head = new ListNode(0, 0);
        tail = new ListNode(9, 9);
        runninghead=head;
        size = capacity;
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        //get from map
        //update ordder 
        System.out.println("Before get");
        int result = -1;
        printList();
        if(cache.containsKey(key)){
            ListNode node = cache.get(key);
            removeNodeFromCurrentPosition(node);
            insertAtTail(node);
            result = node.val;
        }
        System.out.println("after get");
        printList();
        return result;
    }
  
    
    public void put(int key, int value) {
        System.out.println("Before insert");
        
        printList();
        if(cache.containsKey(key)) {
            ListNode node = cache.get(key);
            node.val = value;
            removeNodeFromCurrentPosition(node);
            insertAtTail(node);
        } else {
            ListNode node = new ListNode(key, value);
            insertAtTail(node);
            if(cache.size() == size){
                ListNode remove = removeHead();
                //we need to remove this from the cache as well for that we ned the key.
                cache.remove(remove.key);
            } 
            cache.put(key, node);
        }
        System.out.println("after insert");
        printList();
    }
    
    
    public void insertAtTail(ListNode node) {
  
        ListNode prevTail = tail.prev;
        tail.prev=node;
        node.next = tail;
        node.prev=prevTail;
        prevTail.next = node;
        
        // size++;
        
    }
    //least used
    public ListNode removeHead() {
        // if(size==0)return; // nothing to remove;
        ListNode toRemove = head.next;
        // size--;
        
        head.next = toRemove.next;
        toRemove.next.prev = head;
        return toRemove;
        
    }
    
    public void removeNodeFromCurrentPosition(ListNode node) {
        // size--;
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next=next;
        // if(next!=null){
        next.prev= prev;
        // }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


// what do we need?
/*
1. for get operation we want to know whether this key is present in our cache or not.
    1. Get from hashmap and update its recency since it is accessed just now.
    2. 
2. For put:
    1. Store this new element in the hashmap
    2. Update this to be the most recent element in your ordered list.
    3, If capacity is full thenremove the oldest elemet from the array?
    4. we need some structure which can find uot the oldest element in our cache. Like a heap sorted by timestmap/
    5. if we use head and an element is accesed its time steamp is updated bt  heap will not resort htelement.
    6. Tree Map also faces similar issue?
    5/ if tereMap key is composed of key and timestmpa we can use it to ssort but get operation will be impiossible.
    we will need ot create a list in which order sows the most recent to least recent element in the cache.
    so a double link list will be good to move elements as they come in with constant time operation.
    
    
*/

class ListNode {
    
    ListNode next;
    ListNode prev;
    int val;
    int key;
    public ListNode(int key, int val ){
        this.val = val;
        this.key = key;
    }
}