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
    int preo_index = 0;
    Map<Integer,Integer> map_ino = new HashMap<>();


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0; i<inorder.length; i++){
            map_ino.put(inorder[i],i);
        }

        return dfs(preorder,0,preorder.length - 1);

    }
    private TreeNode dfs(int[] preorder, int l, int r){
        if(l>r){
            return null;
        }
        int root_val = preorder[preo_index];
        TreeNode root = new TreeNode(root_val);
        int mid = map_ino.get(root_val);
        preo_index++;

        root.left = dfs(preorder,l,mid-1);
        root.right = dfs(preorder,mid+1,r);

        return root;
    }
}
