package neetcode.arrayHashing;


import java.util.HashSet;

/*
给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。

示例 1：

输入：nums = [1,2,3,1]
输出：true
示例 2：

输入：nums = [1,2,3,4]
输出：false
示例 3：

输入：nums = [1,1,1,3,3,4,3,2,4,2]
输出：true
 */
public class ArraysHashing {
    /**
     * 1. 暴力遍历: time: O(n^2), space: O(1)
     * 2. 排序: 排序后，重新遍历一次, time: O(nlogn) space: O(1)
     * 3. hashSet: 使用 hashSet 遍历, time: O(n), space: O(n)
     * @param nums 输入数组
     * @return 返回是否存在重复数字
     */
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int item: nums) {
            if (set.contains(item)) {
                return true;
            }

            set.add(item);
        }

        return false;
    }
}
