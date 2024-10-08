package simpleTest.arrayHashing;

import neetcode.arrayHashing.java.ArraysHashing;

public class TestArraysHashing {
    public static void main(String[] args) {
//        输入：nums = [1,1,1,3,3,4,3,2,4,2]
//        输出：true
        ArraysHashing arraysHashingInstance = new ArraysHashing();
        int[] testArray = new int[]{1,1,1,3,3,4,3,2,4,2};
        boolean ret = arraysHashingInstance.containsDuplicate(testArray);
        System.out.println(ret);
    }
}
