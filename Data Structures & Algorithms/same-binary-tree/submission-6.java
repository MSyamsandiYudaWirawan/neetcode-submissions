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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }

        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(p,q));

        while(!stack.isEmpty()){
            Pair pair = stack.pop();
            TreeNode nodeP = pair.p;
            TreeNode nodeQ = pair.q;

            if(nodeP == null && nodeQ == null){
                continue;
            }
            if(nodeP == null || nodeQ == null || nodeP.val != nodeQ.val){
                return false;
            }

            stack.push(new Pair(nodeP.left, nodeQ.left));
            stack.push(new Pair(nodeP.right, nodeQ.right));
        }
        return true;
    }
}
record Pair(TreeNode p, TreeNode q){}
