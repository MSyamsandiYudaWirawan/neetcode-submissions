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

public class Codec {
    int idx = 0;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsSerialize(root,sb);
        sb.deleteCharAt(0);
        return sb.toString();
    }

    private void dfsSerialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(",").append("null");
            return;
        }
        sb.append(",").append(String.valueOf(root.val));
        dfsSerialize(root.left , sb);
        dfsSerialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0){
            return null;
        }
        String[] arr = data.split(",");
        return dfsDeserialize(arr);
        
    }
    private TreeNode dfsDeserialize(String[] arr){
        if(arr[idx].equals("null") || arr.length - 1 <= idx){
            idx++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(arr[idx]));
        idx++;
        root.left = dfsDeserialize(arr);
        root.right = dfsDeserialize(arr);

        return root;
    }
}
