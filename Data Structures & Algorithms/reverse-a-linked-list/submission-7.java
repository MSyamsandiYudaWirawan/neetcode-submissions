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
        ListNode left = null;
        ListNode right = head;
        while(right != null) {
            ListNode temp = right.next;
            //reverse pointer
            right.next = left;
            //geser left pointer
            left = right;
            //geser right pointer
            right = temp;
        }
        return left;
    }
}
