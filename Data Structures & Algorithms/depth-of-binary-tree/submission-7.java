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
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root,1));

        int res = 0;

        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            TreeNode node = pair.node;
        
            if(node != null){
                res = Math.max(res, pair.depth);
                if(node.left != null){
                    stack.push(new Pair(node.left, pair.depth + 1));
                }
                if(node.right != null){
                    stack.push(new Pair(node.right, pair.depth + 1));
                }
            }
            
        }
        return res;
    }
}
record Pair(TreeNode node,Integer depth){}
