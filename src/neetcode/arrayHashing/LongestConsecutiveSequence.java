package neetcode.arrayHashing;

import java.util.HashSet;
import java.util.Set;

/*
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

示例 1：

输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
示例 2：

输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
 */
public class LongestConsecutiveSequence {
    /**
     * 为了实现 time: O(n)
     * 这里可以选取 一些值的, 如 n, 判断 n-1 是否存在当前的数组中，如果不在说明这个值 n 可能是最大连续数组的起点，然后将这些遍历求解。
     * [100,4,200,1,3,2]
     * => 100: [100]      length=1
     * => 200: [200]      length=1
     * => 1  : [1,2,3,4]  length=4
     *
     * @param nums 输入数组
     * @return 返回最长连续数组的长度
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int item: nums) {
            set.add(item);
        }

        int longest = 0;
        // 找到可能最大连续数组的起点
        for (int item: nums) {
            if (!set.contains(item - 1)) {
                int length = 0;
                while (set.contains(item + length)) {
                    length++;
                }
                longest = Math.max(length, longest);
            }
        }

        return longest;
    }
}
