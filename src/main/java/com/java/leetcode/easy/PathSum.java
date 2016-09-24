package com.java.leetcode.easy;

import java.util.LinkedList;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 * <p/>
 * For example:
 * Given the below binary tree and sum = 22,
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 *
 * @author mti1301
 * @since 2015/6/26.
 */
public class PathSum {


    // 递归实现1
    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        int ele = root.val;
        sum = sum - ele;
        if (root.left == null && root.right == null && sum == 0) {
            return true;
        }
        if (root.left != null && hasPathSum1(root.left, sum)) {
            return true;
        }
        if (root.right != null && hasPathSum1(root.right, sum)) {
            return true;
        }
        return false;
    }


    // 使用栈进行迭代调用
    public boolean hasPathSum2(TreeNode root, int sum) {
        if(root == null) return false;
        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while(stack.size() > 0){
            TreeNode node = stack.peek();
            stack.pop();
            if(node.left == null && node.right == null){
                if(node.val == sum){
                    return true;
                }
            }
            if(node.right != null){
                node.right.val = node.right.val + node.val;
                stack.push(node.right);
            }
            if(node.left != null){
                node.left.val = node.left.val+node.val;
                stack.push(node.left);
            }
        }
        return false;
    }

    // 使用递归方法2
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null){
            if(root.val == sum){
                return true;
            }
        }
        if(root.left != null){
            root.left.val +=root.val;
            if(hasPathSum(root.left,sum)){
                return true;
            }
        }
        if(root.right != null){
            root.right.val +=root.val;
            if(hasPathSum(root.right,sum)){
                return true;
            }
        }
        return false;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

