package neetcode.arrayHashing;


import java.util.HashMap;
import java.util.Map;

/*
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

你可以按任意顺序返回答案。

示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]
 */
public class TwoSum {
    /**
     * 使用一个map 数组记录 数组的当前值和索引， 然后遍历数组的过程中，判断 target - current 的值是否存在的map中
     *
     * @param nums   输入数组
     * @param target 目标值
     * @return 返回索引数组
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            // 这里不能首先将 nums[i] 放到map中去，可能存在如下的情况:
            // [2, 1, 5, 3], target=4
            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
