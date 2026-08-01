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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }

        TreeNode node = root;

        while(node != null){
            if(node.val < p.val && node.val < q.val){
                node = node.right;
            }
            else if(node.val > q.val && node.val > p.val){
                node = node.left;
            }
            else{
                return node;
            }
        }
        return null;
    }
}
