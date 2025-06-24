package neetcode.DP1;

/*
给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
回文字符串 是正着读和倒过来读一样的字符串。
子字符串 是字符串中的由连续字符组成的一个序列。
具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。

示例 1：

输入：s = "abc"
输出：3
解释：三个回文子串: "a", "b", "c"
示例 2：

输入：s = "aaa"
输出：6
解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 */
public class PalindromicSubstrings {
    /**
     *                            aaab
     * 回文字串，和 LongestPalindromicSubstring 相似，遍历每个字符，分为两种情况:
     *  1. 以本字符为中心点向外遍历，判断时候为回文字串
     *  2. 以本字符和下一个字符为中心点向外遍历，判断是否为回文字串
     * @param s 输入字符串
     * @return 返回回文字串数量
     */
    public int countSubstrings(String s) {
        int ret = 0;

        for (int left = 0; left < s.length(); left++) {
            // odd
            int right = left;

            ret += helper(s, left, right);

            // even
            right = left+1;
            ret += helper(s, left, right);
        }

        return ret;
    }

    public int helper(String s, int left, int right) {
        int ret = 0;
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ret++;
            left--;
            right++;
        }

        return ret;
    }
}
