package neetcode.DP1;

import java.util.Arrays;

/*
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

示例 1：

输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 2：

输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class HouseRobber {
    /**
     *                                        arr = [1,2,3,1]
     *   rob(0) 代表从0开始抢劫的最高金额:
     *   rob(0) = Math.max(arr[0] + rob(2), rob(1));
     *   rob(1) = Math.max(arr[1] + rob(3), rob(2));
     *   ......
     *   倒过来看:
     *   每个步骤有两个选择，抢劫当前房屋，不抢劫当前房屋。
     *   rob1 代表 前一个房子所能抢劫的最大金额
     *   rob2 代表 当前房子所能抢劫的最大金额
     *   rob1, rob2 = 0, 0
     *   ==>
     *   rob1 = rob2
     *   rob2 = Math.max(arr[0] + rob1, rob2) : rob(n) = Math.max(arr[n] + rob(n-2), rob(n-1))
     *   ==>
     *                                          arr = [1,2,3,1]
     *                                          0, 1, 2, 3
     *                                          1     4        -- 抢劫0, 2: 最大 4
     *                                             2     1     -- 抢劫1, 3: 最大 3
     *
     * @param nums 输入数组
     * @return 返回最高金额
     */
    public int rob(int[] nums) {
        // dp
//        int rob1 = 0;
//        int rob2 = 0;
//
//        for (int item: nums) {
//            int temp = Math.max(item  + rob1, rob2);
//            rob1 = rob2;
//            rob2 = temp;
//        }
//
//        return rob2;
        // dfs
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);

        return dfs(nums, memo, 0);
    }

    public int dfs(int[] nums, int[] memo, int index) {
        if (index >= nums.length) {
            return 0;
        }

        if (memo[index] != -1) {
            return memo[index];
        }

        int rob = dfs(nums, memo, index + 2) + nums[index];
        int notRob = dfs(nums, memo, index + 1);

        memo[index] = Math.max(rob, notRob);

        return memo[index];
    }
}
