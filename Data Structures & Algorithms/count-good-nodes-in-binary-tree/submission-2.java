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
    int count = 0;
    public int goodNodes(TreeNode root) {
        int maximum = root.val;

        return visit(root, maximum);
    }

    public int visit(TreeNode node, int maximum) {
        if (node == null) {
            return 0;
        }

        if (node.val >= maximum) {
            count++;
        }

        maximum = Math.max(node.val, maximum);

        visit(node.left, maximum);
        visit(node.right, maximum);

        return count;
    } 
}

