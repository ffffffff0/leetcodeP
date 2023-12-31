package simpleTest;

import neetcode.backtracking.Subsets;

import java.util.List;

public class TestSubsets {
    public static void main(String[] args) {
//        输入：nums = [1,2,3]
//        输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        Subsets subsetsInstance = new Subsets();
        int[] testArray = new int[]{1, 2, 3};
        List<List<Integer>> subsetRet = subsetsInstance.subsets(testArray);

        System.out.println(subsetRet.toString());
    }
}
