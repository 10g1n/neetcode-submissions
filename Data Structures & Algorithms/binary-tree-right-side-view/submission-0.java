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
        if (root == null) {
            return new ArrayList<>();
        }

        if (root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();

        List<List<Integer>> levelOrder = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            levelOrder.add(new ArrayList<>());

            for (int i = 0; i < len; i++) {
                TreeNode node = queue.poll();
                levelOrder.get(level).add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }

        for (List<Integer> list : levelOrder) {
            result.add(list.getLast());
        }

        return result;
    }
}
