package neetcode.oneDDynamicProgramming;

/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

示例 1：

输入：n = 2
输出：2
解释：有两种方法可以爬到楼顶。
1. 1 阶 + 1 阶
2. 2 阶
示例 2：

输入：n = 3
输出：3
解释：有三种方法可以爬到楼顶。
1. 1 阶 + 1 阶 + 1 阶
2. 1 阶 + 2 阶
3. 2 阶 + 1 阶
 */
public class ClimbingStairs {
    /**
     *  n = 5: 左分支+1, 右分支+2
     *                                            []
     *                                |                        |
     *                                1                        2
     *                           |        |                |       |
     *                           2        3                3       5
     *                        |       |      |          |     |
     *                        3       4      5          4     5
     *                    |     |  |     |           |     |
     *                    4     5  5     6           5     6
     *                 |     |
     *                 5     6
     *  可以看出，有许多重复的节点，可以建立一个数组缓存已经计算的节点.
     *  从另一个角度来看，可以从底向上来看:
     *  f(5) = 1, 默认值 1
     *  f(4) = 1, 从台阶4爬到台阶5, 只有一种方法, 一次跨一步
     *  f(3) = f(4) + f(5), f(3) 有一种方法一次一步爬到 f(4), f(3) 有一种方法一次二步爬到 f(5).
     *  f(2) = f(3) + f(4), ...
     *  f(1) = f(2) + f(3), ...
     *  f(0) = f(1) + f(2), ...
     * @param n n个台阶
     * @return 返回不同方法
     */
    public int climbStairs(int n) {
        // dfs method
//        int[] memo = new int[n];
//        Arrays.fill(memo, -1);
//        return dfs(memo, 0, n);
        // bottom-top method
        int one = 1;
        int two = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }

    public int dfs(int[] memo, int sum, int n) {
        if (sum > n) {
            return 0;
        }
        if (sum == n) {
            return 1;
        }

        if (memo[sum] != -1) {
            return memo[sum];
        }

        int ret = dfs(memo, sum + 1, n) + dfs(memo, sum + 2, n);
        memo[sum] = ret;

        return memo[sum];
    }


}
