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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //reate a dummy node to point to head.
        //find out the node left as left index and right as right index.
        //start reversing from left to right and let it return a reversed linked list.
        //just attach to next of waiting node.
        //anything in the right of right node should be unchanged since we will break the loop once we reach the right node.
        //we can also do it in 1 pass by startng tp reverse when reach left and end whenh total count becomes right
        ListNode temp  = head;
        ListNode prev = new ListNode();
        ListNode newHead = prev;
        prev.next=head;
        int pos = 1;
        while (temp!=null && pos<left) {
            prev=temp;
            temp = temp.next;
            pos++;
        }
        // if(temp==null) return newHead.next; //since the leement is probably not found or we cannot look for right
        // prev.next will be last element after reverse
        // Reverse from here but you have to link the prev of temp with the last of 
        // 
        ListNode tempLast = temp; //its next will be right's next;
        ///right will be in prev.next;
        ListNode p= null;
        ListNode n = null;
        while(temp!=null && pos<=right){
            n=temp.next;
            temp.next=p;
            p=temp;
            temp=n;
            pos++;
        }
        tempLast.next = n;
        prev.next= p;
        
        return newHead.next;
        
        
    }
}