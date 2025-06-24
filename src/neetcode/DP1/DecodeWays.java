package neetcode.DP1;

import java.util.Arrays;

/*
一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：

"AAJF" ，将消息分组为 (1 1 10 6)
"KJF" ，将消息分组为 (11 10 6)
注意，消息不能分组为  (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。

给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。

题目数据保证答案肯定是一个 32 位 的整数。


示例 1：

输入：s = "12"
输出：2
解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
示例 2：

输入：s = "226"
输出：3
解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
示例 3：

输入：s = "06"
输出：0
解释："06" 无法映射到 "F" ，因为存在前导零（"6" 和 "06" 并不等价）。

 */
public class DecodeWays {
    /**
     *                                         12131
     *                                          []
     *                       |                                  |
     *                       1                                 12
     *            |                |              |                          |
     *            2               21              1                          13
     *      |         |       |       |      |        |              |             |
     *      1        31       3      31     3        31              1
     * 遍历字符串，对于当前字符，可以判断 dp[i] in ['1'-'9'], 如果属于则可以单独decode
     * 如果 dp[i] == '1' or dp[i] == '2' and dp[i+1] in ['0'-'6'] 则可以单独两个字符来decode
     *
     * 可以从尾部开始来看, s = "12121", length = 5
     * 从尾部开始, dp[s.length()] = 1, 因为到尾部就算一种类型.
     * dp[5] = 1
     * dp[4] = dp[5] = 1, dp[i] = dp[i+1]
     * dp[3] = dp[4] = 1
     * dp[2] = dp[3] = 1
     * dp[1] = dp[2] = 1
     * dp[0] = dp[1] = 1
     * 如果满足两位数字的检测:
     *                     string: 1 2 1 2 1
     *                     index:  0 1 2 3 4 5
     * dp[3] += dp[5], dp[i] += dp[i+2]
     * dp[2] += dp[4]
     * dp[1] += dp[3]
     * dp[0] += dp[2]
     *
     * @param s 输入字符串
     * @return 返回所有decode的种类数量
     */
    public int numDecodings(String s) {
        // dfs
//        int[] dp = new int[s.length()];
//        Arrays.fill(dp, -1);
//
//        return dfs(s, dp, 0);
        // dp
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int index = s.length() - 1; index >=0 ; index--) {
            if (s.charAt(index) == '0') {
                dp[index] = 0;
            } else {
                dp[index] = dp[index + 1];
            }

            if (index + 1 < s.length() && (s.charAt(index) == '1' ||
                    (s.charAt(index) == '2' && s.charAt(index + 1) >= '0' && s.charAt(index + 1) <= '6'))) {
                dp[index] += dp[index + 2];
            }
        }

        System.out.println(Arrays.toString(dp));
        return dp[0];
    }

    public int dfs(String s, int[] dp, int index) {
        if (index == s.length()) {
            // 到达字符串尾部，说明找到了一种方法，应该返回1
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        int ret = dfs(s, dp, index + 1);

        if (index + 1 < s.length() && (s.charAt(index) == '1' ||
                (s.charAt(index) == '2' && s.charAt(index + 1) >= '0' && s.charAt(index + 1) <= '6'))) {
            ret += dfs(s, dp, index + 2);
        }

        dp[index] = ret;
        return ret;
    }
}
