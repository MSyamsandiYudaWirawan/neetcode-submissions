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
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        // carry for val/10
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            // v1 + v2
            int v1 = (l1!=null) ? l1.val : 0;
            int v2 = (l2!=null) ? l2.val : 0;
            int val = v1 + v2 + carry;
            // calculate val,carry
            carry = val/10;
            val = val%10;
            //new node for val
            ListNode node = new ListNode(val);
            cur.next = node;
            //shift
            cur = cur.next;
            l1 = (l1!=null) ? l1.next : null;
            l2 = (l2!=null) ? l2.next : null;
        }
        return dummy.next;
    }
}
