package com.java.leetcode.easy;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 * <p/>
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * return its bottom-up level order traversal as:
 * [
 * [15,7],
 * [9,20],
 * [3]
 * ]
 *
 * @author mti1301
 * @since 2015/6/28.
 */
public class BinaryTreeLevelOrderTraversalII {

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversalII tree = new BinaryTreeLevelOrderTraversalII();
        Integer[] nums = {1, 2, null, null, 3, 4, 5};
        TreeNode root = tree.buildTree(nums);
        System.out.println(tree.levelOrderBottom(root));
    }

    public TreeNode buildTree(Integer[] levelNums) {
        Queue<TreeNode> queue = new LinkedList();
        TreeNode root = new TreeNode(levelNums[0]);
        queue.add(root);
        for (int i = 1; i < levelNums.length; i += 2) {
            TreeNode rootNode = queue.remove();
            if (levelNums[i] == null) {
                rootNode.left = null;
            } else {
                rootNode.left = new TreeNode(levelNums[i]);
                queue.add(rootNode.left);
            }
            if (levelNums[i + 1] == null) {
                rootNode.right = null;
            } else {
                rootNode.right = new TreeNode(levelNums[i + 1]);
                queue.add(rootNode.right);
            }
        }
        return root;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();
        LinkedList<List<Integer>> result = new LinkedList();
        Queue<TreeNode> queue = new LinkedList();
        TreeNode endOfLevel = null;
        queue.add(root);
        queue.add(endOfLevel);
        List<Integer> ele = new LinkedList();
        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if (node != endOfLevel) {
                ele.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                result.push(ele);
                if (queue.isEmpty()) {
                    //如果队列中不存在有意义的值的话，则跳出循环
                    break;
                }
                queue.add(endOfLevel);
                ele = new LinkedList<>();
            }
        }
        return result;
    }
}
