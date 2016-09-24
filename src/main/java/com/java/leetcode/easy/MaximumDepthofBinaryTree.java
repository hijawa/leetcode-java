package com.java.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, find its maximum depth.
 * <p/>
 * The maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 *
 * @author mti1301
 * @since 2015/6/28.
 */
public class MaximumDepthofBinaryTree {

    // 递归解决方案
    public int maxDepth_recursively(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth_recursively(root.left), maxDepth_recursively(root.right)) + 1;
    }

    // 非递归解决方案
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList();
        TreeNode endOfLevel = null;
        queue.add(root);
        queue.add(endOfLevel);
        int depth = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node == endOfLevel) {
                if (queue.isEmpty()) {
                    break;
                }
                ++depth;
                queue.add(endOfLevel);
                continue;
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return depth;
    }
}
