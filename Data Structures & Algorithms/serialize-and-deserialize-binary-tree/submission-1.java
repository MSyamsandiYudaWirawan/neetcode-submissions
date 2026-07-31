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
        serializeDFS(root,sb);
        sb.deleteCharAt(0);
        return sb.toString();
    }

    private void serializeDFS(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append(",").append("null");
            return;
        }
        sb.append(",").append(String.valueOf(root.val));
        serializeDFS(root.left, sb);
        serializeDFS(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return deserializeDFS(arr);
    }
    private TreeNode deserializeDFS(String[] arr){
        if (idx >= arr.length || arr[idx].equals("null")) {
            idx++;
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(arr[idx]));
        idx++;
        
        root.left = deserializeDFS(arr);
        root.right = deserializeDFS(arr);
        return root;
    }
}
