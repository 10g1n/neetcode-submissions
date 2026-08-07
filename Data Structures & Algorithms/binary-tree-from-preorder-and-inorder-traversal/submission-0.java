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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 && inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        int index = 0;

        while (index < inorder.length && inorder[index] != root.val) {
            index++;
        }

        int[] leftPre = Arrays.copyOfRange(preorder, 1, index + 1);
        int[] rightPre = Arrays.copyOfRange(preorder, index + 1, preorder.length);

        int[] leftIn = Arrays.copyOfRange(inorder, 0, index);
        int[] rightIn = Arrays.copyOfRange(inorder, index + 1, inorder.length);

        root.left = buildTree(leftPre, leftIn);
        root.right = buildTree(rightPre, rightIn);

        return root;


    }
}
