package simpleTest.arrayHashing;

import neetcode.arrayHashing.EncodeAndDecodeStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestEncodeAndDecodeStrings {
    public static void main(String[] args) {
//        输入： ["lint","code","love","you"]
//        输出： ["lint","code","love","you"]
//        解释：
//        一种可能的编码方式为： "lint:;code:;love:;you"
        EncodeAndDecodeStrings encodeAndDecodeStringsInstance = new EncodeAndDecodeStrings();
        List<String> testArray = new ArrayList<>();
        testArray.add("lint");
        testArray.add("code");
        testArray.add("love");
        testArray.add("you");

        System.out.println("string array: " + testArray);
        String encodeRet = encodeAndDecodeStringsInstance.encode(testArray);
        System.out.println("encode ret: " + encodeRet);
        List<String> decodeRet = encodeAndDecodeStringsInstance.decode(encodeRet);
        System.out.println("decode ret: " + decodeRet);
    }
}
