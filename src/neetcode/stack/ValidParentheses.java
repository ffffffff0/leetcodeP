package neetcode.stack;

import java.util.Stack;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。


示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：

输入：s = "(]"
输出：false
 */
public class ValidParentheses {
    /**
     *
     * @param s 输入字符串
     * @return 返回是否满足
     */
    public boolean isValid(String s ) {
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }

            char last = stack.peek();
            boolean isOne = c == ')' && last == '(';
            boolean isTwo = c == ']' && last == '[';
            boolean isThree = c == '}' && last == '{';

            if (isOne || isTwo || isThree) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();

    }
}
