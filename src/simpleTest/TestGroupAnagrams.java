package simpleTest;

import neetcode.GroupAnagrams;

import java.util.List;

public class TestGroupAnagrams {
    public static void main(String[] args) {
//        输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//        输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
        GroupAnagrams groupAnagramsInstance = new GroupAnagrams();
        String[] testArray = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> ret = groupAnagramsInstance.groupAnagrams(testArray);
        System.out.println(ret);
//        输入: strs = [""]
//        输出: [[""]]
        testArray = new String[]{""};
        ret = groupAnagramsInstance.groupAnagrams(testArray);
        System.out.println(ret);
    }
}
