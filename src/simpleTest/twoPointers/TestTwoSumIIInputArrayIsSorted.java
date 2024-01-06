package simpleTest.twoPointers;

import neetcode.twoPointers.TwoSumIIInputArrayIsSorted;

import java.util.Arrays;

public class TestTwoSumIIInputArrayIsSorted {
    public static void main(String[] args) {
//        输入：numbers = [2,7,11,15], target = 9
//        输出：[1,2]
        TwoSumIIInputArrayIsSorted twoSumIIInputArrayIsSortedInstance = new TwoSumIIInputArrayIsSorted();
        int[] testArray = new int[]{2, 7, 11, 15};
        int target = 9;
        int[] ret = twoSumIIInputArrayIsSortedInstance.twoSum(testArray, target);
        System.out.println(Arrays.toString(ret));

//        输入：numbers = [2,3,4], target = 6
//        输出：[1,3]
        testArray = new int[] {2, 3, 4};
        target = 6;
        ret = twoSumIIInputArrayIsSortedInstance.twoSum(testArray, target);
        System.out.println(Arrays.toString(ret));
    }
}
