package simpleTest.oneDDynamicProgramming;

import neetcode.oneDDynamicProgramming.DecodeWays;

public class TestDecodeWays {
    public static void main(String[] args) {
//        输入：s = "12"
//        输出：2
        DecodeWays decodeWaysInstance = new DecodeWays();
        String testString = "12";
        int ret = decodeWaysInstance.numDecodings(testString);
        System.out.println(ret);
        assert ret == 2;
//        输入：s = "226"
//        输出：3
        testString = "226";
        ret = decodeWaysInstance.numDecodings(testString);
        System.out.println(ret);
        assert ret == 3;
//        输入：s = "06"
//        输出：0
        testString = "06";
        ret = decodeWaysInstance.numDecodings(testString);
        System.out.println(ret);
        assert ret == 0;
    }
}
