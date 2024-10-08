package neetcode.arrayHashing;

import java.util.*;

/*
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

示例 1:

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
 */
public class TopKFrequentElements {
    /**
     * 桶排序: time: O(n), space: O(n)
     * 首先计算数组中元素的出现的频率,map, key: element, value: count
     * 然后将map中的值放入一个size: k数组中， value: count 为 index, key: element 为值，
     * 遍历数组即可
     *
     * @param nums 输入数组
     * @param k    频率最高的前K
     * @return 返回数组
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums.length == 1) {
            return nums;
        }

        // 计算元素出现频率
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int item : nums) {
            freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
        }

        // 转入数组中, 使用 List<Integer>[], size: nums.length +1
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int key : freqMap.keySet()) {
            int cnt = freqMap.get(key);

            if (bucket[cnt] == null) {
                bucket[cnt] = new ArrayList<>();
            }
            bucket[cnt].add(key);
        }

        // 遍历得到结果
        List<Integer> topK = new ArrayList<>(nums.length);
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                List<Integer> value = bucket[i];
                if (value.size() > k - topK.size()) {
                    for (int j = 0; j < k - topK.size(); j++) {
                        topK.add(value.get(i));
                    }
                } else {
                    topK.addAll(value);
                }
            }
        }

        // 建立返回数组
        int[] ret = new int[topK.size()];
        for (int i=0; i<topK.size(); i++) {
            ret[i] = topK.get(i);
        }

        return ret;
    }
}
