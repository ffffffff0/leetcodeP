package simpleTest;

import neetcode.arrayHashing.ValidSudoku;

public class TestValidSudoku {
    public static void main(String[] args) {
//        输入：board =
//        [['5','3','.','.','7','.','.','.','.']
//        ,['6','.','.','1','9','5','.','.','.']
//        ,['.','9','8','.','.','.','.','6','.']
//        ,['8','.','.','.','6','.','.','.','3']
//        ,['4','.','.','8','.','3','.','.','1']
//        ,['7','.','.','.','2','.','.','.','6']
//        ,['.','6','.','.','.','.','2','8','.']
//        ,['.','.','.','4','1','9','.','.','5']
//        ,['.','.','.','.','8','.','.','7','9']]
//        输出：true
        ValidSudoku validSudokuInstance = new ValidSudoku();
        char[][] testArray = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'},
        };

        boolean ret = validSudokuInstance.isValidSudoku(testArray);
        System.out.println(ret);
//        输入：board =
//        [['8','3','.','.','7','.','.','.','.']
//        ,['6','.','.','1','9','5','.','.','.']
//        ,['.','9','8','.','.','.','.','6','.']
//        ,['8','.','.','.','6','.','.','.','3']
//        ,['4','.','.','8','.','3','.','.','1']
//        ,['7','.','.','.','2','.','.','.','6']
//        ,['.','6','.','.','.','.','2','8','.']
//        ,['.','.','.','4','1','9','.','.','5']
//        ,['.','.','.','.','8','.','.','7','9']]
//        输出：false
        testArray = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        ret = validSudokuInstance.isValidSudoku(testArray);
        System.out.println(ret);
    }
}
