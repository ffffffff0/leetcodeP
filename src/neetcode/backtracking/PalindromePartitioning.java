package neetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/*
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

回文串 是正着读和反着读都一样的字符串。

示例 1：

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 2：

输入：s = "a"
输出：[["a"]]

 */
public class PalindromePartitioning {
    private char[] useSArray;
    private String useString;
    /**
     * 对于 aab 字符串，从开始索引来时逐个递归求解, 然后对剩余的字符串进行遍历求解。
     *                                aab
     *                   |            |            |
     *                  a*            aa*            aab
     *                  |            |                      遍历剩余字符，判断是否为回文字符串
     *             a*       ab        b*
     *             |
     *             b*
     *  => a, a, aa, b
     * @param s 输入字符串
     * @return 返回回文子串
     */
    public List<List<String>> partition(String s) {
        List<List<String>> ret = new ArrayList<>();
        useSArray = s.toCharArray();
        useString = s;

        dfs(ret, new ArrayList<>(), 0);
        return ret;
    }

    public boolean isPalindrome(int i, int j) {
        while (i < j) {
            if (useSArray[i] != useSArray[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public void dfs(List<List<String>> ret, List<String> part, int index) {
        if (index >= useSArray.length) {
            ret.add(new ArrayList<>(part));
            return;
        }

        for (int i = index; i < useSArray.length; i++) {
            if (isPalindrome(index, i)) {
                part.add(useString.substring(index, i + 1));

                dfs(ret, part, i+1);

                part.remove(part.size() - 1);
            }
        }
    }
}
