package neetcode.oneDDynamicProgramming;

import java.util.Arrays;

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
     *
     * @param coins 输入coins
     * @param amount 总数量
     * @return 返回最少的硬币数量
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        // dfs
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);

        dfs(coins, memo, amount);
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];
        // dp
    }

    public int dfs(int[] coins, int[] memo, int amount) {
        if (amount < 0) {
            return Integer.MAX_VALUE;
        }
        if (amount == 0) {
            return 0;
        }

        if (memo[amount] != Integer.MAX_VALUE) {
            return memo[amount];
        }

        int ret = Integer.MAX_VALUE;
        for (int coin : coins) {
            int temp  = dfs(coins, memo, amount - coin);
            if (temp != Integer.MAX_VALUE) {
                ret = Math.min(ret, temp + 1);
            }
        }

        memo[amount] = ret;
        return memo[amount];
    }
}
