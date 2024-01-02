package simpleTest.backtracking;

import neetcode.backtracking.SubsetsII;

import java.util.List;

public class TestSubsetsII {
    public static void main(String[] args) {
//        输入：nums = [1,2,2]
//        输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
        SubsetsII subsetsIIInstance = new SubsetsII();
        int[] testArray = new int[]{1, 2, 2};
        List<List<Integer>> ret = subsetsIIInstance.subsetsWithDup(testArray);
        System.out.println(ret);

        testArray = new int[]{4,4,4,1,4};
        ret = subsetsIIInstance.subsetsWithDup(testArray);
        System.out.println(ret);
    }
}
