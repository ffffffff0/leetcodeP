package neetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例 1：

输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
示例 2：

输入：n = 1
输出：["()"]
 */
public class GenerateParentheses {
    /**
     * 遍历可以得到结果:
     *                                                         n = 3
     *                                                         [(]
     *                          |                                                            |
     *                        [((]                                                          [()]
     *             |                       |                                           |
     *           [(((]                   [(()]                                       [()(]
     *            |                        |
     *          [((()))]                ....
     *  可以看出两种规则:
     *    1. ( 数量小于 n , ( == ) == n 时候完成遍历
     *    2. ) < ( 的数量时才可以插入 )
     *
     * @param n 括号的对数
     * @return 返回所有有效的组合数
     */
    private static int useN;
    private Stack<Character> useStack;
    private List<String> useRet;
    public List<String> generateParenthesis(int n) {
        useStack = new Stack<>();
        useRet = new ArrayList<>();
        useN = n;

        dfs(0, 0);
        return useRet;
    }

    public void dfs(int openN, int closeN) {
        if (openN == useN && closeN == useN) {
            // 得到一个结果
            StringBuilder sb = new StringBuilder();
            for (Character c : useStack) {
                sb.append(c);
            }
            useRet.add(sb.toString());
            return;
        }

        if (openN < useN) {
            useStack.push('(');
            dfs(openN + 1, closeN);
            useStack.pop();
        }

        if (closeN < openN) {
            useStack.push(')');
            dfs(openN, closeN + 1);
            useStack.pop();
        }
    }
}
