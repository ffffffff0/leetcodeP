package simpleTest.stack;

import neetcode.stack.EvaluateReversePolishNotation;

public class TestEvaluateReversePolishNotation {
    public static void main(String[] args) {
//        输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
//        输出：22
        EvaluateReversePolishNotation evaluateReversePolishNotationInstance = new EvaluateReversePolishNotation();
        String[] useArray = new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int ret = evaluateReversePolishNotationInstance.evalRPN(useArray);
        System.out.println(ret);
    }
}
