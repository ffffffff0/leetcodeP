package simpleTest.oneDDynamicProgramming;

import neetcode.oneDDynamicProgramming.MaximumProductSubarray;

public class TestMaximumProductSubarray {
    public static void main(String[] args) {
//        输入: nums = [2,3,-2,4]
//        输出: 6
        MaximumProductSubarray maximumProductSubarrayInstance = new MaximumProductSubarray();
        int[] testArray = new int[]{2, 3, -2, 4};
        int ret = maximumProductSubarrayInstance.maxProduct(testArray);
        System.out.println(ret);
//        输入: nums = [-2,0,-1]
//        输出: 0
        testArray = new int[]{-2, 0, -1};
        ret = maximumProductSubarrayInstance.maxProduct(testArray);
        System.out.println(ret);
    }
}
