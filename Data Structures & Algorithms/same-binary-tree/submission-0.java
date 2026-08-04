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
        List<Integer> nodesTree1 = new ArrayList<>();
        List<Integer> nodesTree2 = new ArrayList<>();

        preorderTraversal(p, nodesTree1);
        preorderTraversal(q, nodesTree2);
        
        return nodesTree1.equals(nodesTree2);
    }


    private void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            list.add(null);
        } else {
            list.add(root.val);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}
