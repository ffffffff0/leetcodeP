package neetcode.arrayHashing;

/*
给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
请 不要使用除法，且在 O(n) 时间复杂度内完成此题。

示例 1:

输入: nums = [1,2,3,4]
输出: [24,12,8,6]
示例 2:

输入: nums = [-1,1,0,-3,3]
输出: [0,0,9,0,0]

 */
public class ProductOfArrayExceptSelf {
    /**
     * 这里可以建立两个数组，prefix and  postfix, 分别表示 从左到右的累积，从右到左的累积
     * [1,2,3,4]
     * prefix:  [1,2,6,24]
     * postfix: [24,24,12,4]
     * return array: ret[i] = prefix[i-1] * postfix[i+1], 如果索引超出则返回1
     * ret:     [24,13,8,6]
     * <p>
     * 更好的办法是，将 prefix 和 postfix 数组转为一个数组,
     * 首先从左到右计算一边，然后从右到左计算一边，从而得到计算结果, 这个时候把当前索引的值剔除。
     *
     * @param nums 输入数组
     * @return 返回数组
     */
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];

        // 从左到右计算乘积，但是排除当前索引的值
        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            ret[i] = prefix;
            prefix *= nums[i];
        }

        // 从右到左计算乘积，但是排除当前索引的值
        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            ret[i] *= postfix;
            postfix *= nums[i];
        }

        return ret;
    }

}
