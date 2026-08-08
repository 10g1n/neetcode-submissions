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
    private StringBuilder sb = new StringBuilder();
    private int index;

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb.setLength(0);

        serializeHelper(root);

        return sb.toString();
    }

    public void serializeHelper(TreeNode root) {
        if (root == null) {
            sb.append("null").append(",");
            return;
        }

        sb.append(root.val).append(",");

        serializeHelper(root.left);
        serializeHelper(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        index = 0;

        String[] cleanedData = data.split(",");

        return deserializeHelper(cleanedData);
    }

    private TreeNode deserializeHelper(String[] cleanedData) {
        if (cleanedData[index].equals("null")) {
            index++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(cleanedData[index]));
        index++;

        node.left = deserializeHelper(cleanedData);
        node.right = deserializeHelper(cleanedData);

        return node;
    }
}
