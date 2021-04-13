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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //EITHER TRAVERSE reverse the linked list add numbers while traversing
        //reverse the linkedlists again.
        
        
        // recurve and add the right first. function returns the carry over if any
        //main egt the resonse with a head since our recursive funciton ponly returns a carryt we call it with a dummy head.
        
        //number is reverse so answer will also be reverse, MSB to the right.
        
        int carry =0;
        ListNode ll = new ListNode(0);
        ListNode result =ll;
        while(l1!=null || l2 !=null){
            int val1=0, val2=0;
            if(l1!=null) {
                val1=l1.val; l1=l1.next;
            }
            if(l2!=null) {
                val2=l2.val;
                l2=l2.next;
            }
            
            ListNode l = new ListNode(0);
            l.val= carry+val1+val2;
            carry = l.val/10;
            l.val = l.val%10;
            ll.next=l;
            ll=l;
            
        }
        if(carry>0){
            ListNode l = new ListNode(carry);
            ll.next=l;
        }
        return result.next;
        
//         ListNode dummy = new ListNode(0);
//         ListNode sum = recurse(l1, l2, dummy);
//         if(sum!=null && sum.val>10){
//             ListNode result  = new ListNode(0);
//             result.val = sum.val/10;
//             sum.val=sum.val%10;
//             result.next=sum;
            
//             return result;
//         }else{
//             return sum;
//         }
    }
    public ListNode recurse(ListNode l1, ListNode l2, ListNode dummy){
        int val1=0,val2=0;
        
        if(l1==null && l2==null) return null;
        if(l2!=null) val2=l2.val;
        if(l1!=null) val1=l1.val;
        
        int carry=0;
        ListNode sumRight = recurse(l1.next, l2.next,null);
        System.out.println("Summing "+ val1+ " "+val2);
        if(sumRight!=null){
            carry=sumRight.val/10;
            sumRight.val=sumRight.val%10;
        }
        ListNode head = new ListNode(carry+ val1+val2);
        head.next=sumRight;
        return head;
    }
}