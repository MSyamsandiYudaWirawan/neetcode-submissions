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
        //find the nth with 2 pointer node and with offset n + 1 (+1 for ode landing before the nth for easy remove)
        // create dummy for handle case remove the head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //offset 1
        ListNode left = dummy;
        ListNode right = head;
        //right offset n + 1
        while(n>0){
            right = right.next;
            n--;
        }
        //shift bot 2 pointer until right is null to get left in nth -1
        while(right != null){
            left = left.next;
            right = right.next;
        }
        //remove the nth node
        left.next = left.next.next;
        //return head from dummy node
        return dummy.next;
    }
}
