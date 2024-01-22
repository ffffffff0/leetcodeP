package simpleTest.stack;

import neetcode.stack.GenerateParentheses;

import java.util.List;

public class TestGenerateParentheses {
    public static void main(String[] args) {
//    输入：n = 3
//    输出：["((()))","(()())","(())()","()(())","()()()"]
        GenerateParentheses generateParenthesesInstance = new GenerateParentheses();
        int testN = 3;
        List<String> ret = generateParenthesesInstance.generateParenthesis(testN);
        System.out.println(ret);
    }
}
