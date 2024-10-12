package neetcode.arrayHashing.java;

import java.util.*;

/*
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

字母异位词 是由重新排列源单词的所有字母得到的一个新单词。

示例 1:

输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
示例 2:

输入: strs = [""]
输出: [[""]]
示例 3:

输入: strs = ["a"]
输出: [["a"]]
 */
public class GroupAnagrams {
    /**
     * 遍历数组，主要是利用Map来储存相同的 String 数组，使用不同字符的数量的数组作为key, 然后遍历得到结果.
     *
     * @param strs 输入字符串数组
     * @return 结果列表
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        if (strs.length == 1) {
            ret.add(new ArrayList<>(Arrays.asList(strs)));
            return ret;
        }
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            int[] keyString = new int[26];
            for (char c : str.toCharArray()) {
                keyString[c - 'a']++;
            }
            String hashKeyString = Arrays.toString(keyString);
            List<String> value = map.getOrDefault(hashKeyString, new ArrayList<>());
            value.add(str);
            map.put(hashKeyString, value);
        }

        for (String key : map.keySet()) {
            ret.add(map.get(key));
        }

        return ret;
    }
}
