package neetcode.DP1;

import java.util.*;

/*
给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

你可以认为每种硬币的数量是无限的。

示例 1：

输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1
示例 2：

输入：coins = [2], amount = 3
输出：-1
示例 3：

输入：coins = [1], amount = 0
输出：0
 */
public class CoinChange {
    /**
     * 有两种方式:
     *  1. dfs
     *        暴力遍历，添加cache 记录已计算的子问题.
     *                                         [1, 2, 5], amount = 11
     *                                         11
     *              | 1                        | 2                             | 5
     *              10                         9                               6
     *    |1       | 2       | 5   | 1        | 2        |5       | 1         | 2         | 5
     *    9        8         5     8          7          4        5           4           1
     *  .......
     *  2. dp
     *  dp[0] = 0
     *  dp[1] = 1 + dp[0]
     *  dp[2] = Math.min(dp[2], 1 + dp[1]), Math.min(dp[2], 1(use 2))
     *  dp[3] = Math.min(dp[3], 1 +dp[2]), Math.min(dp[3], 1 + dp[1])
     *
     * @param coins 输入coins
     * @param amount 总数量
     * @return 返回最少的硬币数量
     */
    public int coinChange(int[] coins, int amount) {
        // dfs
        // int[] memo = new int[amount + 1];
        // return dfs(coins, memo, amount);
        // dp
        if (amount == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 1;

        for (int number = 1; number < amount + 1; number++) {
            for (int coin : coins) {
                if (number - coin >= 0) {
                    dp[number] = Math.min(dp[number], 1 + dp[number - coin]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public int dfs(int[] coins, int[] memo, int amount) {
        if (amount < 0) {
            return -1;
        }
        if (amount == 0) {
            return 0;
        }

        if (memo[amount] != 0) {
            return memo[amount];
        }

        int ret = Integer.MAX_VALUE;
        for (int coin : coins) {
            int dfsRet  = dfs(coins, memo, amount - coin);
            if (dfsRet < 0) {
                continue;
            }
            ret = Math.min(ret, dfsRet + 1);
        }

        memo[amount] = ret == Integer.MAX_VALUE ? -1 : ret;
        return memo[amount];
    }
}
