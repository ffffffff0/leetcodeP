package neetcode.DP1;

/*
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。

示例 1：

输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
示例 2：

输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。
示例 3：

输入：nums = [1,2,3]
输出：3
 */
public class HouseRobberII {
    /**
     *                                                      nums = [2,3,2]
     * 类似 HouseRobberI 中，首尾相邻，可以直接判断是否抢劫最后一个房子，来判断最大值。
     * @param nums 输入数组
     * @return 返回最大金额
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        return Math.max(helper(nums, 0, nums.length - 2),
                        helper(nums, 1, nums.length - 1));
    }

    public int helper(int[] nums, int start, int end) {
        int rob1 = 0;
        int rob2 = 0;

        for (int i = start; i <= end; i++) {
            int newRob = Math.max(nums[i] + rob1, rob2);
            rob1 = rob2;
            rob2 = newRob;
        }

        return rob2;
    }
}
