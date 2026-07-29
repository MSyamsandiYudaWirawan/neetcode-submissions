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
    Map<Pair,Boolean> map= new HashMap<>();

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null & subRoot == null){
            return true;
        }
        if(root == null){
            return false;
        }
        
        if(subRoot == null){
            return true;
        }

        if(dfs(root,subRoot)){
            return true;
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }
    private boolean dfs(TreeNode p, TreeNode q){
        if(map.containsKey(new Pair(p,q))){
            return map.get(new Pair(p,q));
        }
        if( p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        if(p.val != q.val){
            return false;
        }
        boolean res = dfs(p.left, q.left) && dfs(p.right, q.right);
        map.put(new Pair(p,q),res);

        return res;
    }
    private record Pair(TreeNode p, TreeNode q){}
}

