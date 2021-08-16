/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        //can have enen or odd elements
        //  1 -2 -3-6-5
        // in the above case : 1,3 2,6 and 5 remains?
        // even swaps with even position
        // odd swaps wih odd positions
        //for swapping we need pointere to even nodes will help swappig odd nodes and eoddven will help in swapping even nodes
        //dummy pointer -> 1 -2 -3-5-6
        //create a node which is 2 ahead of dummy node
        if(head==null || head.next==null || head.next==null)return head;
        
        ListNode newHead = new ListNode();
        ListNode result = newHead;
        newHead.next = head;
        ListNode swapHead = head;
        
        //iterate dummy and swaphead and swapp its next element
        //0 - > 1 -2 -3 -4
        while(swapHead!=null && swapHead.next !=null ){
            swap(newHead, swapHead); //0,1
            newHead=newHead.next.next;
            swapHead=newHead.next;
            
        }
        return result.next;
        
    }
    
    public void swap(ListNode node1, ListNode node2)
    {   
        // D- 1-2-3-4-5
        if (node2.next== null) return;
        ListNode node1Save = node1.next; // 1-2-3-4-5 
        node1.next = node2.next; // d-2-3-4-5 // node 2 = 1 iska next is 2
        node1Save.next = null;//break it
        ListNode newNode1Save = node1.next.next;
        node1.next.next = node1Save;
        node1Save.next = newNode1Save;
        
    }

}