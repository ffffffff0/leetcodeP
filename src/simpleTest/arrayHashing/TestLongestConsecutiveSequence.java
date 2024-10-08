package simpleTest.arrayHashing;

import neetcode.arrayHashing.java.LongestConsecutiveSequence;

public class TestLongestConsecutiveSequence {
    public static void main(String[] args) {
//        输入：nums = [100,4,200,1,3,2]
//        输出：4
//        解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
        LongestConsecutiveSequence longestConsecutiveSequenceInstance = new LongestConsecutiveSequence();
        int[] testArray = new int[]{100, 4, 200, 1, 3, 2};
        int ret = longestConsecutiveSequenceInstance.longestConsecutive(testArray);
        System.out.println(ret);
    }
}
