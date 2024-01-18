package simpleTest.stack;

import neetcode.stack.MinStack;

public class TestMinStack {
    public static void main(String[] args) {
//        输入：
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//        输出：
//[null,null,null,null,-3,null,0,-2]
        MinStack minStackInstance = new MinStack();
        minStackInstance.push(-2);
        minStackInstance.push(0);
        minStackInstance.push(-3);
        System.out.println(minStackInstance.getMin());
        minStackInstance.pop();
        System.out.println(minStackInstance.top());
        System.out.println(minStackInstance.getMin());
    }
}
