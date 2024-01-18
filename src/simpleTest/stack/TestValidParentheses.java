package simpleTest.stack;

import neetcode.stack.ValidParentheses;

public class TestValidParentheses {
    public static void main(String[] args) {
//        输入：s = "()"
//        输出：true
        ValidParentheses validParenthesesInstance = new ValidParentheses();
        String testString = "()";
        boolean ret = validParenthesesInstance.isValid(testString);
        System.out.println(ret);
//        输入：s = "()[]{}"
//        输出：true
        testString = "()[]{}";
        ret = validParenthesesInstance.isValid(testString);
        System.out.println(ret);
//        输入：s = "(]"
//        输出：false
        testString = "(]";
        ret = validParenthesesInstance.isValid(testString);
        System.out.println(ret);
    }
}
