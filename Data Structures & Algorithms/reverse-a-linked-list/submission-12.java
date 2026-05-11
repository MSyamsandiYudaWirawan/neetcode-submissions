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
    public ListNode reverseList(ListNode head) {
        ListNode right = head;
        ListNode left = null;
        while(right != null){
            ListNode temp = right.next;
            right.next = left;
            left = right;
            right = temp;
        }
        return left;
        
    }
}
