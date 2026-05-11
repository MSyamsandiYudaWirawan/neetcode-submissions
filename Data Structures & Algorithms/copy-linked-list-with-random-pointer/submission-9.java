/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        map.put(null,null);
        // use hashmap to map old to new ListNode
        // before use new ListNode make sure its exist

        Node curr = head;
        while(curr != null){
            if(!map.containsKey(curr)){
                map.put(curr, new Node(0));
            }
            Node copy = map.get(curr);
            copy.val = curr.val;

            if(!map.containsKey(curr.next)){
                map.put(curr.next,new Node(0));
            }
            copy.next = map.get(curr.next);

            if(!map.containsKey(curr.random)){
                map.put(curr.random,new Node(0));
            }
            copy.random = map.get(curr.random);
            curr = curr.next;
        }
        return map.get(head);
    }
}
