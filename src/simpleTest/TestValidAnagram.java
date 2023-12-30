package simpleTest;

import neetcode.ValidAnagram;

public class TestValidAnagram {
    public static void main(String[] args) {
//        输入: s = "anagram", t = "nagaram"
//        输出: true
        ValidAnagram validAnagramInstance = new ValidAnagram();
        String sString = "anagram";
        String tString = "nagaram";

        boolean ret = validAnagramInstance.isAnagram(sString, tString);
        System.out.println(ret);

        sString = "rat";
        tString = "car";
        ret = validAnagramInstance.isAnagram(sString, tString);
        System.out.println(ret);
    }
}
