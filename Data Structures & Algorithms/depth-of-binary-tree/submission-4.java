/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int res = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root,1));
        while(!queue.isEmpty()){
            Pair pair = queue.poll();
            TreeNode node = pair.node;
            res = Math.max(res,pair.depth);
            if(node.left != null){
                queue.add(new Pair(node.left, pair.depth + 1));
            }
            if(node.right != null){
                queue.add(new Pair(node.right, pair.depth + 1));
            }
        }
        return res;
    }
}
record Pair(TreeNode node, Integer depth){};
