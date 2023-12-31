package simpleTest.arrayHashing;

import neetcode.arrayHashing.TopKFrequentElements;

import java.util.Arrays;

public class TestTopKFrequentElements {
    public static void main(String[] args) {
//        输入: nums = [1,1,1,2,2,3], k = 2
//        输出: [1,2]
        TopKFrequentElements topKFrequentElementsInstance = new TopKFrequentElements();
        int[] testArray = new int[]{1,1,1,2,2,3};
        int k = 2;
        int[] ret = topKFrequentElementsInstance.topKFrequent(testArray, k);
        System.out.println(Arrays.toString(ret));

//        输入: nums = [-1,-1], k = 1
//        输出: [-1]
        testArray = new int[]{-1, -1};
        k = 1;
        ret = topKFrequentElementsInstance.topKFrequent(testArray, k);
        System.out.println(Arrays.toString(ret));
    }
}
