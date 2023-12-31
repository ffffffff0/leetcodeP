package simpleTest.backtracking;

import neetcode.backtracking.CombinationSum;
import java.util.*;

public class TestCombinationSum {
    public static void main(String[] args) {
//        输入：candidates = [2,3,6,7], target = 7
//        输出：[[2,2,3],[7]]
        CombinationSum combinationSumInstance = new CombinationSum();
        int[] testArray = new int[]{2, 3, 6, 7};
        List<List<Integer>> combinationRet = combinationSumInstance.combinationSum(testArray, 7);

        System.out.println(combinationRet.toString());
    }
}
