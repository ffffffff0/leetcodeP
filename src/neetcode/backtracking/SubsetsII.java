package neetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。

解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。

示例 1：

输入：nums = [1,2,2]
输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
示例 2：

输入：nums = [0]
输出：[[],[0]]
 */
public class SubsetsII {
    /**
     * 对于输入数组的全部子集，可以通过遍历数组，
     * 对数组当前索引有两种选择，一种是将当前索引的数字加入数组，
     * 一种是不加入，一直遍历直至输入数组遍历完全.
     * <p>
     *                                                       [1,2,2]
     *                                                         []
     *                                          |                              |
     *                                         [1]                            []
     *                                   |           |                    |         |
     *                               [1,2]          [1]                [1]         []
     *                              |     |      |      |            |      |     |    |
     *                        [1,2,2] *[1,2]* *[1,2]*  [1]           .......
     * 如此这般会出现重复，但是为了去重，需要先排序, 对于不加入分支的遍历,
     * 需要检查当前值时候和后续值重复，如果重复则跳过，选取下一个不重复的值.
     *
     * @param nums 输入数组
     * @return 返回子集
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        dfs(ret, nums, 0, new ArrayList<>());
        return ret;
    }

    public void dfs(List<List<Integer>> ret, int[] nums, int index, List<Integer> subset) {
        if (index >= nums.length) {
            ret.add(new ArrayList<>(subset));
            return;
        }

        // 选取当前索引值加入遍历
        subset.add(nums[index]);
        dfs(ret, nums, index + 1, subset);

        // 不加入当前值, 继续遍历
        subset.remove(subset.size() - 1);
        while (index + 1 <= nums.length - 1 && nums[index] == nums[index+1]) {
            // 排除重复值
            index++;
        }
        dfs(ret, nums, index + 1, subset);
    }
}
