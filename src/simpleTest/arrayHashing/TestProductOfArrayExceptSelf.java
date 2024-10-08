package simpleTest.arrayHashing;

import neetcode.arrayHashing.java.ProductOfArrayExceptSelf;

import java.util.Arrays;

public class TestProductOfArrayExceptSelf {
    public static void main(String[] args) {
//        输入: nums = [1,2,3,4]
//        输出: [24,12,8,6]
        ProductOfArrayExceptSelf productOfArrayExceptSelfInstance = new ProductOfArrayExceptSelf();
        int[] testArray = new int[]{1, 2, 3, 4};
        int[] ret = productOfArrayExceptSelfInstance.productExceptSelf(testArray);
        System.out.println(Arrays.toString(ret));
    }
}
