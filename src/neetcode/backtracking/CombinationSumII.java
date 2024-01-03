package neetcode.backtracking;

import java.util.*;

/*
给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
candidates 中的每个数字在每个组合中只能使用 一次 。
注意：解集不能包含重复的组合。

示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
输出:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
输出:
[
[1,2,2],
[5]
]
 */
public class CombinationSumII {
    /**
     *  这里要求每个数组只使用一次，且最后的组合不能重复。
     *                                                            [2,5,2,1,2], target = 5,
     *                                                            [1,2,2,2,5]
     *                                                               []
     *                                         |                                      |
     *                                        [1]                                    []
     *                            |                     |                 |                       |
     *                          [1,2]                  [1]               [2]                     []
     *                     |           |         |          |       |              |          |      |
     *                 [1,2,2]       [1,2]     [1,5]       [1]    [2,2]           [2]       [5]     []
     *                            |       |                     |       |      |       |
     *                       [1,2,5]    [1,2]              [2,2,2]   [2,2]   [2,5]    [2]
     *                                                             |      |
     *                                                         [2,2,5]  [2,2]
     * 防止重复，需要对原数组排序，对于不加入的分支去重判断
     * @param candidates 输入数组
     * @param target     目标值
     * @return 返回不同的组合
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(ret, new ArrayList<>(), candidates, target, 0);

        return ret;
    }

    public void dfs(List<List<Integer>> ret, List<Integer> combination, int[] candidates, int target, int index) {
        // 需要先判断 target是否为0， 后判断 index >= candidates.length
        if (target == 0) {
            ret.add(new ArrayList<>(combination));
            return;
        }
        if (index >= candidates.length || target < 0) {
            return;
        }

        // 每个数字只能选取一次
        combination.add(candidates[index]);
        dfs(ret, combination, candidates, target - candidates[index], index + 1);

        // 这边分支去除重复值
        combination.remove(combination.size() - 1);
        while (index + 1 <= candidates.length - 1 && candidates[index] == candidates[index + 1]) {
            index++;
        }
        dfs(ret, combination, candidates, target, index + 1);

    }
}
