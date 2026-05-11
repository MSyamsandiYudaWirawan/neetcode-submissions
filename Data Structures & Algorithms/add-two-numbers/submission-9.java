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
        // use carry to get last carry sum
        // sum = l1 + l2 + carry
        // carry = sum / 10;
        // sum = sum % 10;
        ListNode res = new ListNode();
        ListNode curr = res;

        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int num1 = (l1 != null) ? l1.val:0;
            int num2 = (l2 != null) ? l2.val:0;

            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sum = sum % 10;

            ListNode node = new ListNode(sum);
            curr.next = node;

            //shift
            curr= curr.next;
            l1 = (l1 != null) ? l1.next:null;
            l2 = (l2 != null) ? l2.next:null;
        }
        return res.next;
    }
}
