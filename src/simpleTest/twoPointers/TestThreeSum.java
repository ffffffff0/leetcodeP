package simpleTest.twoPointers;

import neetcode.twoPointers.ThreeSum;

import java.util.List;

public class TestThreeSum {
    public static void main(String[] args) {
//        输入：nums = [-1,0,1,2,-1,-4]
//        输出：[[-1,-1,2],[-1,0,1]]
        ThreeSum threeSumInstance = new ThreeSum();
        int[] testArray = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ret = threeSumInstance.threeSum(testArray);
        System.out.println(ret);
//        输入：nums = [0,1,1]
//        输出：[]
        testArray = new int[]{0, 1, 1};
        ret = threeSumInstance.threeSum(testArray);
        System.out.println(ret);
//        输入：nums = [0,0,0]
//        输出：[[0,0,0]]
        testArray = new int[]{0, 0, 0};
        ret = threeSumInstance.threeSum(testArray);
        System.out.println(ret);
    }
}
