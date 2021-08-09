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
        if(head == null)return head;
        ListNode mover = head;
        ListNode u = head;
        
        while(mover!=null) {
            
            if(u.val!=mover.val) {
                u.next=mover;
                u=u.next;
                
            }
            mover=mover.next;
        }
        u.next=mover;
        
        return head;
    }
}