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
    List<Data> datas = new ArrayList<>();
    record Data(int row, int col, TreeNode root) {}
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null)
            return res;

        dfs(new Data(0, 0, root));

        datas.sort((a, b) -> a.col != b.col ? a.col - b.col : a.row - b.row);

        int prevCol = Integer.MIN_VALUE;
        for (Data data : datas) {
            if (prevCol != data.col) {
                res.add(new ArrayList<>());
                prevCol = data.col;
            }
            res.get(res.size() - 1).add(data.root.val);
        }
        return res;
    }
    private void dfs(Data data) {
        if (data.root == null) {
            return;
        }
        datas.add(data);
        dfs(new Data(data.row + 1, data.col - 1, data.root.left));
        dfs(new Data(data.row + 1, data.col + 1, data.root.right));
    }
}