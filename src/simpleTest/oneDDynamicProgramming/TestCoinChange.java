package simpleTest.oneDDynamicProgramming;

import neetcode.oneDDynamicProgramming.CoinChange;

public class TestCoinChange {
    public static void main(String[] args) {
//        输入：coins = [1, 2, 5], amount = 11
//        输出：3
        CoinChange coinChangeInstance = new CoinChange();
        int[] testArray = new int[]{1, 2, 5};
        int amount = 11;
        int ret = coinChangeInstance.coinChange(testArray, amount);
        System.out.println(ret);
        assert ret == 3;
//        输入：coins = [2], amount = 3
//        输出：-1
        testArray = new int[]{2};
        amount = 3;
        ret = coinChangeInstance.coinChange(testArray, amount);
        System.out.println(ret);
        assert ret == -1;
//        输入：coins = [1], amount = 0
//        输出：0
        testArray = new int[]{1};
        amount = 0;
        ret = coinChangeInstance.coinChange(testArray, amount);
        System.out.println(ret);
        assert ret == 0;
    }
}
