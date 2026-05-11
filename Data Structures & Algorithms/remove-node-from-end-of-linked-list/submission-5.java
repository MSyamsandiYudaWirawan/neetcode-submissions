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
    // Use two pointers with a gap of n nodes between them.
        // When right reaches the end, left will be at the node BEFORE the target.

        // Create dummy to handle edge case (removing head)
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // left starts at dummy, right starts at head
        ListNode left = dummy;
        ListNode right = head;

        // Move right n steps ahead (gap = n)
        while (n > 0) {
            right = right.next;
            n--;
        }

        // Move both pointers until right reaches null
        // left will stop at node BEFORE the one we want to delete
        while (right != null) {
            left = left.next;
            right = right.next;
        }

        // Delete the target node
        left.next = left.next.next;

        // Return new head (could be different if head was removed)
        return dummy.next;
    }
}
