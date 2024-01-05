package simpleTest.backtracking;

import neetcode.backtracking.PalindromePartitioning;

import java.util.List;

public class TestPalindromePartitioning {
    public static void main(String[] args) {
//        输入：s = "aab"
//        输出：[["a","a","b"],["aa","b"]]
//
        PalindromePartitioning palindromePartitioningInstance = new PalindromePartitioning();
        String testString = "aab";
        List<List<String>> ret = palindromePartitioningInstance.partition(testString);
        System.out.println(ret);

//        输入：s = "a"
//        输出：[["a"]]
        testString = "a";
        ret = palindromePartitioningInstance.partition(testString);
        System.out.println(ret);
    }
}
