/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
       //finding the mid opiunt of the linkedlist
        if(head==null)return;
        ListNode slow = head;
        ListNode fast = head;
        //1-2-3-5
        //slow = 3and fast null
        //1-2
        // slow will be at 2
        ListNode prev=null;
        while(fast!=null && fast.next!=null) {  
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        if(prev!=null)
            prev.next=null;
        // print(head);
        
        //slow at start of the start if bew sorut,
        // reverse slow
        // print(slow);
        //this also means there is only 1 element in the list
        if(slow==head) return;//since both are equal you cannot do anytrhing
        
        slow = reverse(slow);
        // print(slow);
        merge(head, slow);
        
    }
    public void print(ListNode node) {
        while(node!=null){
            System.out.print(node.val + "->");
            node=node.next;
        }
        System.out.println("---");
    }
    public ListNode merge(ListNode node1, ListNode node2){
        
        if(node1==null||node2==null)return node1==null?node2:node1;
        ListNode result = new ListNode(1);
        ListNode head=result;
        while(node1 != null && node2!=null) {
            // print(result.next);
            head.next=node1;
            node1=node1.next; //so that head can have 2 
            head=head.next;
            
            head.next=node2;//you are overriding node1
            head=head.next;
            
            
            node2=node2.next;
            
        }
        if(node2!=null){
            head.next=node2;
        }
        return result.next;
        
    }
    public ListNode reverse(ListNode head) {
        
        ListNode prev =null;
        ListNode next = null;
        while(head!=null){
            next=head.next;
            head.next=prev;
            prev=head;
            head=next;
        }
        return prev;
            
    }
}