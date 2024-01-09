package simpleTest.oneDDynamicProgramming;

import neetcode.oneDDynamicProgramming.ClimbingStairs;

public class TestClimbingStairs {
    public static void main(String[] args) {
//        输入：n = 2
//        输出：2
        ClimbingStairs climbingStairsInstance = new ClimbingStairs();
        int ret = climbingStairsInstance.climbStairs(2);
        System.out.println(ret);
//        输入：n = 3
//        输出：3
        ret = climbingStairsInstance.climbStairs(3);
        System.out.println(ret);
//        输入：n = 5
//        输出：8
        ret = climbingStairsInstance.climbStairs(5);
        System.out.println(ret);
    }
}
