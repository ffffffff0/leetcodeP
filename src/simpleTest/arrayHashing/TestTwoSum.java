package simpleTest.arrayHashing;

import neetcode.arrayHashing.java.TwoSum;

import java.util.Arrays;

public class TestTwoSum {
    public static void main(String[] args) {
//        输入：nums = [2,7,11,15], target = 9
//        输出：[0,1]
        TwoSum twoSumInstance = new TwoSum();
        int[] testArray = new int[]{2, 7, 11, 15};
        int target = 9;

        int[] ret = twoSumInstance.twoSum(testArray, target);
        System.out.println(Arrays.toString(ret));
    }
}
