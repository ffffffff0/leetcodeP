package neetcode.arrayHashing.java;

import java.util.*;

/*
设计一个将字符串列表编码为字符串的算法。 已经编码的字符串之后会通过网络发送同时也会被解码回到原始的字符串列表。
请实现 encode 和 decode

样例
样例1

输入： ["lint","code","love","you"]
输出： ["lint","code","love","you"]
解释：
一种可能的编码方式为： "lint:;code:;love:;you"
样例2

输入： ["we", "say", ":", "yes"]
输出： ["we", "say", ":", "yes"]
解释：
一种可能的编码方式为： "we:;say:;:::;yes"
标签
 */
public class EncodeAndDecodeStrings {
    /**
     * encode 规则定义为:
     * ['lint','code','love','you'] ==> 4#lint4#code4#love4#you
     * 增加长度在单词首段，防止encode含有特殊字符
     *
     * @param strs encode str array
     * @return return encode str
     */
    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();

        for (String item : strs) {
            stringBuilder.append(item.length()).append("#").append(item);
        }

        return stringBuilder.toString();
    }

    /**
     * decode 规则定义:
     * 首先解析单词长度，然后向后取单词str
     *
     * @param str encode string
     * @return array
     */
    public List<String> decode(String str) {
        List<String> ret = new ArrayList<>();

        int i = 0;
        char[] strArray = str.toCharArray();
        while (i < strArray.length) {
            int j = i;

            while (strArray[j] != '#') {
                j += 1;
            }

            int wordLength = Integer.parseInt(str.substring(i, j));

            ret.add(str.substring(j + 1, j + wordLength + 1));
            i = j + wordLength + 1;
        }

        return ret;
    }
}
