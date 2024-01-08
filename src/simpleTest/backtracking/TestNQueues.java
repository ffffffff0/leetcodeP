package simpleTest.backtracking;

import neetcode.backtracking.NQueens;

import java.util.List;


public class TestNQueues {
    public static void main(String[] args) {
//        输入：n = 4
//        输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
        NQueens nQueens = new NQueens();
        int testN = 4;
        List<List<String>> ret = nQueens.solveNQueens(testN);
        System.out.println(ret);
//        输入：n = 1
//        输出：[["Q"]]
        testN = 1;
        ret = nQueens.solveNQueens(testN);
        System.out.println(ret);
    }
}
