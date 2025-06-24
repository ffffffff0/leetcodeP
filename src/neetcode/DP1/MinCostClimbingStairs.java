package neetcode.DP1;

import java.util.Arrays;

/*
给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
请你计算并返回达到楼梯顶部的最低花费。

示例 1：

输入：cost = [10,15,20]
输出：15
解释：你将从下标为 1 的台阶开始。
- 支付 15 ，向上爬两个台阶，到达楼梯顶部。
总花费为 15 。
示例 2：

输入：cost = [1,100,1,1,1,100,1,1,100,1]
输出：6
解释：你将从下标为 0 的台阶开始。
- 支付 1 ，向上爬两个台阶，到达下标为 2 的台阶。
- 支付 1 ，向上爬两个台阶，到达下标为 4 的台阶。
- 支付 1 ，向上爬两个台阶，到达下标为 6 的台阶。
- 支付 1 ，向上爬一个台阶，到达下标为 7 的台阶。
- 支付 1 ，向上爬两个台阶，到达下标为 9 的台阶。
- 支付 1 ，向上爬一个台阶，到达楼梯顶部。
总花费为 6 。
 */
public class MinCostClimbingStairs {
    /**
     * 到达 0 处顶端的最小花费
     *                                      [10, 15, 20] 0
     *                                          []
     *                             | 10                   | 10
     *                             1                      2
     *                     | 15           | 15    | 20            | 20
     *                     2             3        3               4
     *           | 20          | 20
     *           3             4
     * dp[0] 代表从0处爬到顶端的最小花费
     * dp[0] = Math.min(dp[1] + cost[0], dp[2] + cost[0]) => dp[i] = Math.min(dp[i+1] + cost[i], dp[i+2] + cost[i])
     * 但是从后部来看, 一个数组长度为n, dp[n-1] = cost[n-1], dp[n] = 0, 因为dp[n] 就在顶点。
     * dp[n-2] = Math.min(dp[n-1], dp[n]) + cost[n-2]
     * 也就可以推的所有的值。dp[0...n]
     *
     * @param cost 输入cost 数组
     * @return 返回最小cost
     */
    public int minCostClimbingStairs(int[] cost) {
        // dfs method
        int[] memo = new int[cost.length];
        Arrays.fill(memo, -1);

        return Math.min(dfs(memo, cost, 0), dfs(memo, cost, 1));
        // dp
//        int n = cost.length + 1;
//        int[] dp = new int[n];
//
//        dp[n - 1] = 0;
//        dp[n - 2] = cost[n - 2];
//
//        for (int i = n - 3; i >= 0; i--) {
//            dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
//        }
//        System.out.println(Arrays.toString(dp));
//        return Math.min(dp[0], dp[1]);
    }

    public int dfs(int[] memo, int[] cost, int index) {
        if (index >= memo.length) {
            return 0;
        }
        if (memo[index] != -1) {
            return memo[index];
        }

        memo[index] = cost[index] + Math.min(dfs(memo, cost, index + 1), dfs(memo, cost, index + 2));
        return memo[index];
    }
}
