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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)return null;
        if(head.next == null )return null;
        ListNode node = head;
        int total=0;
        while(node!=null){
            node=node.next;
            total++;
        }
        ListNode prev = new ListNode();
        ListNode nHead = prev;
        prev.next = head;
        int find = total - n;
        while(find>0){
            prev=prev.next;
            find--;
        }
        prev.next=prev.next.next;
        return nHead.next;
    } 
}