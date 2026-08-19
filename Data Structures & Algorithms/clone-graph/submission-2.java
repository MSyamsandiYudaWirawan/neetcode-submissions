/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        // dfs(node);
        bfs(node);
        return map.get(node);
    }
    private void bfs(Node node) {
        if(node == null){
            return;
        }
        Queue<Node> q = new ArrayDeque();
        q.add(node);
        map.put(node, new Node(node.val));
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node nei : cur.neighbors) {
                if (!map.containsKey(nei)) {
                    map.put(nei, new Node(nei.val));
                    q.add(nei);
                }
                map.get(cur).neighbors.add(map.get(nei));
            }
        }
    }

    private void dfs(Node node) {
        if (map.containsKey(node) || node == null) {
            return;
        }
        Node copy = new Node(node.val);
        map.put(node, copy);

        for (Node nei : node.neighbors) {
            dfs(nei);
            copy.neighbors.add(map.get(nei));
        }
    }
}