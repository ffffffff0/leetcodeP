package main

/*
Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.

*/

/*
solution:
二分查找的过程中，记录一个变量来表示最小值，

当 nums[l] <= nums[r] 说明位于递增区间

然后根据二分查找的条件来不断缩小查找区间，从而找到最小值。

*/

func findMin(nums []int) int {
	l, r := 0, len(nums)-1

	res := nums[0]
	for l <= r {
		if nums[l] <= nums[r] {
			if nums[l] < res {
				res = nums[l]
				break
			}
		}

		m := l + (r-l)/2
		if nums[m] < res {
			res = nums[m]
		}

		if nums[m] >= nums[l] {
			l = m + 1
		} else if nums[m] < nums[l] {
			r = m - 1
		}
	}

	return res
}
