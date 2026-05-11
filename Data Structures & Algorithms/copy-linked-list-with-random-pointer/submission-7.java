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
        // ensure theres node before linking copy
        // Map original node -> copied node
        Map<Node, Node> map = new HashMap<>();

        // Handle null safely (so we can map next/random without extra checks)
        map.put(null, null);

        Node cur = head;

        while (cur != null) {
            // Create copy node if it doesn't exist yet
            if (!map.containsKey(cur)) {
                map.put(cur, new Node(0));
            }

            // Get the copy of current node and assign value
            Node copy = map.get(cur);
            copy.val = cur.val;

            // Ensure copy of next node exists
            if (!map.containsKey(cur.next)) {
                map.put(cur.next, new Node(0));
            }
            // Link next pointer
            copy.next = map.get(cur.next);

            // Ensure copy of random node exists
            if (!map.containsKey(cur.random)) {
                map.put(cur.random, new Node(0));
            }
            // Link random pointer
            copy.random = map.get(cur.random);

            // Move to next node
            cur = cur.next;
        }

        // Return copied head
        return map.get(head);
    }
}
