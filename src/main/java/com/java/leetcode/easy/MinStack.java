package com.java.leetcode.easy;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Design a stack that supports push, pop, top,
 * and retrieving the minimum element in constant time.
 * <p/>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * @author googny
 * @since 2015/6/24.
 */
public class MinStack {
    int myMin = Integer.MAX_VALUE;
    private Stack<Integer> stackBad = new Stack<>();
    private PriorityQueue queueBad = new PriorityQueue();
    private long min = Integer.MAX_VALUE;
    private LinkedList<Long> stack = new LinkedList<>();
    private LinkedList<Element> myStack = new LinkedList<>();

    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.myPush(-2);
        stack.myPush(0);
        stack.myPush(-1);

        System.out.println(stack.myGetMin());
        stack.myPop();
        System.out.println(stack.myGetMin());
        stack.myPop();
        System.out.println(stack.myGetMin());
    }

    // ==================================
    // 使用一个数据结构将值和当前最小值都存储起来，比较好
    public void myPush(int x) {
        Element ele = new Element();
        ele.min = Math.min(x, myStack.isEmpty() ? Integer.MAX_VALUE : myStack.peek().min);
        ele.value = x;
        myStack.push(ele);
    }

    public void myPop() {
        if (myStack.isEmpty()) return;
        myStack.pop();
    }

    public int myTop() {
        if (myStack.isEmpty()) return 0;
        return myStack.peek().value;
    }

    public int myGetMin() {
        return myStack.peek().min;
    }


    // ===================================
    // 此方法最好，技术含量最高
    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            stack.push(x - min);//Could be negative if min value needs to change
            if (x < min) min = x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop = stack.pop();

        if (pop < 0) min = min - pop;//If negative, increase the min value

    }

    public int top() {
        long top = stack.peek();
        if (top > 0) {
            return (int) (top + min);
        } else {
            return (int) (min);
        }
    }

    public int getMin() {
        return (int) min;
    }


    //=================================================
    //在类中保存两个数据结构，最差
    public void pushBad(int x) {
        queueBad.add(x);
        stackBad.push(x);
    }

    public void popBad() {
        if (stackBad.isEmpty()) {
            return;
        }
        int ele = stackBad.pop();
        queueBad.remove(ele);
    }

    public int topBad() {
        if (stackBad.isEmpty()) {
            return 0;
        }
        return stackBad.peek();
    }

    public int getMinBad() {
        return (int) queueBad.peek();
    }

    private class Element {
        int min;
        int value;
    }
}
