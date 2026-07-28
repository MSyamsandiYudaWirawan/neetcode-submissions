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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null){
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            List<Integer> total = new ArrayList<>();

            for(int i=q.size(); i>0; i--){
                TreeNode cur = q.poll();
                if(cur != null){
                    total.add(cur.val);
                    q.add(cur.left);
                    q.add(cur.right);
                }
            }
            
            if(total.size() > 0){
                // get last element / most right;
                res.add(total.get(total.size() - 1));
            }
        }
        return res;
    }
}
