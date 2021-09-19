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
    
    public boolean isPalindrome(ListNode head) {
        
        return check(head, new ListNode[]{head});
    }
    
    public boolean check(ListNode head, ListNode[]actualHead){
        if(head==null)return true;
        if(check(head.next, actualHead)){
            boolean ret = head.val == actualHead[0].val;
            actualHead[0]=actualHead[0].next;
            return ret;
        }
        return false;
        
    }
    ListNode compareHead;
    public boolean isPalindrome1(ListNode head) {
        //edge cases: 
        if(head==null || head.next==null)return true;
        
        int len=0;
        ListNode temp = head;
        while(temp!=null){
            len++; temp=temp.next;
        }
        //reach the middle or middle +1 if len is odd
        int mid = len/2 + (((len & 1)==0)?0:1);
        
        ListNode second = head;
        for(int i=0;i<mid; i++){
            second = second.next;
        }
        
        ListNode secondHead = reverse(second);
        
        //compare from first head and second head
        
         while(secondHead!=null){
             if(head.val != secondHead.val)return false;
             head=head.next;secondHead=secondHead.next;
         }
        
        return true;
    
    }
    public ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode next = null;
        
        while(head!=null){
            next = head.next;
            head.next=prev;
            prev = head;
            head=next;
        }
        return prev;
    }
}