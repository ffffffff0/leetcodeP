package neetcode.oneDDynamicProgramming;

/*
给你一个字符串 s，找到 s 中最长的回文子串。
如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。

示例 1：

输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：

输入：s = "cbbd"
输出："bb"
 */
public class LongestPalindromicSubstring {
    /**
     * 可以遍历每个字符，分为两种情况:
     *                       bab 这种，以当前字符为中心点向左右传递
     *                       abba 这种，以两个字符为中心点向左右传递
     * 需要考虑以上两种情况。
     *
     * @param s 输入字符串
     * @return 返回结果
     */
    public String longestPalindrome(String s) {
        int maxLen = 0;
        String maxString = "";

        for (int i = 0; i < s.length(); i++) {
            // odd
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int tempLen = right - left + 1;
                if (tempLen > maxLen) {
                    maxString = s.substring(left, right + 1);
                    maxLen = tempLen;
                }

                left--;
                right++;
            }
            // even
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                int tempLen = right - left + 1;
                if (tempLen > maxLen) {
                    maxString = s.substring(left, right + 1);
                    maxLen = tempLen;
                }

                left--;
                right++;
            }
        }

        return maxString;
    }
}
