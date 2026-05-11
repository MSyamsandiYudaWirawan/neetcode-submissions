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
        //create carry whicis carry val/10 
        //after add v1 + v2 + carry make sure mod val before assigning it

        ListNode res = new ListNode();
        ListNode cur = res;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            //calculate v1,v2,carry,val
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            int val = v1 + v2 + carry;
            carry = val / 10;
            val = val % 10;

            ListNode node = new ListNode(val);
            cur.next = node;

            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
            cur = cur.next;
        }
        return res.next;
    }
}
