package neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

示例 1：

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
示例 2：

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]

 */
public class LetterCombinationsOfaPhoneNumber {
    private final String[] KEYS = new String[] {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };
    private String useDigits;

    /**
     *
     *  对每个数字代表的字符进行逐个递归组合.
     *                                          23
     *                                          []
     *                          |               |               |
     *                          a               b               c
     *                 |       |      |  |      |      |  |     |     |
     *                 d       e      f  d      e      f  d     e     f
     * @param digits 输入数字
     * @return 返回可能字符组合
     */
    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<>();
        if (digits.isEmpty()) {
            return ret;
        }
        useDigits = digits;

        dfs(ret, new StringBuilder(), 0);

        return ret;
    }

    public void dfs(List<String> ret, StringBuilder cur, int index) {
        if (cur.length() == useDigits.length()) {
            ret.add(cur.toString());
        }
        if (index >= useDigits.length()) {
            return;
        }

        for (char item: KEYS[useDigits.charAt(index) - '0'].toCharArray()) {
            cur.append(item);
            dfs(ret, cur, index + 1);
            // 回溯
            cur.deleteCharAt(cur.length()-1);
        }
    }
}
