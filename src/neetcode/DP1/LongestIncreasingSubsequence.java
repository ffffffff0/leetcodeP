package neetcode.oneDDynamicProgramming;

import java.util.*;
/*
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

示例 1：

输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
示例 2：

输入：nums = [0,1,0,3,2,3]
输出：4
示例 3：

输入：nums = [7,7,7,7,7,7,7]
输出：1
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {

        List<Integer> dp = new ArrayList<>();
        dp.add(nums[0]);

        int res = 1;
        for (int n : nums) {
            if (n > dp.get(dp.size()-1)) {
                dp.add(n);
                res++;
                continue;
            }

            // update max value in dp array
            int idx = search(nums, n);
            dp.add(idx, n);
        }

        return res;
    }

    public int search(int[] nums, int target) {
        // for search greater than target first index
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (target >= nums[mid]) {
                right = mid;
            } else if (target < nums[mid]) {
                left = mid + 1;
            }
        }

        return left;
    }
}
