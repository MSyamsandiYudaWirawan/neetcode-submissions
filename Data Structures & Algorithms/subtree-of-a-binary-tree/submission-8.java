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
    Map<TreeNode, PairHash> map  = new HashMap<>();
    static final long BASE1 = (long)(Math.random()*10_000L);
    static final long BASE2 = (long)(Math.random()*10_000L);
    static final long MOD1 = 1_000_027L;
    static final long MOD2 = 1_000_031L;

    private record PairHash(long h1, long h2){}

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        PairHash targetHash = getHash(subRoot);

        return check(root,targetHash);
    }

    private PairHash getHash(TreeNode node){
        if(node == null){
            return new PairHash(7,11);
        }
        if(map.containsKey(node)){
            return map.get(node);
        }

        PairHash left = getHash(node.left);
        PairHash right = getHash(node.right);

        long h1 = (node.val + left.h1 * BASE1 + right.h1 * BASE1 % MOD1 * BASE1) % MOD1;
        long h2 = (node.val + left.h2 * BASE2 + right.h2 * BASE2 % MOD2 * BASE2) % MOD2;

        PairHash pair = new PairHash(h1,h2);
        map.put(node,pair);

        return pair;
    }

    private boolean check(TreeNode node, PairHash targetHash){
        if(node == null) return false;
        
        PairHash nodeHash = getHash(node);

        if(nodeHash.h1 == targetHash.h1 && nodeHash.h2 == targetHash.h2){
            return true;
        }

        return check(node.left, targetHash) || check(node.right, targetHash);
    }

}
