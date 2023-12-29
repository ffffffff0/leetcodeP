package neetcode;

import java.util.*;
import java.util.stream.Collectors;

/*
给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。

示例 1：

输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
示例 2：

输入：nums = [0,1]
输出：[[0,1],[1,0]]
示例 3：

输入：nums = [1]
输出：[[1]]
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        return dfs(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }

    /**
     * 遍历数组将当前索引的 值 取出，然后将数组变小，继续向后递归，直至数组容量变为1, 然后来开始回溯，将取出的值加会返回的数组中，即可得到不同排列.
     *                                                         [1,2,3]
     *                        use 1                             use 2                               use 3
     *                          ||                               ||                                  ||
     *                 use 2  [2,3]  use 3               use 1  [1,3]   use 3              use 1   [1,2]    use 2
     *                  ||            ||                   ||             ||                 ||              ||
     *                [[3]]          [[2]]               [[3]]           [[1]]              [[2]]          [[1]]
     *
     * @param perm 输入数组
     * @return 所有不同排列
     */
    public List<List<Integer>> dfs(List<Integer> perm) {
        if (perm.size() == 1) {
            List<List<Integer>> ret = new ArrayList<>();
            ret.add(new ArrayList<>(perm));
            return ret;
        }

        List<List<Integer>> useRet = new ArrayList<>();

        for (int i = 0; i < perm.size(); i++) {
            // 将当前索引值取出
            int n = perm.remove(i);

            List<List<Integer>> perms = dfs(perm);

            for (List<Integer> item: perms) {
                item.add(n);
            }

            useRet.addAll(perms);

            // 开始回溯
            perm.add(i, n);
        }

        return useRet;
    }

}
