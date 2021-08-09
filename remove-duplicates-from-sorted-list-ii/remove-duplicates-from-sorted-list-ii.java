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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return head;
        if(head.next==null)return head;
        boolean found =false;
        ListNode mover =head.next;
        ListNode prev = head;
        ListNode nHead = new ListNode();
        ListNode dummy = nHead;
        while(mover!=null){
            
            if(mover.val==prev.val) {
                found=true;
            //means we have found a new value but we cannot include it yet
            } else{
                if(found){
                    prev=mover;
                    found=false;    
                }else{
                    System.out.println("nHead "+ nHead.val + " prev "+ prev.val);
                    nHead.next = prev;
                    nHead=nHead.next;
                    prev= mover;    
                }
            } 
            
            mover=mover.next;
            
        }
        if(!found)
            nHead.next=prev;
        else nHead.next=null;
        return dummy.next;
    }
}