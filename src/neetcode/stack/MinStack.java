package neetcode.stack;

import java.util.Stack;

/*
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
实现 MinStack 类:

MinStack() 初始化堆栈对象。
void push(int val) 将元素val推入堆栈。
void pop() 删除堆栈顶部的元素。
int top() 获取堆栈顶部的元素。
int getMin() 获取堆栈中的最小元素。


示例 1:

输入：
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

输出：
[null,null,null,null,-3,null,0,-2]

解释：
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.getMin();   --> 返回 -2.
 */
public class MinStack {
    /**
     * 实现最小栈，关键是维护一个栈中每个位置都对应当前位置的最小值
     * stack option:         Min stack:
     *           -2                    -3
     *           0                     -3
     *           -3                    -3
     */
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        this.stack = new Stack<>();
        this.minStack  = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(minStack.peek(), val));
        }
    }

    public void pop() {
        minStack.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
