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
    int res = 0;
    public int goodNodes(TreeNode root) {
        dfs(root,root.val);
        return this.res;
    }
    private void dfs(TreeNode root, int maxCurr){
        if(root == null){
            return;
        }
        
        if(root.val >= maxCurr){
            this.res += 1;
            maxCurr = root.val;
        }
        dfs(root.left, maxCurr);
        dfs(root.right, maxCurr);
    }
}
