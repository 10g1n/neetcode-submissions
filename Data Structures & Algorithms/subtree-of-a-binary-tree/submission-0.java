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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }

        if (subRoot == null) {
            return true;
        }

        if (isSameTree(root, subRoot)) {
            return true;
        }

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean isSameTree(TreeNode root1, TreeNode root2) {
        List<Integer> nodesTree1 = new ArrayList<>();
        List<Integer> nodesTree2 = new ArrayList<>();

        preorder(root1, nodesTree1);
        preorder(root2, nodesTree2);

        return nodesTree1.equals(nodesTree2);
    }

    public void preorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            list.add(null);
        } else {
            list.add(node.val);
            preorder(node.left, list);
            preorder(node.right, list);
        }
    }
}
