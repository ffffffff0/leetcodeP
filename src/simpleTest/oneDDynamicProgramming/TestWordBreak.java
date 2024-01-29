package simpleTest.oneDDynamicProgramming;

import neetcode.oneDDynamicProgramming.WordBreak;

import java.util.ArrayList;
import java.util.List;

public class TestWordBreak {
    public static void main(String[] args) {
//        输入: s = "leetcode", wordDict = ["leet", "code"]
//        输出: true
        WordBreak workBreakInstance = new WordBreak();
        String testString = "leetcode";
        List<String> testArray = new ArrayList<>();
        testArray.add("leet");
        testArray.add("code");
        boolean ret = workBreakInstance.wordBreak(testString, testArray);
        System.out.println(ret);
    }
}
