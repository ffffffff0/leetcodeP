package simpleTest.backtracking;

import neetcode.backtracking.LetterCombinationsOfaPhoneNumber;

import java.util.List;

public class TestLetterCombinationsOfaPhoneNumber {
    public static void main(String[] args) {
//        输入：digits = "23"
//        输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
        LetterCombinationsOfaPhoneNumber letterCombinationsOfaPhoneNumberInstance = new LetterCombinationsOfaPhoneNumber();

        String testString = "23";
        List<String> ret = letterCombinationsOfaPhoneNumberInstance.letterCombinations(testString);
        System.out.println(ret);
    }
}
