package simpleTest.backtracking;

import neetcode.backtracking.CombinationSumII;

import java.util.List;

public class TestCombinationSumII {
    public static void main(String[] args) {
//        输入: candidates = [10,1,2,7,6,1,5], target = 8,
//        输出:
//        [
//        [1,1,6],
//        [1,2,5],
//        [1,7],
//        [2,6]
//        ]
        CombinationSumII combinationSumIIInstance = new CombinationSumII();
        int[] testArray = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> ret = combinationSumIIInstance.combinationSum2(testArray, target);
        System.out.println(ret);
//        输入: candidates = [2,5,2,1,2], target = 5,
//        输出:
//        [
//        [1,2,2],
//        [5]
//        ]
        testArray = new int[]{2, 5, 2, 1, 2};
        target = 5;
        ret = combinationSumIIInstance.combinationSum2(testArray, target);
        System.out.println(ret);
    }
}
