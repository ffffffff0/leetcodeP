package neetcode.DP1;

/*
给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
测试用例的答案是一个 32-位 整数。
子数组 是数组的连续子序列。

示例 1:

输入: nums = [2,3,-2,4]
输出: 6
解释: 子数组 [2,3] 有最大乘积 6。
示例 2:

输入: nums = [-2,0,-1]
输出: 0
解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 */
public class MaximumProductSubarray {
    /**
     *                                                       [2,3,-2,4], init curMax = 1, curMin = 1
     *     2: max=2, min=1
     *     3: max=6, min=1
     *    -2: max= max(-2, -2 * 6, -2 * 1) = -2, min= min(-2, -2 * 6, -2 * 1) = -12
     *     4: max= max(4, 4 * -2, 4 * -12) =  4, min= min(4, 4 * -2, 4 * -12) = -48
     *
     *     curMax = max(curMax * n, curMin * n, n), 判断了三种情况: 1. 不考虑前面的影响, 从当前索引开始 (n).
     *                                                           2. 将前面的乘积继续和当前索引累积 (curMax * n).
     *                                                           3. 考虑如果前面为负数的情况 (curMin * n).
     *
     *  1. 如果整个数组全是正数，则最大的连续子数组一定是整个数组，正数的累积一定是越来越大
     *  2. 存在负数会影响数值的大小，存在两个负数则可能会最大值，
     *     为了判断这种情况所以有维持两个变量 curMax, curMin, 来在迭代过程中计算连续的最大乘积
     *  3. 遇到 0 时， 需要重置 curMax, curMin = 1
     * @param nums 输入数组
     * @return 返回最大乘积
     */
    public int maxProduct(int[] nums) {
        int ret = 0;
        int curMax = 1;
        int curMin = 1;

        for (int num : nums) {
            if (num == 0) {
                curMax = 1;
                curMin = 1;
            }

            curMax = Math.max(num, Math.max(curMax * num, curMin * num));
            curMin = Math.min(num, Math.min(curMax * num, curMin * num));

            ret = Math.max(ret, curMax);
        }

        return ret;
    }
}
