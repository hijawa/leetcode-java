package com.java.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree, determine if it is height-balanced.
 * <p/>
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * @author mti1301
 * @since 2015/6/27.
 */
public class BalancedBinaryTree {

    public static void main(String[] args) {
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        Integer[] nums = {1, 2, 2, 3, null, null, 3, 4, null, null, 4};
        TreeNode root = balancedBinaryTree.buildTree(nums);
        System.out.println(balancedBinaryTree.getDepth(root));
//        System.out.println(balancedBinaryTree.isBalanced(root));
    }

    public TreeNode buildTree(Integer[] levelNums) {
        Queue<TreeNode> queue = new LinkedList();
        TreeNode root = new TreeNode(levelNums[0]);
        queue.add(root);
        for (int i = 1; i < levelNums.length; i += 2) {
            TreeNode rootNode = queue.remove();
            if(levelNums[i] == null){
                rootNode.left = null;
            }else {
                rootNode.left = new TreeNode(levelNums[i]);
                queue.add(rootNode.left);
            }
            if(levelNums[i+1] == null){
                rootNode.right = null;
            }else {
                rootNode.right = new TreeNode(levelNums[i + 1]);
                queue.add(rootNode.right);
            }
        }
        return root;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(getDepth(root.left) - getDepth(root.right)) > 1) {
            return false;
        }
        return true;
    }

    private int getDepth(TreeNode node) {
        if (node == null) return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode endOfLevel = node;
        int depth = 1;
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.remove();
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
            if (tmp == endOfLevel) {
                endOfLevel = (tmp.right == null) ? tmp.left : tmp.right;
                if (null != endOfLevel) {
                    ++depth;
                }
            }
        }
        return depth;
    }
}
