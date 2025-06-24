package neetcode.DP1;

import java.util.List;

/*
给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。


示例 1：

输入: s = "leetcode", wordDict = ["leet", "code"]
输出: true
解释: 返回 true 因为 "leetcode" 可以由 "leet" 和 "code" 拼接成。
示例 2：

输入: s = "applepenapple", wordDict = ["apple", "pen"]
输出: true
解释: 返回 true 因为 "applepenapple" 可以由 "apple" "pen" "apple" 拼接成。
     注意，你可以重复使用字典中的单词。
示例 3：

输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
输出: false
 */
public class WordBreak {
    /**
     *                      s = "leetcode", wordDict = ["leet", "neet", "code"]
     *  需要遍历 string, 然后遍历 wordDict 中的单词.
     *                                             [] i = 0
     *                          | i = 4             |                   | 判断 wordDict 中的单词 length
     *                        leet                neet                 code
     *             |           |         |
     *            leet       neet       code
     *                                   |
     *                                  i=8, 找到一个结果
     *
     * @param s 输入字符串
     * @param wordDict 匹配单词组
     * @return 是否可以匹配
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // dp
        boolean[] dp = new boolean[s.length() + 1];
        dp[dp.length - 1] = true;

        for (int i = s.length() - 1; i >= 0; i--) {
            for (String word : wordDict) {
                if ( i + word.length() <= s.length() && s.substring(i, i+word.length()).equals(word)) {
                    dp[i] = dp[i + word.length()];
                }

                if (dp[i]) {
                    break;
                }
            }
        }

        return dp[0];
    }
}
