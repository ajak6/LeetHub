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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        // 1-2-3-4-5
        int i=0;
        for (; curr!=null && i < k;i++) {
            curr=curr.next;
        }
    
        //it is possible that we don't have enough elements to reverse when the curr is null
        // Now curr should be at the node which should be reverse
        if(curr!=null){
            curr = reverseKGroup(curr,k);
        }
        //reverse the current group 
        //we need tio know the current group is of size k or not
        if(i!=k) return head; // we don't have k nodes to reverse
            i=0;
            ListNode prev = null;
            ListNode next = null;
         //curr should be attached to the end of reversed list so just attach it in the loop
            while(i<k && head!=null){
                i++;
                next = head.next;
                head.next=curr;
                curr=head;
                head=next;
            }  
            head=curr; // curr will the be the head of reversed list.
           
        
        return head;
    }
}