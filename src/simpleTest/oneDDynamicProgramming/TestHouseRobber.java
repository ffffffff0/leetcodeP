package simpleTest.oneDDynamicProgramming;

import neetcode.oneDDynamicProgramming.HouseRobber;

public class TestHouseRobber {
    public static void main(String[] args) {
//        输入：[1,2,3,1]
//        输出：4
        HouseRobber houseRobberInstance = new HouseRobber();
        int[] testArray = new int[]{1, 2, 3, 1};
        int ret = houseRobberInstance.rob(testArray);
        System.out.println(ret);
//        输入：[2,7,9,3,1]
//        输出：12
        testArray = new int[]{2,7,9,3,1};
        ret = houseRobberInstance.rob(testArray);
        System.out.println(ret);
    }
}

