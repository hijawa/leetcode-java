package com.java.leetcode.easy;

import java.util.Stack;

/**
 * @author haoqi.thq
 * @version $Id: ValidParentheses, v 0.1 2016/9/24 15:04 haoqi.thq Exp $
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            switch (ch) {
                case '(':
                    stack.push(ch);
                    break;
                case ')':
                    if (stack.isEmpty()) {
                        return false;
                    } else if (stack.pop() != '(') {
                        return false;
                    }
                    break;
                case '{':
                    stack.push(ch);
                    break;
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    } else if (stack.pop() != '{') {
                        return false;
                    }
                    break;
                case '[':
                    stack.push(ch);
                    break;
                case ']':
                    if (stack.isEmpty()) {
                        return false;
                    } else if (stack.pop() != '[') {
                        return false;
                    }
                    break;
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
