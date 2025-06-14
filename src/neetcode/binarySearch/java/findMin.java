
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

class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int res = nums[0];
        while (left <= right) {
            if (nums[left] <= nums[right]) {
                if (nums[left] < res) {
                    res = nums[left];
                }
            }

            int mid = left  + (right - left) / 2;
            if (nums[mid] < res) {
                res = nums[mid];
            }

            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else if (nums[mid] < nums[left]) {
                right = mid - 1;
            }
        }

        return res;
    }
}