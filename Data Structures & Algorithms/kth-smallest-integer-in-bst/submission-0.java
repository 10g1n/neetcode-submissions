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
    public int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        addNodeToMinHeap(root, minHeap);

        int kthSmallest = 0;

        for (int i = 0; i < k; i++) {
            kthSmallest = minHeap.poll();
        }

        return kthSmallest;
    }

    private static void addNodeToMinHeap(TreeNode root, PriorityQueue<Integer> minHeap) {
        if (root == null) {
            return;
        }

        minHeap.add(root.val);
        addNodeToMinHeap(root.left, minHeap);
        addNodeToMinHeap(root.right, minHeap);
    }
}
