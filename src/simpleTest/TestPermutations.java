package simpleTest;

import neetcode.backtracking.Permutations;

import java.util.*;

public class TestPermutations {
    public static void main(String[] args) {
//        输入：nums = [1,2,3]
//        输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        Permutations permutationsInstance = new Permutations();
        int[] testArray = new int[]{1, 2, 3};
        List<List<Integer>> permuteRet = permutationsInstance.permute(testArray);

        System.out.println(permuteRet.toString());
    }
}
