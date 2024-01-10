package simpleTest.oneDDynamicProgramming;

import neetcode.oneDDynamicProgramming.MinCostClimbingStairs;

public class TestMinCostClimbingStairs {
    public static void main(String[] args) {
//        输入：cost = [10,15,20]
//        输出：15
        MinCostClimbingStairs minCostClimbingStairsInstance = new MinCostClimbingStairs();
        int[] testArray = new int[]{10, 15, 20};
        int ret = minCostClimbingStairsInstance.minCostClimbingStairs(testArray);
        System.out.println(ret);
    }
}
