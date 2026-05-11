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
        // use 2 poniter with offset n
        // shift bot pointer until right is null
        // remove node pointed by left
        // profit
        ListNode res = new ListNode();
        res.next = head;
        // tips use offset n+1 so it make easy to remove 
        ListNode left = res;
        ListNode right = head;

        //shift right pointer to n
        while(n>0){
            right = right.next;
            n--;
        }

        //shift bot pointer
        while(right != null){
            left = left.next;
            right = right.next;
        }

        //remove the node
        left.next = left.next.next;
        return res.next;

    }
}
