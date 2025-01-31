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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        // We have to take l1 and l2: 
        ListNode head = new ListNode();
        ListNode head1  = new ListNode();
        head1 = head;
        while(l1!=null && l2!=null) {
            if(l1.val<l2.val){
                head.next = l1;    
                l1=l1.next;
            }else{
                head.next=l2;
                l2=l2.next;
            }
            head=head.next;
        }
        if(l2!=null) head.next=l2;
        if(l1!=null) head.next=l1;
        return head1.next;
    }
}