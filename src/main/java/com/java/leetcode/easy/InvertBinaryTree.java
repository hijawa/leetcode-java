package com.java.leetcode.easy;

import java.util.LinkedList;

/**
 * nvert a binary tree.
 * <p/>
 * 4
 * /   \
 * 2     7
 * / \   / \
 * 1   3 6   9
 * to
 * 4
 * /   \
 * 7     2
 * / \   / \
 * 9   6 3   1
 *
 * @author mti1301
 * @since 2015/6/27.
 */
public class InvertBinaryTree {


    // 非递归解决方案
    public TreeNode invertTree_nonrecursively(TreeNode root) {
        if (root == null) return null;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.push(root);
        while (queue.size() > 0) {
            TreeNode node = queue.element();
            queue.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.push(node.left);
            }
            if (node.right != null) {
                queue.push(node.right);
            }
        }
        return root;
    }

    // 递归解决方案
    public TreeNode invertTree_recursively(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = invertTree_recursively(right);
        root.right = invertTree_recursively(left);
        return root;
    }
}
