package neetcode.backtracking;

import java.util.*;

/*
按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例 1：

输入：n = 4
输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
解释：如上图所示，4 皇后问题存在两个不同的解法。
示例 2：

输入：n = 1
输出：[["Q"]]
 */
public class NQueens {
    private Set<Integer> colSet;
    private Set<Integer> posSet;
    private Set<Integer> negSet;
    private int useN;

    /**
     * 回溯求解，这里可以看出，为了满足条件，需要把下一个棋子放置在不同行，不同斜线上。
     * 斜线可以分为两类: 正斜线 和 负斜线
     * 对于一个 4x4 的正方形棋盘:
     *  正斜线, 规律如下: (r+c) 是唯一的。
     *            - - - -
     *           |0|1|2|3|                /|
     *           - - - - -              / |
     *           |1|2|3|4|            /
     *           - - - - -          /
     *           |2|3|4|5|        /
     *           - - - - -      /
     *           |3|4|5|6|    /
     *           - - - - -  /
     *  负斜线，规律如下, (r-c) 是唯一的。
     *            - - - - - -
     *           |0|-1|-2|-3|    |\
     *           - - - - - -     | \
     *           |1|0|-1|-2|        \
     *           - - - - - -         \
     *           |2|1|0|-1|           \
     *           - - - - -             \
     *           |3|2|1|0|              \
     *           - - - - -               \
     *
     *  建立三个 set, 遍历下一个位置是否存在于set, 不存在则为有效值。
     * @param n 输入数字
     * @return 返回组合
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();

        char[][] useBoard = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(useBoard[i], '.');
        }

        useN = n;
        colSet = new HashSet<>();
        posSet = new HashSet<>();
        negSet = new HashSet<>();

        dfs(ret, useBoard, 0);

        return ret;
    }

    public void dfs(List<List<String>> ret, char[][] useBoard,  int row) {
        if (row == useN) {
            //
            List<String> tempRet = new ArrayList<>();
            for (char[] chars : useBoard) {
                StringBuilder sb = new StringBuilder();
                for (char aChar : chars) {
                    sb.append(aChar);
                }
                tempRet.add(sb.toString());
            }

            ret.add(tempRet);
            return;
        }

        for (int col = 0; col < useN; col++) {
            if (colSet.contains(col) || posSet.contains(row + col) || negSet.contains(row - col)) {
                continue;
            }

            colSet.add(col);
            posSet.add(row + col);
            negSet.add(row - col);
            useBoard[row][col] = 'Q';

            dfs(ret, useBoard, row + 1);

            // 回溯
            colSet.remove(col);
            posSet.remove(row + col);
            negSet.remove(row - col);
            useBoard[row][col] = '.';
        }
    }
}
