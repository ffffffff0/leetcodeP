package simpleTest.twoPointers;

import neetcode.twoPointers.ValidPalindrome;

public class TestValidPalindrome {
    public static void main(String[] args) {
//        输入: s = "A man, a plan, a canal: Panama"
//        输出：true
        ValidPalindrome validPalindromeInstance = new ValidPalindrome();
        String testString = "A man, a plan, a canal: Panama";
        boolean ret = validPalindromeInstance.isPalindrome(testString);
        System.out.println(ret);
//        输入：s = "race a car"
//        输出：false
        testString = "race a car";
        ret = validPalindromeInstance.isPalindrome(testString);
        System.out.println(ret);
//        输入：s = "0p"
//        输出：false
        testString = "0p";
        ret = validPalindromeInstance.isPalindrome(testString);
        System.out.println(ret);
    }
}
