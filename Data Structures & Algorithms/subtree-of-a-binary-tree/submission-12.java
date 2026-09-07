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
    Map<TreeNode, Pair> map = new HashMap<>();
    long BASE1 = (long) (Math.random() * 10_000L) + 31L;
    long BASE2 = (long) (Math.random() * 10_000L) + 37L;
    long MOD = 1_000_007L;
    boolean res = false;

    private record Pair(long h1, long h2) {}
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Pair subHash = hash(subRoot);

        isSub(root, subHash);
        return res;
    }

    private void isSub(TreeNode root, Pair subHash) {
        if (root == null || res == true) {
            return;
        }

        isSub(root.left, subHash);
        isSub(root.right, subHash);

        Pair rootHash = hash(root);
        if (rootHash.h1 == subHash.h1 && rootHash.h2 == subHash.h2) {
            res = true;
            return;
        }
    }
    private Pair hash(TreeNode root) {
        if (root == null) {
            return new Pair(7, 11);
        }
        Pair left = hash(root.left);
        Pair right = hash(root.right);

        long h1 = (root.val + (left.h1 * BASE1) + (right.h1 * BASE1 % MOD)) % MOD;
        long h2 = (root.val + (left.h2 * BASE2) + (right.h2 * BASE2 % MOD)) % MOD;

        Pair cur = new Pair(h1, h2);
        map.put(root, cur);

        return cur;
    }
}
