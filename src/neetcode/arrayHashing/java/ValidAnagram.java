package neetcode.arrayHashing.java;

import java.util.HashMap;
import java.util.Objects;

/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。

示例 1:

输入: s = "anagram", t = "nagaram"
输出: true
示例 2:

输入: s = "rat", t = "car"
输出: false
 */
public class ValidAnagram {
    /**
     * 1. 使用额外的数组来判断，字符的数量是否一致, time: O(n), space: O(n)
     * 2. 排序，对字符串排序，如果相等，其排序后的字符串应该一致, time: O(nlogn), space: O(1)
     *
     * @param s strings
     * @param t string t
     * @return 返回是否为字母异位词
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (Character item : sMap.keySet()) {
            if (!Objects.equals(sMap.get(item), tMap.get(item))) {
                return false;
            }
        }

        return true;
    }
}
