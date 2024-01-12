package simpleTest.oneDDynamicProgramming;

import neetcode.oneDDynamicProgramming.HouseRobberII;

public class TestHouseRobberII {
    public static void main(String[] args) {
//        输入：nums = [2,3,2]
//        输出：3
        HouseRobberII houseRobberIIInstance = new HouseRobberII();
        int[] testArray = new int[]{2, 3, 2};
        int ret = houseRobberIIInstance.rob(testArray);
        System.out.println(ret);
    }
}
