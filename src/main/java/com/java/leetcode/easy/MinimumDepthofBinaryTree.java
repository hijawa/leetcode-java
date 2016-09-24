package com.java.leetcode.easy;

import java.util.LinkedList;

/**
 * Given a binary tree, find its minimum depth.
 * <p/>
 * The minimum depth is the number of nodes along the shortest path
 * from the root node down to the nearest leaf node.
 *
 * @author mti1301
 * @since 2015/6/27.
 */
public class MinimumDepthofBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        System.out.println(new MinimumDepthofBinaryTree().minDepth_recursively(root));
    }

    // DFS
    public int minDepth_nonrecusively(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        int depth = 1;
        // The end Of Level
        TreeNode endOfLevel = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node.left == null && node.right == null) return depth;
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
            if (node.equals(endOfLevel)) {
                endOfLevel = (node.right == null) ? node.left : node.right;
                ++depth;
            }
        }
        return depth;
    }

    public int minDepth_recursively(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        int depth = 1;
        int leftDepth = Integer.MAX_VALUE;
        int rightDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            leftDepth = minDepth_recursively(root.left);
        }
        if (root.right != null) {
            rightDepth = minDepth_recursively(root.right);
        }
        depth += Math.min(leftDepth, rightDepth);
        return depth;
    }
}
