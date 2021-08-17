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
    ListNode compareHead;
    public boolean isPalindrome(ListNode head) {
        
        //edge cases: 
        if(head==null || head.next==null)return true;
        
        compareHead=head;
        
        return isPalindromeHelper(head);
    }
    
    public boolean isPalindromeHelper(ListNode head){
        if(head==null)return true;
        
        if (isPalindromeHelper(head.next)) {
            if(compareHead.val == head.val){
                compareHead=compareHead.next;
                return true;
            } else {
                return false;
            }
        }
        return false;
        
        
    }
}