package neetcode.arrayHashing;

import java.util.*;

/*
请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）

注意：
一个有效的数独（部分已被填充）不一定是可解的。
只需要根据以上规则，验证已经填入的数字是否有效即可。
空白格用 '.' 表示。
输入：board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
输出：true
示例 2：

输入：board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
输出：false
解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
 */
public class ValidSudoku {
    /**
     *
     * 可以使用三个Map来实现求解:
     *  1. 对于每行不同，遍历数组是，将每行元素放入set中，以此判断
     *  2. 对于每列不同，与行相同
     *  3. 对于 3x3 的方格，将当前行列索引除以3， [row/3, col/3] 来标识不同的方格
     *
     * @param board 输入二维数组
     * @return 是否为数独数组
     */
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> row = new HashMap<>();
        Map<Integer, Set<Integer>> col = new HashMap<>();
        Map<String, Set<Integer>> grid = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }

                int number = board[i][j] - '0';
                String gridKey = Arrays.toString(new int[]{i / 3, j / 3});

                Set<Integer> rowSet = row.getOrDefault(i, new HashSet<>());
                Set<Integer> colSet = col.getOrDefault(j, new HashSet<>());
                Set<Integer> gridSet = grid.getOrDefault(gridKey, new HashSet<>());
                if (rowSet.contains(number) ||
                    colSet.contains(number) ||
                    gridSet.contains(number)) {
                    return false;
                }

                rowSet.add(number);
                row.put(i, rowSet);

                colSet.add(number);
                col.put(j, colSet);

                gridSet.add(number);
                grid.put(gridKey, gridSet);

            }
        }

        return true;
    }

}