package main

import "leetcodeP/src/neetcode/utils"

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

// TwoSum time: O(n), space: O(n)
func TwoSum(nums []int, target int) []int {
	if nums == nil || len(nums) <= 1 {
		return []int{-1, -1}
	}

	hash := make(map[int]int)

	for i, value := range nums {
		left := target - value
		if _, ok := hash[left]; ok {
			return []int{hash[left], i}
		}

		hash[value] = i
	}

	return []int{-1, -1}
}

// TwoSum brute force: time: O(n^2), space: O(1)
func TwoSum1(nums []int, target int) []int {
	if nums == nil || len(nums) <= 1 {
		return []int{-1, -1}
	}

	for i, val := range nums {
		for j := i + 1; j < len(nums); j++ {
			if val+nums[j] == target {
				return []int{i, j}
			}
		}
	}

	return []int{-1, -1}
}

// TwoSum sort, time: O(nlogn), space: O(1)
func TwoSum2(nums []int, target int) []int {
	if nums == nil || len(nums) <= 1 {
		return []int{-1, -1}
	}

	// use quick sort
	utils.QuicSort(nums, 0, len(nums)-1)

	left := 0
	right := len(nums) - 1

	for left < right {
		sum := nums[left] + nums[right]
		if sum == target {
			return []int{left, right}
		}

		if sum < target {
			left++
		} else if sum > target {
			right--
		}
	}

	return []int{-1, -1}
}
