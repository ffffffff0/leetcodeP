package neetcode.backtracking;

/*
给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例 1：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true

示例 2：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
输出：true
 */
public class WordSearch {
    private char[][] useBoard;
    private char[] useWord;
    private final int[][] direction = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    private int useRowLength;
    private int useColLength;
    private boolean[][] used;

    /**
     * 相当于暴力求解，从二维数组的每个位置出发，向四个方向遍历求解。
     *
     * @param board 输入数组
     * @param word  目标词
     * @return 返回结果
     */
    public boolean exist(char[][] board, String word) {
        useBoard = board;
        useWord = word.toCharArray();

        useRowLength = board.length;
        useColLength = board[0].length;

        used = new boolean[useRowLength][useColLength];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(int r, int c, int index) {
        if (index == useWord.length) {
            return true;
        }
        if (r >= useRowLength || c >= useColLength ||
                r < 0 || c < 0 ||
                useBoard[r][c] != useWord[index] ||
                used[r][c]) {
            return false;
        }

        used[r][c] = true;

        for (int[] item : direction) {
            if (dfs(r + item[0], c + item[1], index + 1)) {
                return true;
            }
        }
        used[r][c] = false;

        return false;
    }
}
