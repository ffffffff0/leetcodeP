package simpleTest.twoPointers;

import neetcode.twoPointers.ContainerWithMostWater;

public class TestContainerWithMostWater {
    public static void main(String[] args) {
//        输入：[1,8,6,2,5,4,8,3,7]
//        输出：49
        ContainerWithMostWater containerWithMostWaterInstance = new ContainerWithMostWater();
        int[] testArray = new int[]{1,8,6,2,5,4,8,3,7};
        int ret = containerWithMostWaterInstance.maxArea(testArray);
        System.out.println(ret);
    }
}
