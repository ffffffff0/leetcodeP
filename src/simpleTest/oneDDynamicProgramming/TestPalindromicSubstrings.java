package simpleTest.oneDDynamicProgramming;

import neetcode.oneDDynamicProgramming.PalindromicSubstrings;

public class TestPalindromicSubstrings {
    public static void main(String[] args) {
//        输入：s = "abc"
//        输出：3
        PalindromicSubstrings palindromicSubstringsInstance = new PalindromicSubstrings();
        String testString = "abc";
        int ret = palindromicSubstringsInstance.countSubstrings(testString);
        System.out.println(ret);
        assert ret == 3;
//        输入：s = "aaa"
//        输出：6
        testString = "aaa";
        ret = palindromicSubstringsInstance.countSubstrings(testString);
        System.out.println(ret);
        assert ret == 6;
    }
}
