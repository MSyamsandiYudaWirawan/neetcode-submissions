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
        // use hash map to map old and copy node
        // make sure there is node before accessing it

        Map<Node,Node> map = new HashMap<>();
        //tips map null to null to remove null validation
        map.put(null,null);

        Node curr = head;
        while(curr != null){
            if(!map.containsKey(curr)){
                map.put(curr,new Node(0));
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
            
            //shift
            curr = curr.next;
        }
        return map.get(head);
    }
}
