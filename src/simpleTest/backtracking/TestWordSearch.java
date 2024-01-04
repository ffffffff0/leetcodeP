package simpleTest.backtracking;

import neetcode.backtracking.WordSearch;

public class TestWordSearch {
    public static void main(String[] args) {
        WordSearch wordSearchInstance = new WordSearch();
//        示例 1：
//        输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCCED'
//        输出：true
        char[][] testArray = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String target = "ABCCED";
        boolean ret = wordSearchInstance.exists(testArray, target);
        System.out.println(ret);
//        示例 2：
//        输入：board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'SEE'
//        输出：true
        testArray = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        target = "SEEA";
        ret = wordSearchInstance.exists(testArray, target);
        System.out.println(ret);
    }
}
