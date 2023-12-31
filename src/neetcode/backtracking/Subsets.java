package neetcode.backtracking;

import java.util.*;

/*
给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。


示例 1：

输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
示例 2：

输入：nums = [0]
输出：[[],[0]]
 */
public class Subsets {

    /**
     *
     * @param nums 输入数组
     * @return 返回所有子集数组
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(ret, new ArrayList<>(), nums, 0);

        return ret;
    }

    /**
     *
     * 对于输入数组的全部子集，可以通过遍历数组，
     * 对数组当前索引有两种选择，一种是将当前索引的数字加入数组，
     * 一种是不加入，一直遍历直至输入数组遍历完全.
     *
     * @param ret 最终数组
     * @param subset 当前子集数组
     * @param nums 输入数组
     * @param index 遍历索引
     */
    public void dfs(List<List<Integer>> ret, List<Integer> subset, int[] nums, int index) {
        if (index >= nums.length) {
            ret.add(new ArrayList<>(subset));
            return;
        }

        // 使用当前索引的数字
        subset.add(nums[index]);
        dfs(ret, subset, nums, index + 1);

        // 不使用当前索引的数字
        subset.remove(subset.size() - 1);
        dfs(ret, subset, nums, index + 1);
    }
}
