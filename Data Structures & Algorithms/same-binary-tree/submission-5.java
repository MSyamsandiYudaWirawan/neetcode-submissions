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
        if( p == null && q == null){
            return true;
        }

        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        queueP.add(p);
        queueQ.add(q);

        while(!queueP.isEmpty() && !queueQ.isEmpty()){
            TreeNode nodeP = queueP.poll();
            TreeNode nodeQ = queueQ.poll();

            if(nodeP == null && nodeQ == null) {
                continue;
            }
            if(nodeP == null || nodeQ == null || nodeP.val != nodeQ.val){
                return false;
            }
            queueP.add(nodeP.left);
            queueP.add(nodeP.right);
            queueQ.add(nodeQ.left);
            queueQ.add(nodeQ.right);
            
        }
        return true;
    }
}
