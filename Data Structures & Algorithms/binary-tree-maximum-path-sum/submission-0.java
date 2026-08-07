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
    int maxSum;
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        maxSum = Integer.MIN_VALUE;

        postorderDFS(root);

        return maxSum;
    }

    public int postorderDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftContribution = Math.max(postorderDFS(root.left), 0);
        int rightContribution = Math.max(postorderDFS(root.right), 0);

        maxSum = Math.max(maxSum, leftContribution + rightContribution + root.val);

        return root.val + Math.max(leftContribution, rightContribution);
    }
}
