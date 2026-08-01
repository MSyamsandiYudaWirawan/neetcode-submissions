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
    static final long MOD1 = 1_000_027L;
    static final long MOD2 = 1_000_031L;
    static final long BASE1 = (long) (Math.random()*10_000L);
    static final long BASE2 = (long) (Math.random()*10_000L);
    Map<TreeNode,Pair> map = new HashMap<>();

    private record Pair(long h1, long h2){}
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Pair targetHash = hash(subRoot);
        return check(root,targetHash);
    }
    private Pair hash(TreeNode root){
        if(root == null){
            return new Pair(7,11);
        }
        if(map.containsKey(root)){
            return map.get(root);
        }
        Pair left = hash(root.left);
        Pair right = hash(root.right);
        long h1 = (root.val + left.h1 * BASE1 + right.h1 * (BASE1/2)) % MOD1;
        long h2 = (root.val + left.h2 * BASE1 + right.h2 * (BASE1/2)) % MOD2;

        Pair pair = new Pair(h1,h2);
        return pair;

    }
    private boolean check(TreeNode root, Pair targetHash){
        if(root == null){
            return false;
        }
        Pair rootHash = hash(root);

        if(rootHash.h1 == targetHash.h1 && rootHash.h2 == targetHash.h2){
           return true; 
        }
        
        return check(root.left,targetHash) || check(root.right,targetHash);
    }
}
