package simpleTest.oneDDynamicProgramming;

import neetcode.oneDDynamicProgramming.LongestPalindromicSubstring;

public class TestLongestPalindromicSubstring {
    public static void main(String[] args) {
//        输入：s = "babad"
//        输出："bab"
        LongestPalindromicSubstring longestPalindromicSubstringInstance = new LongestPalindromicSubstring();
        String s = "babad";
        String ret = longestPalindromicSubstringInstance.longestPalindrome(s);
        System.out.println(ret);
//        输入：s = "cbbd"
//        输出："bb"
        s = "cbbd";
        ret = longestPalindromicSubstringInstance.longestPalindrome(s);
        System.out.println(ret);
    }
}
