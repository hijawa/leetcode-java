package com.java.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Implement the following operations of a stack using queues.
 * <p/>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 *
 * @author mti1301
 * @since 2015/7/7.
 */
public class ImplementStackusingQueues {
    private Queue<Integer> inQueue = new LinkedList<>();
    private Queue<Integer> outQueue = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        Queue<Integer> queue;
        if (inQueue.isEmpty() && outQueue.isEmpty()) {
            queue = inQueue;
        } else {
            queue = inQueue.isEmpty() ? outQueue : inQueue;
        }
        queue.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue<Integer> theOne = !inQueue.isEmpty() ? inQueue : outQueue;
        Queue<Integer> theAnother = inQueue.isEmpty() ? inQueue : outQueue;

        while (theOne.size() > 1) {
            theAnother.add(theOne.poll());
        }
        theOne.poll();
    }

    // Get the top element.
    public int top() {
        Queue<Integer> theOne = !inQueue.isEmpty() ? inQueue : outQueue;
        Queue<Integer> theAnother = inQueue.isEmpty() ? inQueue : outQueue;

        while (theOne.size() > 1) {
            theAnother.add(theOne.poll());
        }
        int ele = theOne.poll();
        theAnother.add(ele);
        return ele;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return inQueue.isEmpty() && outQueue.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackusingQueues stack = new ImplementStackusingQueues();
        stack.push(1);
        stack.push(2);

        while (!stack.empty()) {
            System.out.println(stack.top());
            stack.pop();
        }
        stack.push(3);
        stack.push(4);
        while (!stack.empty()) {
            System.out.println(stack.top());
            stack.pop();
        }
    }
}
