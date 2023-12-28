package neetcode;

import java.util.*;

/*
给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
并以列表形式返回。你可以按 任意顺序 返回这些组合。

candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。

对于给定的输入，保证和为 target 的不同组合数少于 150 个。

示例 1：

输入：candidates = [2,3,6,7], target = 7
输出：[[2,2,3],[7]]
解释：
2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
7 也是一个候选， 7 = 7 。
仅有这两种组合。
示例 2：

输入: candidates = [2,3,5], target = 8
输出: [[2,2,2,2],[2,3,3],[3,5]]
示例 3：

输入: candidates = [2], target = 1
输出: []
 */
public class CombinationSum {
    private static int[] useCandidates;
    private static int useTarget;
    private static List<List<Integer>> useRet;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        useRet = new ArrayList<>();
        useCandidates = candidates;
        useTarget = target;

        dfs(0, 0, new ArrayList<>());

        return useRet;
    }

    /**
     * 对数组的每个index做选择，每个index 有两种选择，将当前的index 加入组合中，否则不加入当前index所在的值。
     *                                                                     [2,3,6,7]
     *                                                                       []
     *                                         |                                                             |
     *                                       [2]                                                            []
     *                              |                                 |                            |                          |
     *                            [2,2]                              [2]                         [3]                         []
     *                        |               |              |                 |              |            |              |      |
     *                    [2,2,2]          [2,2]           [2,3]             [2]            [3,3]        [3]           [6]     []
     *                 |           |    |         |     |        |         |      |       |       |    |      |
     *          [2,2,2,2]    [2,2,2]  [2,2,3]   [2,2]  [2,3,3]  [2,3]     [2,3]  [2]   [3,3,3]   [3,3] [3,6]  [3]     .....
     *  这样可以使用重复的数字，确保不出现重复的组合
     * @param index 遍历索引
     * @param sum 当前组合的sum
     * @param combination 当前组合
     */
    public void dfs(int index, int sum, List<Integer> combination) {
        if (index >= useCandidates.length || sum > useTarget) {
            return;
        }

        if (sum == useTarget) {
            useRet.add(new ArrayList<>(combination));
            return;
        }

        // 将当前index的数字加入组合, 然后继续遍历
        combination.add(useCandidates[index]);
        dfs(index, sum + useCandidates[index], combination);

        // 不使用当前index的数字加入组合，然后继续向后遍历
        combination.remove(combination.size() - 1);
        dfs(index + 1, sum, combination);
    }
}
